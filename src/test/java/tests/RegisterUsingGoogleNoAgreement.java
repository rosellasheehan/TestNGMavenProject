package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;

import utils.Driver;

public class RegisterUsingGoogleNoAgreement {
	
	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
//When I navigate to the ‘Sign Up’ screen,

//And I click on the ‘Login with Google’ button, 

//Then:
//1. The System should direct the user to the Google Login Screen. 
//2. User is logged into the Google Account. 
//3. If the user does not agree with the user agreement for Sporting 
//Goods  Store then the user will be re-directed to the Sign up page. 