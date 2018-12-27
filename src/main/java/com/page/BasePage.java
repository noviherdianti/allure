package com.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.NoSuchElementException;


class BasePage {



    public AppiumDriver driver;
    public WebDriverWait wait;


    //Constructor
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
    }

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BasePage.class);

    /**
     * To create the timeout by convert it into second(s).
     * @param timeout what a long waiting time
     */
    public static void waitFor(long timeout) {
        long multipliedTimedOut = timeout * 1000;
        try {
            Thread.sleep(multipliedTimedOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void click(By element) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    String getText(By element) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    boolean isEnableElement(By element) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertTrue(driver.findElement(element).isEnabled());
        return true;
    }

    void assertText(By element, String text) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertEquals(driver.findElement(element).getText(),text);
    }

    public void enterText1(MobileElement element, String text){
        element.setValue(text);
    }

    void enterText(By element, String text) throws InterruptedException{
        isEnableElement(element);
        click(element);
//        Assert.assertTrue(driver.findElement(element).sendKeys(text););
        WebElement input = driver.findElement(element);
        input.sendKeys(text);

    }

    public void scrollscreen(int startX, int startY, int endX, int endY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(startX,startY).moveTo(endX, endY).release();
        touchAction.perform();
        waitFor(3);
    }

    public boolean isNoElementAvailable() { return NoSuchElementException.class.desiredAssertionStatus(); }

    public boolean isElementPresent(MobileElement element) {
        boolean condition = false;
        for (int i = 0; i < 3; i++) {
            try {
                if (isNoElementAvailable() || !element.isDisplayed()) {
                    System.out.println("Element not displayed");
                    log.info("xpath element is not displayed.");
                    waitFor(2);
                } else if (!isNoElementAvailable() || element.isDisplayed()){
                    System.out.println("Element displayed");
                    log.info("xpath element is displayed.");
                    condition = true;
                    break;
                }
            } catch (Exception e) {
                //
            }
        }
        return condition;
    }

    public void isElementPresentVerify(MobileElement element, String message){
//        Assert.assertTrue("Failed: "+message, isElementPresent(element));
        org.junit.Assert.assertTrue("Failed : "+ message, isElementPresent(element));
    }




}
