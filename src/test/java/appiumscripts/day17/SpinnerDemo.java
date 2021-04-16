package appiumscripts.day17;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SpinnerDemo {

    @Test
    public void spinnerDemo() throws MalformedURLException, InterruptedException {

        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Android Emulator");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("appPackage", "com.hostelworld.app");
        cap.setCapability("app", file.getAbsolutePath());

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        MobileElement arrow1 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        arrow1.click();

        MobileElement arrow2 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        arrow2.click();


        MobileElement arrow3 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        arrow3.click();

        MobileElement doneElement = (MobileElement) driver.findElementById("com.hostelworld.app:id/done");
        doneElement.click();

        MobileElement profileIcon = (MobileElement) driver
                .findElementById("com.hostelworld.app:id/bottom_nav_profile");
        profileIcon.click();

        MobileElement joinUsButton = (MobileElement)driver
                .findElementById("com.hostelworld.app:id/profileLogoutJoinButton");
        joinUsButton.click();

        MobileElement genderSpinner = (MobileElement)driver
                .findElementById("com.hostelworld.app:id/gender_spinner");
        genderSpinner.click();

        MobileElement genderText = (MobileElement)driver
                .findElementByXPath("//android.widget.TextView[@text='Female']");
        genderText.click();

        MobileElement nationalitySpinner = (MobileElement)driver
                .findElementById("com.hostelworld.app:id/nationality_textview");
        nationalitySpinner.click();

        MobileElement listItem = (MobileElement)driver
                .findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Germany\"));"));

        listItem.click();

        Thread.sleep(8000);

    }
}
