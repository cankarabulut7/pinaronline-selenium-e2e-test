package com.pinaronline.tests;

import com.pinaronline.pages.BasketPage;
import com.pinaronline.pages.GuestCheckoutPage;
import org.testng.annotations.Test;

public class GuestCheckoutTest extends BaseTest {

    @Test
    public void guestCheckoutTest() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage(driver);
        BasketPage basketPage = new BasketPage(driver);

        guestCheckoutPage.clickRandomNewProduct();
        guestCheckoutPage.clickAddToBasket();
        guestCheckoutPage.fillTheDeliveryAdress();

        basketPage.addToBasket();
        basketPage.increaseQuantity();
        basketPage.goToBasketAndCheck();

        guestCheckoutPage.goToCheckoutPage();
        guestCheckoutPage.fillMailAndPhoneNumberFields("can@deneme.com","533849670");
        guestCheckoutPage.fillDeliveryAddressForm("Test", "Can", "Karabulut", "Bahçeşehir", "21", "9", "56");

        guestCheckoutPage.makePayment("Can Karabulut", "4543 1111 0000 22222", "1132", "123");
    }
}
