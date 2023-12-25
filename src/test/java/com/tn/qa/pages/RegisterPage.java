package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckbox;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
	private WebElement newsletterYesRadioButton;

	@FindBy(xpath = "//div[contains(text(), 'Warning: E-Mail Address is already registered!')]")
	private WebElement duplicateEmailWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Password confirmation does not match password!')]")
	private WebElement passwordMismatchWarningMessage;

	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	private WebElement privacyPolicyWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarningMessage;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AccountSuccessPage registerPageMandatoryDetails(String firstNameText, String lastNameText, String emailText,
			String telephoneText, String passwordText, String confirmPasswordText) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(confirmPasswordText);
		privacyPolicyCheckbox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public AccountSuccessPage registerPageAllDetails(String firstNameText, String lastNameText, String emailText,
			String telephoneText, String passwordText, String confirmPasswordText) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(confirmPasswordText);
		newsletterYesRadioButton.click();
		privacyPolicyCheckbox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public void clickOnNewsletterYesRadioButton() {
		newsletterYesRadioButton.click();
	}

	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public boolean retrieveAllWarningMessageStatus(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning,
			String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning,
			String expectedPasswordWarning) {
		boolean privacyPolicyWarningStatus = privacyPolicyWarningMessage.getText()
				.contains(expectedPrivacyPolicyWarning);
		boolean firstNameWarningStatus = firstNameWarningMessage.getText().contains(expectedFirstNameWarning);
		boolean lastNameWarningStatus = lastNameWarningMessage.getText().contains(expectedLastNameWarning);
		boolean emailWarningStatus = emailWarningMessage.getText().contains(expectedEmailWarning);
		boolean telephoneWarningStatus = telephoneWarningMessage.getText().contains(expectedTelephoneWarning);
		boolean passwordWarningStatus = passwordWarningMessage.getText().contains(expectedPasswordWarning);

		return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus
				&& telephoneWarningStatus && passwordWarningStatus;
	}

	public String retrieveDuplicateEmailWarningMessageText() {
		String duplicateEmailWarning = duplicateEmailWarningMessage.getText();
		return duplicateEmailWarning;
	}

	public String retrievePasswordMismatchWarningMessageText() {
		String passwordMismatchWarningMessageText = passwordMismatchWarningMessage.getText();
		return passwordMismatchWarningMessageText;
	}

	public String retrievePrivacyPolicyWarningMessageText() {
		String privacyPolicyWarningMessageText = privacyPolicyWarningMessage.getText();
		return privacyPolicyWarningMessageText;
	}

	public String retrieveFirstNameWarningMessageText() {
		String firstNameWarningMessageText = firstNameWarningMessage.getText();
		return firstNameWarningMessageText;
	}

	public String retrieveLastNameWarningMessageText() {
		String lastNameWarningMessageText = lastNameWarningMessage.getText();
		return lastNameWarningMessageText;
	}

	public String retrieveEmailWarningMessageText() {
		String emailWarningMessageText = emailWarningMessage.getText();
		return emailWarningMessageText;
	}

	public String retrieveTelephoneWarningMessageText() {
		String telephoneWarningMessageText = telephoneWarningMessage.getText();
		return telephoneWarningMessageText;
	}

	public String retrievePasswordWarningMessageText() {
		String passwordWarningMessageText = passwordWarningMessage.getText();
		return passwordWarningMessageText;
	}
}
