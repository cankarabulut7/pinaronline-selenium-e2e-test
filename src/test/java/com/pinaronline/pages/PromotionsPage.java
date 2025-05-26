package com.pinaronline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PromotionsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By campaignMenuButton = By.xpath("//a[@href='/kampanya']");
    private By promotionImages = By.cssSelector("div[data-index] img");

    public PromotionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToPromotionsPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campaignMenuButton)).click();
        String getCurrentUrl = driver.getCurrentUrl();
        Assert.assertTrue(getCurrentUrl.contains("kampanya"), "URL should contain 'kampanya' after navigation.");
    }

    public void verifyPromotionImagesAreLoaded() {
        List<WebElement> images = driver.findElements(promotionImages);
        Assert.assertTrue(images.size() > 0, "No promotion images found on the page!");

        for (WebElement img : images) {
            String src = img.getAttribute("src");
            Assert.assertNotNull(src, "The image element's 'src' attribute is null!");
            Assert.assertFalse(src.isEmpty(), "The image element's 'src' attribute is empty!");
        }
    }
}
