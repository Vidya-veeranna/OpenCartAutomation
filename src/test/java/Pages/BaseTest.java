package Pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utility.BrowserFactory;
import utility.ConfigDataProvider;

public class BaseTest {
	public WebDriver driver;
	public ConfigDataProvider config = new ConfigDataProvider();
	
	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
	}
	
	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
	}
	
}
