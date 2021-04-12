package appiumscripts.day01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IsAppInstalled {

    @Test
    public void isAppInstalled() throws InterruptedException, MalformedURLException {

        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","Android Emulator");
        cap.setCapability("platformName","Android");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("appPackage","com.hostelworld.app");
        cap.setCapability("app",file.getAbsolutePath());

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        Thread.sleep(8000);

        boolean bool = driver.isAppInstalled("com.hostelworld.app");
        System.out.println("status before unistalling " + bool);

        Thread.sleep(3000);
        driver.removeApp("com.hostelworld.app");
        boolean bool1 = driver.isAppInstalled("com.hostelworld.app");
        System.out.println("status after uninstalling " + bool1);

        System.out.println("Test is eneded ");

    }
}
