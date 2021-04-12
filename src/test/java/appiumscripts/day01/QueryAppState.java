package appiumscripts.day01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class QueryAppState {

    @Test
    public void queryAppStateFunction() throws InterruptedException, MalformedURLException {
        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","Android Emulator");
        cap.setCapability("platformName","Android");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("appPackage","com.hostelworld.app");
        cap.setCapability("app",file.getAbsolutePath());

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        Thread.sleep(8000);

        int i = driver.queryAppState("com.hostelworld.app").ordinal();

        System.out.println("primary status " + i);

        Thread.sleep(5000);

        driver.closeApp();

        int j = driver.queryAppState("com.hostelworld.app").ordinal();
        System.out.println("secondary status" + j);



    }
}
