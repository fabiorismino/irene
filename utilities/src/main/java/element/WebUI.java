package element;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

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

    public static void setText(WebElement element, String text) {
        wait.until(wd -> ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
}
