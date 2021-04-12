package appiumscripts.day01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class BackgroundTest {

    @Test
    public void foregroundMethod() throws MalformedURLException, InterruptedException {
        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","Android Emulator");
        cap.setCapability("platformName","Android");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("appPackage","com.hostelworld.app");
        cap.setCapability("app",file.getAbsolutePath());

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        AndroidDriver driver1 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        AppiumDriver driver2 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        Thread.sleep(8000);

        driver.runAppInBackground(Duration.ofSeconds(10));

        Thread.sleep(5000);

        driver.activateApp("com.hostelworld.app");

        Thread.sleep(4000);

        System.out.println("Test is eneded ");
    }


}
