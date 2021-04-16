package appiumscripts.day16;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitDemo1 {

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

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.hostelworld.app:id/arrow")));

        MobileElement arrowElement = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        arrowElement.click();
        MobileElement arrowElement1 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        arrowElement1.click();
        MobileElement arrowElement2 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        arrowElement2.click();


    }
}

