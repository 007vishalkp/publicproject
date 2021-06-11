package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.SearchEnginePage;
import support.DriverManager;
import support.PageName;
import support.PageObjectManager;

public class SearchEngineSteps {
    private SearchEnginePage searchEnginePage = null;
    private WebDriver driver = null;

    public SearchEngineSteps(PageObjectManager pageObjectManager) {
        searchEnginePage = pageObjectManager.getDashboardPage();
        driver = DriverManager.getDriver();
    }

    @Given("User is on {string} page")
    public void userIsOnPage(String pageName) {
        String url = PageName.getPageUrl().get(pageName);
        driver.get(url);
    }

    @When("User searches for the {string}")
    public void userSearchesForThe(String searchText) {
        searchEnginePage.search(searchText);
    }

    @Then("User is shown with cardekho or carwale results")
    public void userIsShownWithAppropriateResults() {
        Assert.assertTrue(searchEnginePage.searchResults(),"There are no cardeko and carwale links in the search result.");
    }

    @And("User checks the links for appropriate search {string}")
    public void userChecksTheLinksForResults(String searchText) {
        Assert.assertTrue(searchEnginePage.checkLinks(searchText),"The search text is not present in the given links.");
    }
}
