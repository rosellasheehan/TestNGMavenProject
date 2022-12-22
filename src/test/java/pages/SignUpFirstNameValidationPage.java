package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class SignUpFirstNameValidationPage {
	
	public SignUpFirstNameValidationPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(name = "firstName")
	public WebElement firstNameField;
	
	@FindBy(xpath = "//span[text()='The firstName may not be greater than 50 characters.']")
	public WebElement FirstNameLengthErrorMessage;
	
	@FindBy(xpath = "//span[text()='The firstName format is invalid.']")
	public WebElement FirstNameCharacterErrorMessage;


}


