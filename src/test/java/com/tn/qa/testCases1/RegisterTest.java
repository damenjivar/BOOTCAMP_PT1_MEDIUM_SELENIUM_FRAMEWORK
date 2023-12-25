package com.tn.qa.testCases1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tn.utilities.Util;
import com.tn.qa.pages.AccountSuccessPage;
import com.tn.qa.pages.HomePage;
import com.tn.qa.pages.RegisterPage;
import com.tn.qa.testBase.TestBase;

public class RegisterTest extends TestBase {

	public RegisterTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public HomePage homepage;
	public RegisterPage registerpage;
	public AccountSuccessPage accountsuccesspage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountOption();
		registerpage = homepage.clickOnRegisterOption();
	}

	@Test(priority = 1)
	public void verifyRegisterWithMandatoryFields() {
		accountsuccesspage = registerpage.registerPageMandatoryDetails(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertEquals(dataProp.getProperty("accountSuccessMessage"),
				accountsuccesspage.retrieveAccountSuccessCreationMessage());

	}

	@Test(priority = 2)
	public void verifyRegisterWithAllFields() {
		accountsuccesspage = registerpage.registerPageAllDetails(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertEquals(dataProp.getProperty("accountSuccessMessage"),
				accountsuccesspage.retrieveAccountSuccessCreationMessage());
	}

	@Test(priority = 3)
	public void verifyRegisterWithNoFields() {
		registerpage.clickOnContinueButton();
		Assert.assertTrue(registerpage.retrieveAllWarningMessageStatus(
				dataProp.getProperty("privacyPolicyWarningMessage"), dataProp.getProperty("firstNameWarningMessage"),
				dataProp.getProperty("lastNameWarningMessage"), dataProp.getProperty("emailWarningMessage"),
				dataProp.getProperty("telephoneWarningMessage"), dataProp.getProperty("passwordWarningMessage")));
	}

	@Test(priority = 4)
	public void verifyRegisterWithExistingEmail() {
		registerpage.registerPageAllDetails(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("validEmail"), dataProp.getProperty("telephone"), prop.getProperty("validPassword"),
				prop.getProperty("validPassword"));
		Assert.assertEquals(dataProp.getProperty("duplicateEmailWarningMessage"),
				registerpage.retrieveDuplicateEmailWarningMessageText());
	}

	@Test(priority = 5)
	public void verifyRegisterWithPasswordMismatch() {
		registerpage.registerPageAllDetails(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"), prop.getProperty("validPassword"),
				dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(dataProp.getProperty("passwordMismatchWarningMessage"),
				registerpage.retrievePasswordMismatchWarningMessageText());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}