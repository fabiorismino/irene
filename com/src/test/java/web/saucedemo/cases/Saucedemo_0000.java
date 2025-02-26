package web.saucedemo.cases;

import data.Credentials;
import driver.DriverSetup;
import driver.DriverSetup.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import web.saucedemo.pages.CartPage;
import web.saucedemo.pages.CheckoutPage;
import web.saucedemo.pages.InventoryPage;
import web.saucedemo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;

public class Saucedemo_0000 {

    WebDriver wd;
    CartPage cartPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    InventoryPage inventoryPage;


    @BeforeMethod
    @Parameters({"platform"})
    public void setUp(String platform) {
        wd = new DriverSetup().chooseDriver(Platform.valueOf(platform));
        inventoryPage = new InventoryPage(wd);
        checkoutPage = new CheckoutPage(wd);
        loginPage = new LoginPage(wd);
        cartPage = new CartPage(wd);
    }

    @Test
    public void buy_all_products() {
        wd.get("https://www.saucedemo.com/");
        loginPage.doLoginAndVerify(Credentials.SaucedemoCredentials.username1, Credentials.SaucedemoCredentials.password);
        inventoryPage.addAllProductsInTheCart();
        inventoryPage.openCartPage();
        cartPage.goToCheckout();
        checkoutPage.doCheckout("firstname", "lastname", "00000");
    }

    @AfterMethod
    public void tearDown() {
        wd.close();
    }
}
