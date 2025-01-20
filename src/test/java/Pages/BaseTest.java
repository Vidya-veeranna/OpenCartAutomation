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
		if (driver == null) {
            throw new RuntimeException("WebDriver initialization failed");
        }
	}
	
	@AfterClass
	public void teardown() {
		if (driver != null) {
			BrowserFactory.quitBrowser(driver);
        }
	}
	
}
