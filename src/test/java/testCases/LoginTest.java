package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "LoginDetails")
	public void verifLogin(String scenario,String email, String password) throws Exception {
		LoginPage lg = new LoginPage(driver);
		
		lg.LogIntoPortal(email, password);
		lg.verifyLoginCredentials(scenario,email,password);
		
	}
	
	@DataProvider(name = "LoginDetails")
	public Object[][] LoginDetails(){
		
		return new Object[][]{{"Success","vidagowda191@gmail.com","Vidya@1"},
							{"incorrectEmail","vidya","Vidya@1"},
							{"incorrectPassword","vidagowda191@gmail.com","Vida@1"},
							{"BothIncorrect","vidya","Vid1"}
							}; 
		
	}
	
}
