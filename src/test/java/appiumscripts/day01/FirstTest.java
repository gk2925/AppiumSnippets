package appiumscripts.day01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class FirstTest {
    @Test
    public void firstTestForAppium() throws MalformedURLException, InterruptedException {
        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","Android Emulator");
        cap.setCapability("platformName","Android");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("appPackage","com.hostelworld.app");
        cap.setCapability("app",file.getAbsolutePath());

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        Thread.sleep(4000);
        System.out.println("Application is invoked !");

        List<WebElement> list = driver.findElementsByClassName("android.widget.ImageView");
        list.size();


        System.out.println("The elements number is : " + list.size());





    }
}
