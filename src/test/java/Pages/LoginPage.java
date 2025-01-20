package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LoginPage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='top']/div/div[2]/ul/li[2]/div/a/span") WebElement myAccount;
	@FindBy(xpath =  "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[2]/a") WebElement loginBtn;
	@FindBy(id =  "input-email") WebElement emailField;
	@FindBy(id =  "input-password") WebElement passwordField;  
	@FindBy(xpath =  "//*[@id=\"form-login\"]/div[3]/button") WebElement submitBtn;
	@FindBy(linkText =  "Logout") WebElement logoutBtn;
	@FindBy(xpath = "//*[@id=\"alert\"]/dirv") WebElement errorMsg;
	@FindBy(xpath = "//*[@id=\"alert\"]/dirv/button") WebElement closeBtn;
	
	public void navigateToLoginPage() {
		myAccount.click();
		loginBtn.click();
	}
	
	public void LogIntoPortal(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		submitBtn.click();
	}
	
	public void verifyLoginCredentials(String scenario,String email,String password) {
		if(scenario.equals("Success")) {
			myAccount.click();
			Assert.assertEquals(logoutBtn.getText(), "Logout");
			//LogOutFromPortal();
		}else {
			Assert.assertEquals(errorMsg.getText(), "Warning: No match for E-Mail Address and/or Password.");
			closeBtn.click();
		}
		
	}
	
	
	public void LogOutFromPortal() {
		myAccount.click();
		logoutBtn.click();
	}
	
}
