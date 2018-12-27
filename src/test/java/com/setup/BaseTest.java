package com.setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ahmetbaltaci on 22.12.2017.
 */
public class BaseTest {


    public static AppiumDriver driver;
    protected WebDriverWait wait;
    private String testCaseName;
    private long testStartTime;
    private long testFinishTime;
    private long testDurationTime;
    private String testFailedMsg;

    public WebDriver getDriver() {
        return driver;
    }

    protected long getTestStartTime() {
        return testStartTime;
    }

    protected void setTestStartTime(long testStartTime) {
        this.testStartTime = testStartTime;
    }

    protected long getTestFinishTime() {
        return testFinishTime;
    }

    protected void setTestFinishTime(long testFinishTime) {
        this.testFinishTime = testFinishTime;
    }

    protected long getTestDurationTime() {
        return testDurationTime;
    }

    protected void setTestDurationTime(long testDurationTime) {
        this.testDurationTime = testDurationTime;
    }

    protected String getTestCaseName() {
        return testCaseName;
    }

    protected void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestFailedMsg() {
        return testFailedMsg;
    }

    public void setTestFailedMsg(String testFailedMsg) {
        this.testFailedMsg = testFailedMsg;
    }

    public static int step;
    public void steps(String message){
        System.out.println(step + ". " + message);
        step = (step + 1);
    }
    public void setStep() { step = 1; }
    public int getStep() { return step; }

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    @BeforeSuite()
    public void setUp() throws MalformedURLException, InterruptedException, FileNotFoundException {
        DeviceSetup.prepareDevice();
        wait = new WebDriverWait(driver,15);

        System.out.println("============================================");
        System.out.println("Project      : OVO Automation");
        System.out.println("Date         : "+ dateFormat.format(date));
        System.out.println("Platform     : "+ Constants.DEFAULT_PLATFORM);
        System.out.println("Device name	 : "+ Constants.DEFAULT_ANDROID_DEVICE_NAME);
        System.out.println("============================================");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
