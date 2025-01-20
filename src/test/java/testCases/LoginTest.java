package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.BaseTest;
import Pages.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage lg;

    // Initialize LoginPage before each test method
    @BeforeMethod
    public void setup() {
        lg = new LoginPage(driver);
    }
}
