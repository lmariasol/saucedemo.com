package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Saucelabs_Page extends BasePage {

	// Elements	
	String titleText = (driver.getTitle());

	// Container
	public Saucelabs_Page(WebDriver driver) {
		super(driver);
	}

	// Methods
}