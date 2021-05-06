package steps;

import appiumscripts.day23.SearchPage;
import appiumscripts.day23.SearchResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSteps {
    private BaseSteps baseSteps;
    private SearchPage searchPage;
    private SearchResultsPage searchResultsPage;

    public SearchSteps(BaseSteps baseSteps){
        this.baseSteps = baseSteps;
        searchPage = new SearchPage(baseSteps.driver);
        searchResultsPage = new SearchResultsPage(baseSteps.driver);


    }

    @When("User searches for a particular city")
    public void userSearchesForAParticularCity() {
        searchPage.searchCity("Berlin");
    }

    @Then("Search results are displayed")
    public void searchResultsAreDisplayed() {
        searchResultsPage.isFilterIconDisplayed();
    }

    @When("User searches for a {string}")
    public void userSearchesForA(String arg0) {
        searchPage.searchCity(arg0);
    }
}
