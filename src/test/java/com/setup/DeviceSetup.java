package com.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DeviceSetup extends BaseTest {


   static AppiumDriver prepareDevice() throws MalformedURLException {
        File appDir = new File("/Users/noviherdianti/Downloads");
//        File app = new File(appDir, "uangtemanDev3.app");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
//        capabilities.setCapability(MobileCapabilityType.PLATFORM, "MAC");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 6");
//        capabilities.setCapability("udid","A1F0218C-D7C2-4704-A4D1-89208821A8F0");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//        capabilities.setCapability("appium-version", "1.7.1");
//        capabilities.setCapability("autoAcceptAlerts",false);
//        capabilities.setCapability("noReset","true");
//        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
//        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        return driver;
        File app = new File(appDir, "ovo.id_2018-11-29.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Constants.DEFAULT_ANDROID_PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.DEFAULT_ANDROID_DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 320000);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        capabilities.setCapability("appPackage", Constants.DEFAULT_APP_PACKAGE);
        capabilities.setCapability("appActivity", Constants.DEFAULT_APP_ACTIVITY);
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("autoGrantPermissions", true);

        driver = new AndroidDriver(new URL(Constants.WD_URL), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
   }
}
