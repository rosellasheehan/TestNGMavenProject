package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class SignUpLastNameValidationPage {
	
	public SignUpLastNameValidationPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (name = "lastName")
	public WebElement lastNameField;
	
	@FindBy(xpath = "//span[text()='The lastName may not be greater than 50 characters.']")
	public WebElement LastNameLengthErrorMessage;
	
	@FindBy(xpath = "//span[text()='The lastName format is invalid.']")
	public WebElement LastNameCharacterErrorMessage;
	
}


