package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTestFailed extends BaseTest{

	@Test
	public void tc01_Login_Failed() {
		// Login
		LoginPage lp = new LoginPage(driver);
		lp.loginForm("locked_out_user", "secret_sauce");
		//Assert
		String expected = "Epic sadface: Sorry, this user has been locked out.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected); // If equals then test pass, else test fail
	}

	@Test
	public void tc02_Login_Failed() {
		// Login
		LoginPage lp = new LoginPage(driver);
		lp.loginForm("user", "secret_sauce");
		//Assert
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void tc03_Login_Failed() {
		// Login
		LoginPage lp = new LoginPage(driver);
		lp.loginForm("standard_user", "secret123");
		//Assert
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
}
