package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CamerasPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[contains(text(), 'Nikon D300')]")
	private WebElement camerasProductPage;

	public CamerasPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyDisplayStatusOfCamerasProductPage() {
		boolean presenceOfCamerasProductPage = camerasProductPage.isDisplayed();
		return presenceOfCamerasProductPage;
	}
}
