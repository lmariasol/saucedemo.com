package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Utils;
import pageObjects.LoginPage;

public class BaseTest {
	WebDriver driver;

	@BeforeClass(description = "Succsessful Login credentials")
	public void setupLogin() {
		// Login
		LoginPage lp = new LoginPage(driver);
		//Using login credentials from config file
		lp.loginForm(Utils.readProperty("user1"), Utils.readProperty("password1"));
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window();
		driver.get(Utils.readProperty("url"));
	}

	@AfterClass
	public void tearDown() {
		// Close the browser window
		driver.close();
		// Quit the WebDriver instance
		driver.quit();
	}
}
