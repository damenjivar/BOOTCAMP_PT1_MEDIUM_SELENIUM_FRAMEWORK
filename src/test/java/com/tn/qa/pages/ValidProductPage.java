package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidProductPage {

	public WebDriver driver;

	@FindBy(css = "button.btn.btn-primary.btn-lg.btn-block")
	private WebElement addToCartButton;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement validProductAddedToCartSuccessMessage;

	@FindBy(css = "button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")
	private WebElement shoppingCart;

	@FindBy(xpath = "//strong[contains(text(), 'Checkout')]")
	private WebElement checkoutLink;

	public ValidProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}

	public boolean displayStatusOfValidProductAddedToCartSuccessMessage() {
		boolean presenceofvalidproductaddedtocartsuccessmessage = validProductAddedToCartSuccessMessage.isDisplayed();
		return presenceofvalidproductaddedtocartsuccessmessage;
	}

	public void clickOnShoppingCartLink() {
		shoppingCart.click();
	}

	public CheckoutPage clickOnCheckoutLink() {
		checkoutLink.click();
		return new CheckoutPage(driver);
	}
}