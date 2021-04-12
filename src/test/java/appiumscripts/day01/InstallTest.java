package appiumscripts.day01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class InstallTest {

    @Test
    public void firstTest() throws MalformedURLException, InterruptedException {

        File file = new File("src/Irctc.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","Android Emulator");
        cap.setCapability("platformName","Android");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("appPackage","cris.org.in.prs.ima");
        cap.setCapability("autoGrantPermissions",true);
        cap.setCapability("app",file.getAbsolutePath());

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        Thread.sleep(8000);
        driver.removeApp("cris.org.in.prs.ima");












    }

}
