package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CommonPage;
import pages.SignUpFirstNameValidationPage;
import pages.SignUpLastNameValidationPage;
import pages.SignUpValidationPage;
import utils.Driver;
import utils.TestDataReader;

public class SignUpLastNameValidation {

	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

@Test (dataProvider = "lastNameValidation")

public void LastNameValidate(String testLastName) {

//When I navigate to the ‘Sign Up’ screen, 
	CommonPage commonpage = new CommonPage();
	SignUpValidationPage  signUpPageValidate = new  SignUpValidationPage();
	SignUpLastNameValidationPage lastNameValidate = new SignUpLastNameValidationPage();

	Driver.getDriver().get(TestDataReader.getProperty("ecommerceStoreUrl"));

	commonpage.welcomeLink.click();
	commonpage.signUpButton.click();
	

	String actualText = lastNameValidate.lastNameField.getText().substring(1, testLastName.length() + 1);
	System.out.println(actualText + " " + testLastName.length());
	
//And I click on ‘SIGN UP’ Button, 
	 signUpPageValidate.signUpBtn.click();
	 
//Then:
//1. The system should validate that the Last Name entered is less than or equal to 50 alphabetical characters in length. 
//If the entered First Name is greater than 50 characters in length then I should see the following inline error message:
//”The lastName may not be greater than 50 characters.”
	 Assert.assertTrue(lastNameValidate.LastNameLengthErrorMessage.isDisplayed());
	 
//2. The system should validate that the Last Name entered does not contain non-alphabetical characters. 
//If the entered First Name entered does contains non-alphabetical characters then I should see the following inline error message:
//”The lastName format is invalid.”
	 Assert.assertTrue(lastNameValidate.LastNameCharacterErrorMessage.isDisplayed());
	
}
//And I enter a value within the 'Last Name’ Textbox
@DataProvider
public String[] lastNameValidation() {
	String[] testLastName = new String[2];
	testLastName[0] = "Smithhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh";
	testLastName[1] = "123en";
	
	return testLastName;



}
@AfterMethod
public void quitDriver() {
	Driver.quitDriver();
}

}