package appiumscripts.day22;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class day22 {

    @Test
    public void hostelSearch() throws MalformedURLException, InterruptedException {

        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Android Emulator");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("appPackage", "com.hostelworld.app");
        cap.setCapability("app", file.getAbsolutePath());
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElementById("com.hostelworld.app:id/arrow").click();
        driver.findElementById("com.hostelworld.app:id/arrow").click();
        driver.findElementById("com.hostelworld.app:id/arrow").click();
        driver.findElementById("com.hostelworld.app:id/done").click();

        driver.findElementById("com.hostelworld.app:id/searchBoxDestinationTv").click();
        driver.findElementById("com.hostelworld.app:id/suggestionEt").sendKeys("Berlin");
        driver.findElementByXPath("//android.widget.TextView[@text='Berlin, Germany']")
                .click();

        driver.findElementById("com.hostelworld.app:id/searchButton").click();

        Thread.sleep(5000);
         driver.pressKey(new KeyEvent(AndroidKey.BACK));

         String previousSearchResult = driver.findElementById("com.hostelworld.app:id/previousSearchCityTv").getText();

         Assert.assertEquals(previousSearchResult, "Berlin");


        /*driver.findElementById("com.hostelworld.app:id/propertyImageBackgroundView")
                .click();

        String address = driver.findElementById("com.hostelworld.app:id/property_address").getText();

        boolean addressPresence = address.contains("Berlin");

        Assert.assertTrue(addressPresence);
        Assert.assertTrue(address.contains("Berlin"));*/



      /*MobileElement element = (MobileElement) driver.findElementsById("com.hostelworld.app:id/propertyImageBackgroundView")
                .get(0);

      element.click();*/

    }
}
