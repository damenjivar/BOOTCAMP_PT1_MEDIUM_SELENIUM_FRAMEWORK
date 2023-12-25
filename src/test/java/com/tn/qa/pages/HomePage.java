package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement myAccountDropDown;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(xpath = "//ul[@class = 'nav navbar-nav']/descendant::a[(text() = 'Cameras')]")
	private WebElement camerasLink;

	@FindBy(css = "input.form-control.input-lg")
	private WebElement searchTextboxField;

	@FindBy(css = "i.fa.fa-search")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyAccountOption() {
		myAccountDropDown.click();
	}

	public RegisterPage clickOnRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}

	public boolean verifyDisplayStatusOfCamerasLink() {
		boolean presenceOfCamerasLink = camerasLink.isDisplayed();
		return presenceOfCamerasLink;
	}

	public CamerasPage clickOnCamerasLink() {
		camerasLink.click();
		return new CamerasPage(driver);
	}

	public void enterValidProductInSearchTextboxField(String validProductText) {
		searchTextboxField.sendKeys(validProductText);
	}

	public SearchProductPage clickOnSearchButton() {
		searchButton.click();
		return new SearchProductPage(driver);
	}

}
