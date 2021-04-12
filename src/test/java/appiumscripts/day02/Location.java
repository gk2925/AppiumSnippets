package appiumscripts.day02;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Location {
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

        Thread.sleep(4000);

       WebElement element1 = driver1.findElementById("com.hostelworld.app:id/arrow");
       if(element1 instanceof MobileElement){
           System.out.println("downcatsing is possible");
           MobileElement element = (MobileElement)element1;
       }

       else {
           System.out.println("NOT POSSIBLE");
       }



        System.out.println("Test is eneded ");
    }

}
