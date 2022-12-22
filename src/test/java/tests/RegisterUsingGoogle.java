package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;

import utils.Driver;

public class RegisterUsingGoogle {
	
	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
//When I navigate to the ‘Sign Up’ screen, 

//And I click on the ‘Login with Google ’ button, 

//Then:
//The System should direct the user to the Google Login Screen. 
//If the user is already logged in then the user will be able to view the user agreement for Sporting Goods  Store.

//2.1 If the user is not logged in then the user should be able to select a google account and Login. 

//If the user agrees to the Terms and conditions of the Sporting Goods   Store and authorizes Google to share user 
//details the system should collect and save the following information in the Database:
//Email Address.
//First Name.
//Last Name. 
//Password.

//I should be directed to the “Sporting Goods  Store” Dashboard page. 
//I should see a green flash message box to the right with the following text: “You Have Signed Up Succesfully! 
//You Will Be  Receiving An Email As Well. Thank You!”.
//I should see the flash message with a close button to the top right and I should see it disappear in less than 
//or equal to 5 secs. 
//I should receive a welcome email  sent to the email entered in the Email Address textbox with the following text:
//”Welcome to the Sporting Goods  Store, we look forward to servicing your needs! 
//Regards, 
//Andy Jassi 
//Co-founder of Sporting Goods  Store”