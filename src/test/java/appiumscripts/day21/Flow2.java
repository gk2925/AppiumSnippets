package appiumscripts.day21;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Flow2 {

    @Test
    public void flow2() throws MalformedURLException {
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


      String defaultGuest=   driver
              .findElementById("com.hostelworld.app:id/guest_selector_number").getText();

        Assert.assertEquals(defaultGuest,"2");

        String dateText = driver.findElementById("com.hostelworld.app:id/selectedDateTv").getText();

        System.out.println(dateText);

        String firstDate  = dateText.substring(0,2);
        String secondDate = dateText.substring(9,11);


        System.out.println(firstDate);
        System.out.println(secondDate);


        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-YYYY");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,1);

        Date date1= calendar.getTime();
        String advanceDate1 = f.format(date1);

        System.out.println("first advance date is :" + advanceDate1);

        String realAdvanceDate1 = advanceDate1.substring(0,2);
        System.out.println(realAdvanceDate1);

        Assert.assertEquals(realAdvanceDate1,firstDate);


        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DAY_OF_MONTH,4);

        Date date2= calendar1.getTime();
        String advanceDate2 = f.format(date2);

        System.out.println("second advance date is :" + advanceDate2);

        String realAdvanceDate2 = advanceDate2.substring(0,2);
        System.out.println(realAdvanceDate2);

        Assert.assertEquals(realAdvanceDate2,secondDate);











    }
}
