package element;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class WebUI {

    static WebDriver wd;

    public WebUI(WebDriver wd) {
        WebUI.wd =wd;
        PageFactory.initElements(wd, this);
    }

    static FluentWait<WebDriver> wait = new FluentWait<>(wd).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(3)).
            ignoring(InvalidElementStateException.class).
            ignoring(NoSuchElementException.class).
            ignoring(ClassCastException.class);

    public static void click(WebElement element) {
        wait.until(wd -> ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static String getText(WebElement element) {
        wait.until(wd -> ExpectedConditions.visibilityOf(element));
        return (element.getText());
    }

    public static void setText(WebElement element, String text) {
        wait.until(wd -> ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public static void verifyElementPresent(WebElement element) {
        wait.until(wd -> ExpectedConditions.visibilityOf(element));
    }

    public static void verifyElementNotPresent(WebElement element) {
        wait.until(wd -> ExpectedConditions.invisibilityOf(element));
    }

    public static void verifyElementsPresent(List<WebElement> elements) {
        wait.until(wd -> ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void verifyElementsNotPresent(List<WebElement> elements) {
        wait.until(wd -> ExpectedConditions.invisibilityOfAllElements(elements));
    }
}
