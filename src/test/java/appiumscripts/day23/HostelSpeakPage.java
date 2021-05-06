package appiumscripts.day23;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HostelSpeakPage {

    private AndroidDriver driver;


    @AndroidFindBy(id = "com.hostelworld.app:id/done")
    private MobileElement doneEelement;



    public HostelSpeakPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.
                initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public   SearchPage clickDoneButton(){
        doneEelement.click();
        return new SearchPage(driver);

    }
}
