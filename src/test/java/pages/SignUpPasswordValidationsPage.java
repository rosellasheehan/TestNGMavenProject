package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class SignUpPasswordValidationsPage {
	
	public SignUpPasswordValidationsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (name = "password")
	public WebElement passwordField;
	
	@FindBy(className = "invalid-message")
	public WebElement invalidPasswordMessage;
}



