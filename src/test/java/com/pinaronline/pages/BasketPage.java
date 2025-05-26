package com.pinaronline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BasketPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By addToBasketButton = By.xpath("//button[.//span[text()='Sepete Ekle']]");
    private By addBasketNotifyPopup = By.xpath("//div[text()='Sepetiniz başarıyla güncellendi.']");
    private By increaseQuantityButton = By.xpath("(//div[@class='desktop-update-cart-section']//button)[2]");
    private By decreaseQuantityButton = By.xpath("(//div[@class='desktop-update-cart-section']//button)[1]");
    private By basketButton = By.id("radix-:r15:");
    private By goToBasketButton = By.xpath("//button[span[text()='Sepete Git']]");
    private By deleteProductButton = By.cssSelector("button.hidden.shrink-0.lg\\:block");
    private By emptyCartMessageText = By.xpath("//div[text()='Sepetinizde ürün bulunmamaktadır.']");

    public void addToBasket() {
        wait.until(ExpectedConditions.elementToBeClickable(addToBasketButton)).click();
        checkAddToBasketNotify();
    }

    public void increaseQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(increaseQuantityButton)).click();
        checkAddToBasketNotify();
    }

    public void decreaseQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(decreaseQuantityButton)).click();
        checkAddToBasketNotify();
    }

    public void checkAddToBasketNotify() {
        WebElement addBasketNotify = wait.until(ExpectedConditions.visibilityOfElementLocated(addBasketNotifyPopup));
        assert addBasketNotify.isDisplayed();
    }

    public void goToBasketAndCheck() {
        wait.until(ExpectedConditions.elementToBeClickable(basketButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(goToBasketButton)).click();

        wait.until(ExpectedConditions.urlToBe("https://testrio.pinaronline.com/sepet"));
    }

    public void deleteProductFromBasket() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteProductButton)).click();
        WebElement emptyCartMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessageText));
        assertTrue(emptyCartMessage.isDisplayed());
    }
}
