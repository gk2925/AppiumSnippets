package appiumscripts.day23;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SearchPage {

    private AndroidDriver driver;

    @AndroidFindBy(id = "com.hostelworld.app:id/searchBoxDestinationTv")
    private MobileElement searchTextBox;

    @AndroidFindBy(id = "com.hostelworld.app:id/suggestionEt")
    private MobileElement suggestionTextBox;

    @AndroidFindBy(id = "com.hostelworld.app:id/searchButton")
    private MobileElement searchButton;

    @AndroidFindBy(id = "com.hostelworld.app:id/selectedDateTv")
    private MobileElement textOfDefaultCalendarDate;

    @AndroidFindBy(id = "com.hostelworld.app:id/guest_selector_number")
    private MobileElement textOfDefaultPersons;

    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements
                (new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public String getDefaultNumberOfGuests() {
        return (textOfDefaultPersons.getText());
    }

    public void isSerachButtonDisplayed(){
        searchButton.isDisplayed();
    }


    public SearchResultsPage searchCity(String cityText) {

        searchTextBox.click();
        suggestionTextBox.sendKeys(cityText);

        MobileElement autoSuggestiontext =
                (MobileElement) driver.findElementByXPath("//android.widget.TextView[starts-with(@text,'" + cityText + "')]");

        autoSuggestiontext.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        searchButton.click();
        return new SearchResultsPage(driver);
    }

}
