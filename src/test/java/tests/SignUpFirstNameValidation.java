package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CommonPage;
import pages.SignUpEmailValidationPage;
import pages.SignUpFirstNameValidationPage;
import pages.SignUpValidationPage;
import utils.Driver;
import utils.TestDataReader;

public class SignUpFirstNameValidation {

	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test (dataProvider = "firstNameValidation")
	
	public void signUpFirstName (String testFirstName ) {
	//When I navigate to the ‘Sign Up’ screen, 
		CommonPage commonpage = new CommonPage();
		SignUpValidationPage  signUpPageValidate = new  SignUpValidationPage();
		SignUpFirstNameValidationPage firstNameValidate = new SignUpFirstNameValidationPage();

		Driver.getDriver().get(TestDataReader.getProperty("ecommerceStoreUrl"));

		commonpage.welcomeLink.click();
		commonpage.signUpButton.click();
		

		String actualText = firstNameValidate.firstNameField.getText().substring(1, testFirstName.length() + 1);
		System.out.println(actualText + " " + testFirstName.length());
		
	//And I click on ‘Sign Up’ Button, 
	   signUpPageValidate.signUpBtn.click();
	
	//Then:
	//1. The system should validate that the First Name entered is less than or equal to 50 alphabetical characters in length.   
	//If the entered First Name is greater than 50 characters in length then I should see the following inline error message:
	//”The firstName may not be greater than 50 characters.”
	   Assert.assertTrue(firstNameValidate.FirstNameLengthErrorMessage.isDisplayed());
	   
	//2. The system should validate that the First Name entered does not contain non-alphabetical characters. 
	//If the entered First Name entered does contains non-alphabetical characters then I should see the following inline error message:
	//”The firstName format is invalid.”
	   Assert.assertTrue(firstNameValidate.FirstNameCharacterErrorMessage.isDisplayed());
	   
	}
	
	//And I enter a value within the 'First Name’ Textbox
	   @DataProvider
	   public String[] firstNameValidation() {
	   	String[] testFirstName = new String[2];
	   	testFirstName[0] = "Johnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn";
	   	testFirstName[1] = "123an";
	   	return testFirstName;
	   

	
	}
	@AfterMethod
	public void quitDriver() {
		Driver.quitDriver();
}
}