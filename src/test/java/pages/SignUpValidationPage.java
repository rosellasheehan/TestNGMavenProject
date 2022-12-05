package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class SignUpValidationPage {
	public SignUpValidationPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//button[@class='input-btn custom-btn-primary md text-only icon-left ']")
	public WebElement createAcctSignUpBtn;
	
	@FindBy(xpath = "//span[text()='Email is required.']")
	public WebElement emailErrorMessage;
	
	@FindBy(xpath = "//span[text()='First Name is required.']")
	public WebElement firstNameErrorMessage;
	
	@FindBy(xpath = "//span[text()='Last Name is required.']")
	public WebElement lastNameErrorMessage;
	
	@FindBy(xpath = "//span[text()='Password is required.']")
	public WebElement passWordErrorMessage;
	
}


