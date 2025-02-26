package web.saucedemo.pages;

import element.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver wD;

    @FindBy(xpath = "//*[@class=\"checkout_info\"]")
    WebElement boxCheckoutInfo;

    @FindBy(xpath = "//*[@data-test=\"firstName\"]")
    WebElement fieldFirstname;

    @FindBy(xpath = "//*[@data-test=\"lastName\"]")
    WebElement fieldLastname;

    @FindBy(xpath = "//*[@data-test=\"postalCode\"]")
    WebElement fieldPostalCode;

    @FindBy(xpath = "//*[@data-test=\"continue\"]")
    WebElement buttonContinue;

    @FindBy(xpath = "//*[@data-test=\"finish\"]")
    WebElement buttonFinish;

    @FindBy(xpath = "//*[contains(text(), \"Thank you for your order!\")]")
    WebElement messageOrderCompleted;

    public CheckoutPage(WebDriver wD) {
        this.wD=wD;
        PageFactory.initElements(wD, this);
    }

    public void doCheckout(String firstname, String lastname, String postalcode) {
        WebUI.verifyElementPresent(boxCheckoutInfo);
        WebUI.setText(fieldPostalCode, postalcode);
        WebUI.setText(fieldFirstname, firstname);
        WebUI.setText(fieldLastname, lastname);
        WebUI.click(buttonContinue);
        WebUI.click(buttonFinish);
        WebUI.verifyElementPresent(messageOrderCompleted);
    }
}
