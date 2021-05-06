package steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private BaseSteps baseSteps;

    public Hooks(BaseSteps baseSteps){
        this.baseSteps = baseSteps;

    }

    @Before
    public void setUpAppium(){
        File file = new File("src/Hostelworld.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Android Emulator");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("appPackage", "com.hostelworld.app");
        cap.setCapability("app", file.getAbsolutePath());

        try {
            baseSteps.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        baseSteps.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }


    @After
    public void tearDown(){
        baseSteps.driver.quit();
    }
}
