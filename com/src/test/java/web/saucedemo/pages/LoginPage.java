package web.saucedemo.pages;

import element.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebUI webUI;
    WebDriver wd;

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    WebElement fieldUsername;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement fieldPassword;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    WebElement buttonLogin;

    public LoginPage(WebDriver wd) {
        this.wd=wd;
        webUI = new WebUI(wd);
        PageFactory.initElements(wd, this);
    }

    public void setUsername(String username) {
        webUI.setText(fieldUsername, username);
    }

    public void setPassword(String password) {
        webUI.setText(fieldPassword, password);
    }

    public void clickButtonLogin() {
        webUI.click(buttonLogin);
    }

    public void doLogin(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickButtonLogin();
    }
}
