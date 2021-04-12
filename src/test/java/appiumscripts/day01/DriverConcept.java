package appiumscripts.day01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverConcept {


    @Test
    public void foregroundMethod() throws MalformedURLException, InterruptedException {
        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","Android Emulator");
        cap.setCapability("platformName","Android");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("appPackage","com.hostelworld.app");
        cap.setCapability("app",file.getAbsolutePath());
        AndroidDriver driver1 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);



        System.out.println("Test is eneded ");
    }

}
