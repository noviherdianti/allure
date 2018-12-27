package com.testCase;

import com.page.LaunchPage;
import com.page.LoginPage;
import com.setup.BaseTest;
import io.qameta.allure.*;
import listener.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by ahmetbaltaci on 12.05.2018.
 */

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Login")


public class LoginTest extends BaseTest {
        @Test
        @Severity(SeverityLevel.BLOCKER)
        @Description("Test Description: Successful Login")
        @Story("News page")
        public void testing () throws InterruptedException {
            steps("Verify Launch Page is Displayed");
            LaunchPage launchPage = new LaunchPage(driver);
            launchPage.VerifyLaunchPage();
            steps("Verify Successful sign in");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.goToSignIn("085718522190");
        }

}
