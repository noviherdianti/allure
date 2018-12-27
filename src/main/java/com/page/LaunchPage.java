package com.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by
 */
public class LaunchPage extends BasePage {

    public LaunchPage(AppiumDriver driver){super(driver);}

    private By ovoIgm = By.id("ovo.id:id/img_logo_ovo");
    private By mulaiBtn = By.id("ovo.id:id/btn_get_started");


    @Step("swipe")
    public void swipe() throws InterruptedException {
        waitFor(1);
        scrollscreen(821,1422,329,1422);
    }

    @Step("Verify Ovo launch page is displayed")
    public void VerifyLaunchPage() throws InterruptedException {
        isEnableElement(ovoIgm);
        swipe();
        swipe();
        swipe();
        swipe();
        click(mulaiBtn);

    }

}
