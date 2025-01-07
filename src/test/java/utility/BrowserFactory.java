package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public static WebDriver startApplication(WebDriver driver,String BrowserName,String AppURL) {
		
		if(BrowserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");
	         driver = new FirefoxDriver();
		}
		else if(BrowserName.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/IEDriverServer.exe");
	         driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We do not support this browser ");
		}
		
		driver.manage().window().maximize();
		driver.get(AppURL);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
