package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CommonPage;
import pages.SignUpValidationPage;
import utils.Driver;
import utils.TestDataReader;
import pages.SignUpEmailValidationPage;


public class SignUpEmailValidation {
	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

@Test (dataProvider = "emailAddress")

public void emailValidation(String testEmailAddress) {
//When I navigate to the ‘Sign Up’ screen, 
CommonPage commonpage = new CommonPage();
SignUpValidationPage  signUpPageValidate = new  SignUpValidationPage();
SignUpEmailValidationPage emailValidate = new SignUpEmailValidationPage();

Driver.getDriver().get(TestDataReader.getProperty("ecommerceStoreUrl"));

// and click 
commonpage.welcomeLink.click();
commonpage.signUpButton.click();

//And I click on ‘Sign Up’ Button, 
signUpPageValidate.signUpBtn.click();

//Then:
//1. The system should validate that the Email Address entered is less than or equal to 125 characters in length. 
//If the entered Email Address is greater than 125 characters in length then I should see the following inline error message:
//”The email may not be greater than 125 characters.”
Assert.assertTrue(emailValidate.emailAddressTooLongError.isDisplayed());

//2. The system should validate that Email Address entered follows the following format [string@domain.com].
//If the entered email is not in [string@domain.com] format then I should see the following inline error message:
//”Please enter a valid email address.”
Assert.assertTrue(emailValidate.enterValidEmailAddress.isDisplayed());

	}

//And I enter a value within the 'Email Address’ Textbox
@DataProvider
public String[] emailAddress() {
	String[] testEmailAddress = new String[2];
	testEmailAddress[0] = "effjesxcxsncmcxddcccccccccccccccccccccccccccccccccccccccccccccccccccccddddddddddddddddddddddddddddddddddddddddddddddddddsssss@gmail.com";
	testEmailAddress[1] = "newemail.com";
	return testEmailAddress;
}


@AfterMethod
public void quitDriver() {
	Driver.quitDriver();
}

}