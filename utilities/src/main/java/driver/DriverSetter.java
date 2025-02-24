package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverSetter {

    WebDriver wd;

    public WebDriver chooseDriver(String platform) {
        switch (platform) {
            case "Chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                wd = new ChromeDriver(chromeOptions);
                break;

            case "Safari":
                SafariOptions safariOptions = new SafariOptions();
                wd = new SafariDriver(safariOptions);
                wd.manage().window().maximize();
                break;
        }
        return wd;
    }
}
