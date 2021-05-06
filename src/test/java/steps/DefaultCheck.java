package steps;

import appiumscripts.day23.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class DefaultCheck {

    private BaseSteps baseSteps;

    private MyTripsScreen myTripsScreen;
    private WishListPage wishListPage;
    private ExplorePage explorePage;
    private HostelSpeakPage hostelSpeakPage;
    private SearchPage searchPage;
    String defaultGuest ;

    public DefaultCheck(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
        myTripsScreen = new MyTripsScreen(baseSteps.driver);
        wishListPage = new WishListPage(baseSteps.driver);
        explorePage = new ExplorePage(baseSteps.driver);
        hostelSpeakPage = new HostelSpeakPage(baseSteps.driver);
        searchPage = new SearchPage(baseSteps.driver);
    }


    @Given("Application is launched with all required desired capabilities")
    public void applicationIsLaunchedWithAllRequiredDesiredCapabilities() {
        myTripsScreen.verifyArrowIconIsDisplayed();
    }

    @And("User clicks on arrow button of MyTrips Screen")
    public void userClicksOnArrowButtonOfMyTripsScreen() {
        myTripsScreen.clickArrowButtonOnMyTripsScreen();
    }

    @And("User clicks on arrow button of WishList Screen")
    public void userClicksOnArrowButtonOfWishListScreen() {
        wishListPage.clickArrowButtonOnWishListPage();
    }

    @And("User clicks on arrow button of Explore Screen")
    public void userClicksOnArrowButtonOfExploreScreen() {
        explorePage.clickArrowButtonOnExplorePage();
    }

    @And("User clicks on done  button of HostelSpeak Screen")
    public void userClicksOnDoneButtonOfHostelSpeakScreen() {
        hostelSpeakPage.clickDoneButton();
    }

    @Then("Search screen is displayed")
    public void searchScreenIsDisplayed() {
        searchPage.isSerachButtonDisplayed();
    }

    @When("User checks the default guest")
    public void userChecksTheDefaultGuest() {
        defaultGuest = searchPage.getDefaultNumberOfGuests();
    }

    @Then("User verifies that default guest number is displayed as {string}")
    public void userVerifiesThatDefaultGuestNumberIsDisplayedAs(String arg0) {
        Assert.assertEquals(defaultGuest,arg0);
    }
}
