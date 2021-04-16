package appiumscripts.day18;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DemoClass18 {

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
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println("Height is " + height);
        System.out.println("Width is " + width );

        TouchAction action = new TouchAction(driver);

        int x1 = (90*width)/100;
        int y1 = height/2;

        System.out.println("X1 is : " + x1);
        System.out.println("Y1 is : " + y1);

        int x2=  (10*width)/100;
        int y2 = height/2;

        System.out.println("X2 is : " + x2);
        System.out.println("Y2 is : " + y2);


        Thread.sleep(8000);
        action.press(PointOption.point(x1,y1))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x2,y2))
                .release()
                .perform();






    }

}
