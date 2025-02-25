package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class DriverSetter {

    WebDriver wd;

    @Parameters({"platform"})
    public WebDriver setWebDriver(@Optional String platform) {
        switch (platform) {
            case "CHROME_DESKTOP":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                wd = new ChromeDriver(chromeOptions);
                break;

            case "SAFARI_DESKTOP":
                SafariOptions safariOptions = new SafariOptions();
                wd = new SafariDriver(safariOptions);
                wd.manage().window().maximize();
                break;

            case "FIREFOX_DESKTOP":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                wd = new FirefoxDriver(firefoxOptions);
                wd.manage().window().maximize();

        }
        return wd;
    }
}
