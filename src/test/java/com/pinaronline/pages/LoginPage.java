package com.pinaronline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By LoginAndRegisterButton = By.id("radix-:r7:");
    private By LoginAndRegisterMenuButton = By.xpath("//div[@role='menuitem']//button[.//span[text()='Giriş Yap ya da Üye Ol']]");
    private By phoneNumberInput = By.cssSelector("input[type='tel'].text-size-text");
    private By PhoneNumberConfirmButton = By.id("devam_et");
    private By userProfileIcon = By.id("Profil");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLoginRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginAndRegisterButton)).click();
    }

    public void clickLoginAndRegisterMenuButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginAndRegisterMenuButton)).click();
    }

    public void enterPhoneNumber(String phoneNumber){
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberInput)).sendKeys(phoneNumber);
    }

    public void clickPhoneNumberConfirmButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberConfirmButton)).click();
    }

    public void enterOtpCode(String otp) {
        if (otp.length() != 4) {
            throw new IllegalArgumentException("OTP code should be 4 character!");
        }

        for (int i = 0; i < 4; i++) {
            String xpath = String.format("//input[@aria-label='Please enter OTP character %d']", i + 1);
            WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            input.clear();
            input.sendKeys(String.valueOf(otp.charAt(i)));
        }
    }

    public boolean isUserLoggedIn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileIcon)).isDisplayed();
    }
}