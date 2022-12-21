package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;

import utils.Driver;

public class SignUpNewsLetterFunctionality {
	
	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
//When I navigate to the ‘Sign Up’ screen, 

//And I enter a valid value for the following fields: 
//Email Address.
//First Name.
//Last Name. 
//Password.

//And I click on the ‘Subscribe To Our Newsletter!’ checkbox, 

//Then: 
//1. The System should send the latest version of the newsletter to the user’s email. 