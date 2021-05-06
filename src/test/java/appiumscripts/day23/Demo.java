package appiumscripts.day23;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Demo {

    @Test
    public void demotest() throws MalformedURLException {

        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Android Emulator");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("appPackage", "com.hostelworld.app");
        cap.setCapability("app", file.getAbsolutePath());

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MyTripsScreen myTripsScreen = new MyTripsScreen(driver);
        myTripsScreen.clickArrowButtonOnMyTripsScreen()
                .clickArrowButtonOnWishListPage()
                .clickArrowButtonOnExplorePage()
                .clickDoneButton();


    }

    @Test
    public void deafultGuestCheckTest() throws MalformedURLException {
        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Android Emulator");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("appPackage", "com.hostelworld.app");
        cap.setCapability("app", file.getAbsolutePath());

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MyTripsScreen myTripsScreen = new MyTripsScreen(driver);
        String actualNumber = myTripsScreen.clickArrowButtonOnMyTripsScreen()
                .clickArrowButtonOnWishListPage()
                .clickArrowButtonOnExplorePage()
                .clickDoneButton()
                .getDefaultNumberOfGuests();

        Assert.assertEquals(actualNumber,"2");
    }


    @Test
    public void searchCity() throws MalformedURLException {

        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Android Emulator");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("appPackage", "com.hostelworld.app");
        cap.setCapability("app", file.getAbsolutePath());

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MyTripsScreen myTripsScreen = new MyTripsScreen(driver);
      boolean result  = myTripsScreen.clickArrowButtonOnMyTripsScreen()
                .clickArrowButtonOnWishListPage()
                .clickArrowButtonOnExplorePage()
                .clickDoneButton()
                .searchCity("Berlin")
                .isFilterIconDisplayed();

      Assert.assertTrue(result);
    }
}
