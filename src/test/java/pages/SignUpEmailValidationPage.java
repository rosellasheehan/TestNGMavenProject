package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class SignUpEmailValidationPage {
	
	public SignUpEmailValidationPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (name = "email")
	public WebElement emailAddressField;
	
	@FindBy (xpath = "//span[text()='The email may not be greater than 125 characters.']")
	public WebElement emailAddressTooLongError;
	
	@FindBy (xpath = "//span[text()='Please enter a valid email address.']")
	public WebElement enterValidEmailAddress;
	
	
	
}



