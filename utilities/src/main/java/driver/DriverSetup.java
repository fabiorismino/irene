package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverSetup {

    WebDriver wD;
    IOSDriver iosD;
    AndroidDriver aD;

    public enum Platform {
        IOS_WEB,
        IOS_APP,
        ANDROID_WEB,
        ANDROID_APP,
        CHROME_DESKTOP,
        SAFARI_DESKTOP,
        FIREFOX_DESKTOP,
    }

    public WebDriver chooseDriver(Platform platform) {
        switch (platform) {
            case IOS_WEB:
                //Implement code here
                break;

            case ANDROID_WEB:
                //Implement code here
                break;

            case CHROME_DESKTOP:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                wD = new ChromeDriver(chromeOptions);
                break;

            case SAFARI_DESKTOP:
                SafariOptions safariOptions = new SafariOptions();
                wD = new SafariDriver(safariOptions);
                wD.manage().window().maximize();
                break;

            case FIREFOX_DESKTOP:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                wD = new FirefoxDriver(firefoxOptions);
                wD.manage().window().maximize();
                break;
        }
        return wD;
    }
}
