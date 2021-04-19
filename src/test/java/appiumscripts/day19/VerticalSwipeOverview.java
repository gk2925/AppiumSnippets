package appiumscripts.day19;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class VerticalSwipeOverview {

    public void verticalSwipe(AndroidDriver driver) throws InterruptedException {

        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println("Height is " + height);
        System.out.println("Width is " + width );

        TouchAction action = new TouchAction(driver);

        int x1 = (50*width)/100;
        int y1 = (80*height)/100;

        System.out.println("X1 is : " + x1);
        System.out.println("Y1 is : " + y1);

        int x2=  (50*width)/100;
        int y2 = (20*height)/100;

        System.out.println("X2 is : " + x2);
        System.out.println("Y2 is : " + y2);


        Thread.sleep(5000);
        action.press(PointOption.point(x1,y1))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x2,y2))
                .release()
                .perform();


    }


    @Test
    public void verticalSwipeDemo() throws MalformedURLException, InterruptedException {

        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Android Emulator");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("appPackage", "com.hostelworld.app");
        cap.setCapability("app", file.getAbsolutePath());
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MobileElement arrow1 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        arrow1.click();

        MobileElement arrow2 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        arrow2.click();


        MobileElement arrow3 = (MobileElement) driver.findElementById("com.hostelworld.app:id/arrow");
        arrow3.click();

        MobileElement doneElement = (MobileElement) driver.findElementById("com.hostelworld.app:id/done");
        doneElement.click();

        MobileElement profileIcon = (MobileElement) driver
                .findElementById("com.hostelworld.app:id/bottom_nav_profile");
        profileIcon.click();

        MobileElement joinUsButton = (MobileElement)driver
                .findElementById("com.hostelworld.app:id/profileLogoutJoinButton");
        joinUsButton.click();

        verticalSwipe(driver);

        MobileElement chkboxElement = (MobileElement)driver.findElementById("com.hostelworld.app:id/terms_and_conditions_checkbox");
        chkboxElement.click();

        Thread.sleep(4000);

        MobileElement toggleElement = (MobileElement)driver.findElementById("com.hostelworld.app:id/switchPrivateSw");
        toggleElement.click();

        Thread.sleep(5000);








    }

}
