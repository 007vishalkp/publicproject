package support;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.SearchEnginePage;

public class PageObjectManager {
    private static PageObjectManager pageObjectManager = null;
    private WebDriver driver;
    private AndroidDriver androidDriver;
    private SearchEnginePage searchEnginePage = null;

    public PageObjectManager() {
        String platform = "";
        driver = DriverManager.getDriver();
    }

    public static PageObjectManager getPageObjectManager() {
        if (pageObjectManager == null) {
            pageObjectManager = new PageObjectManager();
        }
        return pageObjectManager;
    }

    public static void setPageObjectManagerToNull() {
        pageObjectManager = null;
    }

    public SearchEnginePage getDashboardPage() {
        if (searchEnginePage == null) {
            searchEnginePage = PageFactory.initElements(driver, SearchEnginePage.class);
        }
        return searchEnginePage;
    }


}
