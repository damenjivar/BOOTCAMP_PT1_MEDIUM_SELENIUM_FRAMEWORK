package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessPage {

	public WebDriver driver;

	@FindBy(xpath = "//p[contains(text(), 'Your order has been successfully processed!')]")
	private WebElement orderSuccessMessage;

	public OrderSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyDisplayOfOrderSuccessMessage() {
		boolean presenceOfOrderSuccessMessage = orderSuccessMessage.isDisplayed();
		return presenceOfOrderSuccessMessage;
	}

}
