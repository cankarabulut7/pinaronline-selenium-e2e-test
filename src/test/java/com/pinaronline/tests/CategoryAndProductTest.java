package com.pinaronline.tests;

import com.pinaronline.pages.BasketPage;
import com.pinaronline.pages.CategoryAndProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoryAndProductTest extends BaseTest {

    @Test
    public void testCategoryNavigationAndProductPage() throws InterruptedException {
        CategoryAndProductPage categoryAndProductPage = new CategoryAndProductPage(driver);

        categoryAndProductPage.openCategoryBar();
        categoryAndProductPage.clickRandomCategory();
        categoryAndProductPage.clickRandomProduct();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/urun/"), "Product detail page is not shown!");
    }

    @Test
    public void BasketTest() throws InterruptedException {
        testCategoryNavigationAndProductPage();
        BasketPage basketPage = new BasketPage(driver);

        basketPage.addToBasket();
        basketPage.checkAddToBasketNotify();

        basketPage.increaseQuantity();
        basketPage.decreaseQuantity();

        basketPage.goToBasketAndCheck();
        basketPage.deleteProductFromBasket();
    }
}
