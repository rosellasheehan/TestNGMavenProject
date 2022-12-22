package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CommonPage;
import pages.RegisterSuccessfulPage;
import pages.SignUpValidationPage;
import utils.Driver;
import utils.TestDataReader;

public class RegisterExistingUser {
	
	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

@Test
public void registerExisting(){
//When I navigate to the ‘Sign Up’ screen, 
CommonPage commonpage = new CommonPage();
SignUpValidationPage  signUpPageValidate = new  SignUpValidationPage();
RegisterSuccessfulPage registerSuccessful = new RegisterSuccessfulPage();

Driver.getDriver().get(TestDataReader.getProperty("ecommerceStoreUrl"));

commonpage.welcomeLink.click();
commonpage.signUpButton.click();

//And I enter the following fields: 
//1. Email - Email of an existing user.

registerSuccessful.emailField.sendKeys("sdetemail@gmail.com");

//2. Valid First Name.
registerSuccessful.firstNameField.sendKeys("Daniel");

//3. Valid Last Name.
registerSuccessful.lastNameField.sendKeys("Jones");

//4. Valid Password.
registerSuccessful.passwordField.sendKeys("passWord123");

//And I click on the ‘Sign Up’ button,

signUpPageValidate.signUpBtn.click();


//Then:
//1. The System should  display the following error message in a red flash box with the following message:
//”Please Try To Signup Again!
// That email address is already in use.”
//2. The message should disappear within 5 seconds or less. 
//3. The user should remain on the sign up page. 
//4. The system should not create the user. 

}

@AfterMethod
public void quitDriver() {
	Driver.quitDriver();

}

}