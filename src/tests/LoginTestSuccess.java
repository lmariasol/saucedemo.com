package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class LoginTestSuccess extends BaseTest {
	
	@Override
	public void setupLogin() {
		
	}

	@Test
	public void tc04_Login_Success() {
		// Login
		LoginPage lp = new LoginPage(driver);
		lp.loginForm("standard_user", "secret_sauce");
		ProductsPage products = new ProductsPage(driver);
		// Assert
		String expected = "Swag Labs";
		String actual = products.getPageTitle();
		Assert.assertEquals(actual, expected);
	}
}