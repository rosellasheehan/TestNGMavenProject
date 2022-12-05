package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SauceDemoPage;
import utils.Driver;
import utils.TestDataReader;


public class homeWorkTestCases {
@Test

	public void TestCase1() {
//	Test case 1
//	go to https://saucedemo.com
	Driver.getDriver().get(TestDataReader.getProperty("sauceDemoUrl"));
	Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
//	log in with valid username = standard_user   password = secret_sauce
	SauceDemoPage sauceDemo = new SauceDemoPage();
	sauceDemo.username.sendKeys("userNameId");
	sauceDemo.password.sendKeys("passWordId");
	sauceDemo.loginButton.click();
	
//	Verify that you are logged in successfully.
	Assert.assertEquals(Driver.getDriver().getTitle(), TestDataReader.getProperty("swagTitlePage"));
		
}

@Test

	public void TestCase2() {
//	Test case 2 
//	go to https://saucedemo.com 
	Driver.getDriver().get(TestDataReader.getProperty("sauceDemoUrl"));
	Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
//	log in with invalid username = invalid_user  password = secret_sauce
	SauceDemoPage sauceDemo = new SauceDemoPage();
	sauceDemo.username.sendKeys("invalidUsername");
	sauceDemo.password.sendKeys("passWordId");
	sauceDemo.loginButton.click();
	
//	Verify that you are not logged in, and you get the error message of:
//	“Epic sadface: Username and password do not match any user in this service”
	Assert.assertEquals(sauceDemo.errorMessage.getText(),TestDataReader.getProperty("validErrorMessage"));
	
}

@Test

	public void TestCase3() {
//	 Test case 3
//	 go to https://saucedemo.com
	 Driver.getDriver().get(TestDataReader.getProperty("sauceDemoUrl"));
	 Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 
//	 log in with locked  username = locked_out_user   password = secret_sauce
	 SauceDemoPage sauceDemo = new SauceDemoPage();
	 sauceDemo.username.sendKeys("lockedUserName");
	 sauceDemo.password.sendKeys("passWordId");
	 sauceDemo.loginButton.click();
	 
//	 Verify that you are not logged in, and you get the error message of:
//	 “Epic sadface: Sorry, this user has been locked out.”
	 Assert.assertEquals(sauceDemo.errorMessage.getText(),TestDataReader.getProperty("lockedOutMessage"));
	

}


 


}
