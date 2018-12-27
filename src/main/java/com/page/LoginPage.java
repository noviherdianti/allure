package com.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage (AppiumDriver driver){super(driver);}

    private By phoneNumberField = By.id("field_account");
    private By signInBtn = By.id("btn_sign_in");
    private By joinBtn = By.id("btn_join");



    @Step("Input Phone number")
    public void inputNoHp(String no_hp) throws InterruptedException{
        isEnableElement(joinBtn);
        enterText(phoneNumberField, no_hp);
    }

    @Step("Tap Signin Button")
    public void tapSignIn() throws InterruptedException {
        click(signInBtn);
    }

    @Step("SignIn Ovo")
    public void goToSignIn(String no_hp) throws InterruptedException{
        inputNoHp(no_hp);
        tapSignIn();
    }

}
