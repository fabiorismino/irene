package web.saucedemo.pages;

import element.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

public class InventoryPage {

    WebDriver wD;

    @FindBy(xpath = "//*[@class=\"shopping_cart_link\"]")
    WebElement buttonShoppingCart;

    @FindBy(xpath = "//*[@class=\"shopping_cart_link\"]//span")
    WebElement badgeShoppingCart;

    @FindBy(xpath = "//*[contains(text(), \"Add to cart\")]")
    List<WebElement> listButtonAddToCart;

    @FindBy(xpath = "//*[contains(text(), \"Remove\")]")
    List<WebElement> listButtonRemoveToCart;

    @FindBy(xpath = "//*[@class=\"inventory_item_price\"]/text()[2]")
    List<WebElement> listIInventoryItemPrice;

    public InventoryPage(WebDriver wD) {
        this.wD = wD;
        PageFactory.initElements(wD, this);
    }

    public void addAllProductsInTheCart() {
        for (WebElement buttonAddToCart : listButtonAddToCart) {
            WebUI.click(buttonAddToCart);
            System.out.println("Number of products added in the cart: "+listButtonRemoveToCart.size());
            System.out.println("Number of products not added in the cart: "+listButtonAddToCart.size());
        }
        WebUI.verifyElementPresent(badgeShoppingCart);
        Assert.assertEquals(Integer.parseInt(WebUI.getText(badgeShoppingCart)), listButtonRemoveToCart.size());
    }

    public void openCartPage() {
        WebUI.click(buttonShoppingCart);
    }
}
