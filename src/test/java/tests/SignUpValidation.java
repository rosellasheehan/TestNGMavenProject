package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CommonPage;
import pages.SignUpValidationPage;
import utils.Driver;
import utils.TestDataReader;


public class SignUpValidation {

	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

@Test

public void SignUpTest(){
//When I navigate to the ‘Sign Up’ screen, 

CommonPage commonpage = new CommonPage();
SignUpValidationPage  signUpPageValidate = new  SignUpValidationPage();

Driver.getDriver().get(TestDataReader.getProperty("ecommerceStoreUrl"));

// and click 
commonpage.welcomeLink.click();
commonpage.signUpButton.click();

//And I click on ‘Sign Up’ Button, 

signUpPageValidate.signUpBtn.click();

//Then: 

//The System should validate that the user has entered a value within the ‘Email Address’ Textbox, If no value has been entered then the user should see the following error message:
//”Email is required.”
Assert.assertTrue(signUpPageValidate.emailErrorMessage.isDisplayed());

//The System should validate that the user has entered a value within the ‘First Name’ Textbox, If no value has been entered then the user should see the following error message:
//”First Name is required.”
Assert.assertTrue(signUpPageValidate.firstNameErrorMessage.isDisplayed());

//The System should validate that the user has entered a value within the ‘Last Name’ Textbox, If no value has been entered then the user should see the following error message:
//”Last Name is required.”
Assert.assertTrue(signUpPageValidate.lastNameErrorMessage.isDisplayed());

//The System should validate that the user has entered a value within the ‘Password’ Textbox, If no value has been entered then the user should see the following error message:
//”Password is required.”
Assert.assertTrue(signUpPageValidate.passWordErrorMessage.isDisplayed());

//The System should ensure that the user is unable to Register an account.

	}

@AfterMethod
public void quitDriver() {
	Driver.quitDriver();
}


}