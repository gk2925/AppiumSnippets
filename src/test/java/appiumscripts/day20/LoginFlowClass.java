package appiumscripts.day20;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginFlowClass {
    @Test
    public void loginFlow() throws MalformedURLException {
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
        driver.findElementById("com.hostelworld.app:id/profileLogoutLoginButton").click();

        driver.findElementById("com.hostelworld.app:id/usernameEt")
                .sendKeys("gty@gmail.com");

        driver.findElementById("com.hostelworld.app:id/passwordEt")
                .sendKeys("abcd");

        driver.findElementById("com.hostelworld.app:id/loginButton")
                .click();
        String actualText = driver
                .findElementById("com.hostelworld.app:id/alertTitle").getText();

        Assert.assertEquals(actualText,"Login Passed");

    }
}
