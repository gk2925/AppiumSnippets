package appiumscripts.day17;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PressOperationDemo {


    public void pressAction(MobileElement element, AndroidDriver driver) throws InterruptedException {

        Thread.sleep(3000);

        int x= element.getLocation().getX();
        int y = element.getLocation().getY();

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .release()
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


        Thread.sleep(4000);
        MobileElement arrowElement = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        pressAction(arrowElement, driver);

       /* MobileElement arrowElement1 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        tapAction(arrowElement1, driver);
        MobileElement arrowElement2 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        tapAction(arrowElement2, driver);*/
    }
}
