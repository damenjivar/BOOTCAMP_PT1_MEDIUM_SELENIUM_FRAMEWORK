package com.tn.qa.testCases1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tn.qa.pages.CamerasPage;
import com.tn.qa.pages.HomePage;
import com.tn.qa.testBase.TestBase;

public class HomepageTest extends TestBase {

	public HomepageTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public HomePage homepage;
	public CamerasPage cameraspage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	}

	@Test(priority = 1)
	public void verifyHomePageCamerasLink() {
		homepage = new HomePage(driver);
		Assert.assertTrue(homepage.verifyDisplayStatusOfCamerasLink());
		cameraspage = homepage.clickOnCamerasLink();
		Assert.assertTrue(cameraspage.verifyDisplayStatusOfCamerasProductPage());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}