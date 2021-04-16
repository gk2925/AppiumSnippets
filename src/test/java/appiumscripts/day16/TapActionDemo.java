package appiumscripts.day16;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TapActionDemo {


    public void tapAction(MobileElement element, AndroidDriver driver) throws InterruptedException {

        Thread.sleep(3000);
        TouchAction action = new TouchAction(driver);
        action.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(element)))
                .perform();
    }

    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Android Emulator");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("appPackage", "com.hostelworld.app");
        cap.setCapability("app", file.getAbsolutePath());

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        MobileElement arrowElement = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        tapAction(arrowElement, driver);
        MobileElement arrowElement1 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        tapAction(arrowElement1, driver);
        MobileElement arrowElement2 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        tapAction(arrowElement2, driver);
    }
}
