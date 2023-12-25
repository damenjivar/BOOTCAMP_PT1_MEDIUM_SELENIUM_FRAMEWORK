package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	public WebDriver driver;

	@FindBy(xpath = "//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]")
	private WebElement accountSuccessCreationMessage;

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String retrieveAccountSuccessCreationMessage() {
		String accountsuccesscreationmessage = accountSuccessCreationMessage.getText();
		return accountsuccesscreationmessage;
	}
}