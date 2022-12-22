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

public class SignUpRegistrationSuccessful {
	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

@Test
public void registerSuccessful(){
//When I navigate to the ‘Sign Up’ screen, 

CommonPage commonpage = new CommonPage();
SignUpValidationPage  signUpPageValidate = new  SignUpValidationPage();
RegisterSuccessfulPage registerSuccessful = new RegisterSuccessfulPage();

Driver.getDriver().get(TestDataReader.getProperty("ecommerceStoreUrl"));

commonpage.welcomeLink.click();
commonpage.signUpButton.click();

//And I enter a valid value for the following fields: 
//1. Email Address.
registerSuccessful.emailField.sendKeys("sdetemail@gmail.com");

//2. First Name.
registerSuccessful.firstNameField.sendKeys("Daniel");

//3. Last Name. 
registerSuccessful.lastNameField.sendKeys("Jones");

//4. Password.
registerSuccessful.passwordField.sendKeys("passWord123");

//And I click on the ‘Sign Up’ button,

signUpPageValidate.signUpBtn.click();

//Then:
//1. I should be directed to the “Sporting Goods  Store” Dashboard page. 
//2. I should see a green flash message box to the right with the following text: “You Have Signed Up Succesfully! You Will Be  Receiving An Email As Well. Thank You!”.
//3. I should see the flash message with a close button to the top right and I should see it disappear in less than or equal to 5 secs. 

//4. The System should save the following information that was provided by the customer:
//Email Address.
//First Name.
//Last Name. 
//Password.

	}

@AfterMethod
public void quitDriver() {
	Driver.quitDriver();
}
}