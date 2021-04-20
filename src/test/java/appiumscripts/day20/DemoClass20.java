package appiumscripts.day20;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DemoClass20 {

    @Test
    public void demoClassFlow() throws MalformedURLException, InterruptedException{

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
        driver.findElementById("com.hostelworld.app:id/bottom_nav_profile").click();
        driver.findElementById("com.hostelworld.app:id/profileLogoutJoinButton").click();

        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        Thread.sleep(4000);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        Thread.sleep(4000);

    }

}
