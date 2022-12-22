package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CommonPage;
import pages.SignUpEmailValidationPage;
import pages.SignUpPasswordValidationsPage;
import pages.SignUpValidationPage;
import utils.Driver;
import utils.TestDataReader;

public class SignUpPasswordValidation {
@BeforeMethod
public void setup() {
	Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

@Test (dataProvider = "passWordValidate")
public void passwordValidation(String testPassword) {
	
//When I navigate to the ‘Sign Up’ screen, 
	CommonPage commonpage = new CommonPage();
	SignUpValidationPage  signUpPageValidate = new  SignUpValidationPage();
	SignUpPasswordValidationsPage passwordValidate = new SignUpPasswordValidationsPage();
	
	Driver.getDriver().get(TestDataReader.getProperty("ecommerceStoreUrl"));

	// and click 
	commonpage.welcomeLink.click();
	commonpage.signUpButton.click();
	
	String actualText = passwordValidate.passwordField.getText().substring(1, testPassword.length() + 1);
	System.out.println(actualText + " " + testPassword.length());

	//And I click on ‘Sign Up’ Button, 
	signUpPageValidate.signUpBtn.click();

//Then:

//The system should encrypt the “password” value by the user.

//The system should validate that the “password” value meets the following criteria:
//A. Password length between 8-12 characters.
//B. Password must contain at least 1 special character. 
//C. Password must have at least 1 uppercase letter.
//D. Password must have have at least 1 number. 
//If the password entered does not meet the criteria mentioned in 2A - 2D, then the system should provide the following inline error message: 
//”Please enter a valid password.”
	passwordValidate.invalidPasswordMessage.isDisplayed();
	
}
//And I enter a value within the 'Password’ Textbox
@DataProvider
public String[] passWordValidate() {
	String[] testPassword = new String[2];
	testPassword[0] = "Password1%";
	testPassword[1] = "password";
	
	return testPassword;
	
}
@AfterMethod
public void quitDriver() {
	Driver.quitDriver();
}


}