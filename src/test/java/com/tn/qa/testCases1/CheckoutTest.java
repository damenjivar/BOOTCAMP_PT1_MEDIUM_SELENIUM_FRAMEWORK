package com.tn.qa.testCases1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tn.qa.pages.CheckoutPage;
import com.tn.qa.pages.HomePage;
import com.tn.qa.pages.OrderSuccessPage;
import com.tn.qa.pages.SearchProductPage;
import com.tn.qa.pages.ValidProductPage;
import com.tn.qa.testBase.TestBase;

public class CheckoutTest extends TestBase {

	public CheckoutTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public Select select;
	public HomePage homepage;
	public SearchProductPage searchproductpage;
	public ValidProductPage validproductpage;
	public CheckoutPage checkoutpage;
	public OrderSuccessPage ordersuccesspage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	}

	@Test(priority = 1)
	public void verifyAddValidProductToCart() throws Exception {
		homepage = new HomePage(driver);
		homepage.enterValidProductInSearchTextboxField(dataProp.getProperty("validProduct"));
		searchproductpage = homepage.clickOnSearchButton();
		validproductpage = searchproductpage.clickOnValidProductLink();
		validproductpage.clickOnAddToCartButton();
		Assert.assertTrue(validproductpage.displayStatusOfValidProductAddedToCartSuccessMessage());
		validproductpage.clickOnShoppingCartLink();
		checkoutpage = validproductpage.clickOnCheckoutLink();
		checkoutpage.enterValidEmailInEmailTextboxField(prop.getProperty("validEmail"));
		checkoutpage.enterValidPasswordInPasswordTextboxField(prop.getProperty("validPassword"));
		checkoutpage.clickOnReturningCustomerContinueButton();
		Thread.sleep(3000);
		checkoutpage.clickOnCreateNewAddressRadioButton();
		checkoutpage.enterFirstNameInFirstNameTextboxField(dataProp.getProperty("firstName"));
		checkoutpage.enterLastNameInLastNameTextboxField(dataProp.getProperty("lastName"));
		checkoutpage.enterCompanyNameInCompanyNameTextboxField(dataProp.getProperty("companyName"));
		checkoutpage.enterAddress1InAddress1TextboxField(dataProp.getProperty("Address1"));
		checkoutpage.enterCityInCityTextboxField(dataProp.getProperty("City"));
		checkoutpage.enterPostCodeInPostCodeTextboxField(dataProp.getProperty("PostalCode"));
		checkoutpage.selectCountryDropDown(dataProp.getProperty("Country"));
		checkoutpage.selectStateDropDown(dataProp.getProperty("State"));
		checkoutpage.clickOnBillingDetailsContinueButton();
		checkoutpage.selectExistingAddressDropDown(dataProp.getProperty("fullShippingInfo"));
		checkoutpage.clickOnDeliveryDetailsContinueButton();
		checkoutpage.clickOnDeliveryMethodContinueButton();
		checkoutpage.clickOnTermsAndConditionsCheckbox();
		checkoutpage.clickOnPaymentMethodContinueButton();
		Thread.sleep(3000);
		Assert.assertTrue(checkoutpage.verifyDisplayStatusOfValidProductInConfirmOrder());
		Thread.sleep(3000);
		ordersuccesspage = checkoutpage.clickOnConfirmOrderButton();
		Assert.assertTrue(ordersuccesspage.verifyDisplayOfOrderSuccessMessage());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}