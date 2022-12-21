package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

	public class RegisterSuccessfulPage {

		public RegisterSuccessfulPage() {
			PageFactory.initElements(Driver.getDriver(), this);
		}

		@FindBy (name = "email")
		public WebElement emailField;

		@FindBy (name = "firstName")
		public WebElement firstNameField;

		@FindBy (name = "lastName")
		public WebElement lastNameField;
		
		@FindBy (name = "password")
		public WebElement passwordField;




}
