package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTestFailed extends BaseTest{
	
	@Override
	public void setupLogin() {
		
	}

	@Test(description = "locked out user")
	public void tc01_Login_Failed() {
		// Login
		LoginPage lp = new LoginPage(driver);
		lp.loginForm("locked_out_user", "secret_sauce");
		//Assert
		String expected = "Epic sadface: Sorry, this user has been locked out.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected); // If equals then test pass, else test fail
	}

	@Test(dataProvider = "getData", description = "use incorrect information")
	public void tc02_Login_Failed(String user, String password) {
		// Login with incorrect username
		LoginPage lp = new LoginPage(driver);
		lp.loginForm(user, password);
		//Assert
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"user","secret_sauce"},
				{"123","secret_sauce"},
				{"standard_user","secret123"}
		};
		return myData;
	}
}
