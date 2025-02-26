package web.saucedemo.pages;

import element.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver wD;

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    WebElement fieldUsername;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement fieldPassword;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    WebElement buttonLogin;

    @FindBy(xpath = "//*[@class=\"login-box\"]")
    WebElement boxLogin;

    public LoginPage(WebDriver wD) {
        this.wD = wD;
        PageFactory.initElements(wD, this);
    }

    public void doLoginAndVerify(String username, String password) {
        WebUI.verifyElementPresent(boxLogin);
        WebUI.setText(fieldUsername, username);
        WebUI.setText(fieldPassword, password);
        WebUI.click(buttonLogin);
        WebUI.verifyElementNotPresent(boxLogin);
    }
}
