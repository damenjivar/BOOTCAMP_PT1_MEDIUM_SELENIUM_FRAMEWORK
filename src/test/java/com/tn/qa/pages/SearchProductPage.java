package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {

	public WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(), 'HP LP3065')]")
	private WebElement validProductLink;
	
	public SearchProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ValidProductPage clickOnValidProductLink() {
		validProductLink.click();
		return new ValidProductPage(driver);
	}
}
