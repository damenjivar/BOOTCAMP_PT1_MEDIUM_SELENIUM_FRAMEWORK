package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

	public WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement emailTextboxField;

	@FindBy(id = "input-password")
	private WebElement passwordTextboxField;

	@FindBy(css = "input#button-login")
	private WebElement returningCustomerContinueButton;

	@FindBy(xpath = "//div[@class = 'col-sm-12']/descendant::input[2]")
	private WebElement createNewAddressRadioButton;

	@FindBy(id = "input-payment-firstname")
	private WebElement firstNameTextboxField;

	@FindBy(id = "input-payment-lastname")
	private WebElement lastNameTextboxField;

	@FindBy(id = "input-payment-company")
	private WebElement companyTextboxField;

	@FindBy(id = "input-payment-address-1")
	private WebElement address1TextboxField;

	@FindBy(id = "input-payment-city")
	private WebElement cityTextboxField;

	@FindBy(id = "input-payment-postcode")
	private WebElement postCodeTextboxField;

	@FindBy(id = "input-payment-country")
	private WebElement countryDropdownButton;

	@FindBy(id = "input-payment-zone")
	private WebElement stateDropdownButton;

	@FindBy(id = "button-payment-address")
	private WebElement billingDetailsContinueButton;

	@FindBy(xpath = "//div[@id = 'shipping-existing']/select[@class = 'form-control']")
	private WebElement existingAddressDropdown;

	@FindBy(id = "button-shipping-address")
	private WebElement deliveryDetailsContinueButton;

	@FindBy(id = "button-shipping-method")
	private WebElement deliveryMethodContinueButton;

	@FindBy(name = "agree")
	private WebElement termsAndConditionsCheckbox;

	@FindBy(id = "button-payment-method")
	private WebElement paymentMethodContinueButton;

	@FindBy(xpath = "//table[@class = 'table table-bordered table-hover']/tbody/tr/td/a[contains(text(), 'HP LP3065')]")
	private WebElement validProductInConfirmOrderDisplayStatus;
	
	@FindBy(id = "button-confirm")
	private WebElement confirmOrderButton;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterValidEmailInEmailTextboxField(String validEmailText) {
		emailTextboxField.sendKeys(validEmailText);
	}

	public void enterValidPasswordInPasswordTextboxField(String validPasswordText) {
		passwordTextboxField.sendKeys(validPasswordText);
	}

	public void clickOnReturningCustomerContinueButton() {
		returningCustomerContinueButton.click();
	}

	public void clickOnCreateNewAddressRadioButton() {
		createNewAddressRadioButton.click();
	}

	public void enterFirstNameInFirstNameTextboxField(String firstNameText) {
		firstNameTextboxField.sendKeys(firstNameText);
	}

	public void enterLastNameInLastNameTextboxField(String lastNameText) {
		lastNameTextboxField.sendKeys(lastNameText);
	}

	public void enterCompanyNameInCompanyNameTextboxField(String companyNameText) {
		companyTextboxField.sendKeys(companyNameText);
	}

	public void enterAddress1InAddress1TextboxField(String address1Text) {
		address1TextboxField.sendKeys(address1Text);
	}

	public void enterCityInCityTextboxField(String cityNameText) {
		cityTextboxField.sendKeys(cityNameText);
	}

	public void enterPostCodeInPostCodeTextboxField(String postCodeText) {
		postCodeTextboxField.sendKeys(postCodeText);
	}

	public void selectCountryDropDown(String countryNameText) {
		Select select = new Select(countryDropdownButton);
		select.selectByVisibleText(countryNameText);
	}

	public void selectStateDropDown(String stateNameText) {
		Select select = new Select(stateDropdownButton);
		select.selectByVisibleText(stateNameText);
	}

	public void clickOnBillingDetailsContinueButton() {
		billingDetailsContinueButton.click();
	}

	public void selectExistingAddressDropDown(String existingAddressText) {
		Select select = new Select(existingAddressDropdown);
		select.selectByVisibleText(existingAddressText);
	}

	public void clickOnDeliveryDetailsContinueButton() {
		deliveryDetailsContinueButton.click();
	}

	public void clickOnDeliveryMethodContinueButton() {
		deliveryMethodContinueButton.click();
	}

	public void clickOnTermsAndConditionsCheckbox() {
		termsAndConditionsCheckbox.click();
	}

	public void clickOnPaymentMethodContinueButton() {
		paymentMethodContinueButton.click();
	}

	public boolean verifyDisplayStatusOfValidProductInConfirmOrder() {
		boolean presenceOfValidProductInConfirmOrder = validProductInConfirmOrderDisplayStatus.isDisplayed();
		return presenceOfValidProductInConfirmOrder;
	}
	
	public OrderSuccessPage clickOnConfirmOrderButton() {
		confirmOrderButton.click();
		return new OrderSuccessPage(driver);
	}
	
	
	

}
