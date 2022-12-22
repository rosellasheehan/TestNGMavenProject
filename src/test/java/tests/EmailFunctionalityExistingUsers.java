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

public class EmailFunctionalityExistingUsers {
	
	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

@Test
public void emailFunctionality() {
//When I navigate to the ‘Sign Up’ screen, 

CommonPage commonpage = new CommonPage();
SignUpValidationPage  signUpPageValidate = new  SignUpValidationPage();
RegisterSuccessfulPage registerSuccessful = new RegisterSuccessfulPage();

Driver.getDriver().get(TestDataReader.getProperty("ecommerceStoreUrl"));

commonpage.welcomeLink.click();
commonpage.signUpButton.click();

//And I enter a valid value for the following fields: 
//Email Address.
registerSuccessful.emailField.sendKeys("sdetneweemail@mailsac.com");

//First Name.
registerSuccessful.firstNameField.sendKeys("Sam");

//Last Name. 
registerSuccessful.lastNameField.sendKeys("Smith");

//Password.
registerSuccessful.passwordField.sendKeys("passWord123");

//And I click on the ‘Sign Up’ button,
signUpPageValidate.signUpBtn.click();

//Then I should receive a welcome email  sent to the email entered in the Email Address textbox with the following text:
//”Welcome to the Sporting Goods  Store, we look forward to servicing your needs! 
//Regards, 
//Andy Jassi 
//Co-founder of Sporting Goods  Store”

 }

@AfterMethod
public void quitDriver() {
	Driver.quitDriver();
}
}