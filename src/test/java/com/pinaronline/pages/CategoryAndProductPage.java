package com.pinaronline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CategoryAndProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By categoryMenu = By.xpath("//li[.//span[text()='Kategoriler']]");
    private By categoryLinks = By.cssSelector("a > div[data-category]");


    public CategoryAndProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openCategoryBar() {
        wait.until(ExpectedConditions.elementToBeClickable(categoryMenu)).click();
    }

    public void clickRandomCategory() {
        List<WebElement> categories = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(categoryLinks));
        Random random = new Random();
        int randomIndex = random.nextInt(categories.size());
        categories.get(randomIndex).click();
    }

    public void clickRandomProduct() {
        List<WebElement> urunler = driver.findElements(By.cssSelector("div.desktop-product"));
        if (urunler.isEmpty()) {
            throw new RuntimeException("Product Not Found!");
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(urunler.size());
        WebElement selectedProdut = urunler.get(randomIndex);
        WebElement product = selectedProdut.findElement(By.cssSelector("a[href*='/urun/']"));
        product.click();
    }
}