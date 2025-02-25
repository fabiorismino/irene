package web.saucedemo.cases;

import data.Credentials;
import driver.DriverSetter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import web.saucedemo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;

public class Saucedemo_0 {

    WebDriver wd;
    LoginPage loginPage;

    @BeforeMethod
    @Parameters({"platform"})
    public void setUp(String platform) {
        wd = new DriverSetter().setWebDriver(platform);
        loginPage = new LoginPage(wd);
    }

    @Test
    public void doLogin() {
        wd.get("https://www.saucedemo.com/");
        loginPage.doLogin(Credentials.SaucedemoCredentials.username1, Credentials.SaucedemoCredentials.password);
    }

    @AfterMethod
    public void tearDown() {
        wd.close();
    }
}
