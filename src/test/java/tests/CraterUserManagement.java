package tests;

import org.testng.annotations.Test;

import pages.CraterDashboardPage;
import pages.CraterLoginPage;
import utils.Driver;
import utils.TestDataReader;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class CraterUserManagement {
  @Test
  public void validLogin() {
	  /*Scenario: Successful Login 
	   * Giben user is on the login page
	   * when user enters valid username and password
	   * and click login button 
	   * then suer should be on the dashboard page
	   * 
	   */
	  
	  Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
	  CraterLoginPage loginPage = new CraterLoginPage();
	  loginPage.useremail.sendKeys(TestDataReader.getProperty("craterValidUserEmail"));
	  loginPage.password.sendKeys(TestDataReader.getProperty("craterValidPassword"));
	  loginPage.loginButton.click();
    
	  //verify the amount due element is displayed 
	  CraterDashboardPage dashboardPage = new CraterDashboardPage(); 
	
	  Assert.assertTrue(dashboardPage.amountDueText.isDisplayed());
	  
	  //verify the url contains dashboard
	  String dashboardUrl = Driver.getDriver().getCurrentUrl();
	  Assert.assertTrue(dashboardUrl.contains("dashboard"));
	  
  }

  
  @BeforeMethod
  public void setUp() {
	  Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
  }

  @AfterMethod
  public void tearDown() {
	  Driver.quitDriver();
  }

}
