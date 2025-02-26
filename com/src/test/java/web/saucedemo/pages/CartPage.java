package web.saucedemo.pages;

import element.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    WebDriver wD;

    @FindBy(xpath = "class=\"cart_item\"")
    List<WebElement> listCartItem;

    @FindBy(xpath = "//*[contains(text(), \"Checkout\")]")
    WebElement buttonCheckout;

    public CartPage(WebDriver wD) {
        this.wD = wD;
        PageFactory.initElements(wD, this);
    }

    public void goToCheckout() {
        WebUI.verifyElementsPresent(listCartItem);
        WebUI.click(buttonCheckout);
    }
}
