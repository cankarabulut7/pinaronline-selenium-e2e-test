package com.pinaronline.tests;

import com.pinaronline.pages.PromotionsPage;
import org.testng.annotations.Test;

public class PromotionsTest extends BaseTest {

    @Test
    public void promotionsTest() {
        PromotionsPage promotionsPage = new PromotionsPage(driver);
        promotionsPage.navigateToPromotionsPage();
        promotionsPage.verifyPromotionImagesAreLoaded();
    }
}
