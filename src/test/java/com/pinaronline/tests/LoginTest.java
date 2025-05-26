package com.pinaronline.tests;

import com.pinaronline.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginViaOtpLoginTest() {
        String phoneNumber = "533849670";

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLoginRegisterButton();
        loginPage.clickLoginAndRegisterMenuButton();

        loginPage.enterPhoneNumber(phoneNumber);
        loginPage.clickPhoneNumberConfirmButton();

        loginPage.enterOtpCode("1414");

        Assert.assertTrue(loginPage.isUserLoggedIn(), "User is not logged in");
    }
}
