package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.LoginPage;

public class BaseTest {
	WebDriver driver;

	@BeforeClass
	public void setupLogin() {
		// Login
		LoginPage lp = new LoginPage(driver);
		lp.loginForm("standard_user", "secret_sauce");
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window();
		driver.get("https://www.saucedemo.com/");
	}

	@AfterClass
	public void tearDown() {
		// Close the browser window
		driver.close();
		// Quit the WebDriver instance
		driver.quit();
	}
}
