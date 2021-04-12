package appiumscripts.day06;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SampleScriptsNavigtaion {

    @Test
    public void testSampleNavigation() throws MalformedURLException, InterruptedException {
        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Android Emulator");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("appPackage", "com.hostelworld.app");
        cap.setCapability("app", file.getAbsolutePath());

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        Thread.sleep(5000);

        MobileElement arrowElement = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        arrowElement.click();

        Thread.sleep(2000);
        MobileElement arrowElement1 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        arrowElement1.click();
        Thread.sleep(2000);
        MobileElement arrowElement2 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        arrowElement2.click();
        Thread.sleep(2000);
        MobileElement doneElement = (MobileElement) driver.findElementById("com.hostelworld.app:id/done");
        doneElement.click();
        Thread.sleep(2000);
        MobileElement textBoxDestination = (MobileElement) driver.
                findElementById("com.hostelworld.app:id/searchBoxDestinationTv");
        textBoxDestination.click();
        Thread.sleep(3000);
        MobileElement textBoxSuggestion = (MobileElement) driver.
                findElementById("com.hostelworld.app:id/suggestionEt");
        textBoxSuggestion.clear();
        textBoxSuggestion.sendKeys("Munich");

        Thread.sleep(5000);


    }
}
