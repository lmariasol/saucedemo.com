package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class MethodsTest extends BaseTest {

	@Test
	public void tc_01() {
		// Sort btn: Low to high test case
		LoginPage lp = new LoginPage(driver);
		lp.loginForm("standard_user", "secret_sauce");
		ProductsPage products = new ProductsPage(driver);
		System.out.println(products.getListOfProductNames());
		products.sortProducts("za");
		Assert.assertTrue(products.checkIfZtoASorted(products.getListOfProductNames()));
		System.out.println("After the sorting: ");
		System.out.println(products.getListOfProductNames());
	}
}