package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.DriverManager;

import java.util.List;


public class SearchEnginePage {
    @FindBy(xpath = "//input[@title='Search']")
    private WebElement searchBar;
    @FindBy(xpath = "//a//*[text()=\"https://www.cardekho.com\"] | //a//*[text()=\"https://www.carwale.com\"]")
    private List<WebElement> listOfResults;
    @FindBy(xpath = "//h1")
    private WebElement searchHeading;

    private WebDriver driver = DriverManager.getDriver();
    private WebDriverWait wait = DriverManager.getWait();

    /**
     * This method will search for the text on google search engine
     *
     * @param searchText
     */
    public void search(String searchText) {
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(searchText);
        searchBar.sendKeys(Keys.ENTER);
    }

    /**
     * This method will verify if the search results have cardekho or carwale links.
     *
     * @return true if cardekho or carwale links are more than 0
     */
    public boolean searchResults() {
        boolean resultFlag = false;
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfResults));
        System.out.println("There are totally: " + listOfResults.size() + " results with cardekho and carwale web links");
        resultFlag = listOfResults.size() > 0;
        return resultFlag;
    }

    /**
     * This method will check the cardeko and carwale links whether it has the searched text in it or not by invoking a internal method.
     *
     * @param searchText
     * @return true if the links have the searched text.
     */
    public boolean checkLinks(String searchText) {
        boolean verifyFlag;
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfResults));
        for (int i = 0; i < listOfResults.size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(listOfResults.get(i)));
            listOfResults.get(i).click();
            verifyFlag = verifyHeading(searchText);
            if (!verifyFlag) {
                return false;
            }
            driver.navigate().back();
        }
        return true;
    }

    /**
     * This method will check for the heading, if it has the searched text
     * @param searchText
     * @return true if the links have the searched text.
     */
    private boolean verifyHeading(String searchText) {
        String expectedText = null;
        searchText = searchText.toLowerCase();
        wait.until(ExpectedConditions.visibilityOf(searchHeading));
        expectedText = searchHeading.getText().toLowerCase();

        return expectedText.contains(searchText);
    }

}