package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.Excel;
import utils.Utils;

public class LoginTestFailedDDT extends BaseTest{
	
	@Override
	public void setupLogin() {
		
	}

	@Test(description = "Case: locked out user")
	public void tc01_Login_Failed() {
		LoginPage lp = new LoginPage(driver);
		lp.loginForm(Utils.readProperty("user2"), Utils.readProperty("password2"));
		//Assert
		String expected = "Epic sadface: Sorry, this user has been locked out.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected); // If equals then test pass, else test fail
	}

	@Test(dataProvider = "getDataFromExcel", description = "Data Driven Test - Case: incorrect credentials")
	public void tc02_Login_Failed(String user, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.loginForm(user, password);
		//Assert
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
	
	/*
	 * Use the Excel class to read data from excel
	 */
	@DataProvider
	public Object[][] getDataFromExcel(){
		String excelPath = System.getProperty("user.dir") + "\\src\\data\\saucedemo.com_input.xlsx";
		System.out.println(excelPath);
		Object[][] table = Excel.getTableArray(excelPath, "Login");
		return table;
	}
}
