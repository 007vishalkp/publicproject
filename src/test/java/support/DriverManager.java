package support;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver driver = null;
    private static int addLongDelay = 10;
    private static int addShortDelay = 10;
    private static WebDriverWait wait = null;


    public static WebDriver initWindowsDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/Windows/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("-start-maximized");
        //chromeOptions.addArguments("-start-fullscreen");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(addShortDelay, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, addLongDelay);
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }

        return driver;
    }


    public static WebDriverWait getWait() {
        return wait;
    }

    public static void close() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
        PageObjectManager.setPageObjectManagerToNull();
        driver = null;
    }
}
