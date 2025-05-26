package com.pinaronline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class GuestCheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public GuestCheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By newProductLinks = By.xpath("//span[text()='Yeni']/ancestor::a");
    private By addToBasketButton = By.xpath("//button[.//span[text()='Sepete Ekle']]");
    private By provinceDropDown = By.id(":rj:-form-item");
    private By provinceOptions = By.cssSelector("[id='radix-:rk:'] button[role='option']");
    private By OkButton = By.xpath("//button[span[text()='Tamam']]");
    private By goToCheckOutButton =  By.xpath("//button[normalize-space()='Ödemeye Geç']");
    private By continueWithoutSignUpButton = By.xpath("//button[.//span[normalize-space(text())='Üye Olmadan Devam Et']]");
    private By guestMailField = By.id("guest-email");
    private By guestPhoneNumberField = By.id("tel");
    private By deliveryFormAdressNameField = By.name("addressName");
    private By deliveryFormFirstNameField = By.name("firstName");
    private By deliveryFormLastNameField = By.name("lastName");
    private By deliveryFormStreetField = By.name("streetOrRoad");
    private By deliveryFormBuildingNoField = By.name("buildingNo");
    private By deliveryFormFloorField = By.name("floor");
    private By deliveryFormApartmentNoField = By.name("apartmentNo");
    private By deliveryTime = By.xpath("//button[.//span[contains(text(),'Arası')]]");
    private By selectPaymentMethodCreditCard = By.xpath("//div[.//span[text()='Kredi Kartı ya da Banka Kartı']]//a");
    private By fillCardInfoNameField = By.name("cardHolderName");
    private By fillCardInfoNumberField = By.name("cardNumber");
    private By fillCardInfoExpireDateField = By.name("cardExpireDate");
    private By fillCardInfoCVCField = By.name("cardCvv");
    private By acceptShoppingConditions =  By.cssSelector("button[role='checkbox'][aria-checked='false']");
    private By completePaymentButton = By.xpath("//button[normalize-space(text())='Alışverişi Tamamla']");


    public void clickRandomNewProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newProductLinks)).click();

        List<WebElement> newProducts = driver.findElements(newProductLinks);

        if (newProducts.isEmpty()) {
            throw new RuntimeException("Product not found!");
        }

        Random random = new Random();
        WebElement randomProduct = newProducts.get(random.nextInt(newProducts.size()));
        randomProduct.click();
    }

    public void clickAddToBasket() {
        wait.until(ExpectedConditions.elementToBeClickable(addToBasketButton)).click();
    }

    public void fillTheDeliveryAdress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(provinceDropDown)).click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(provinceOptions));

        if (options.isEmpty()) {
            throw new RuntimeException("Province not found!");
        }

        Random random = new Random();
        WebElement randomOption = options.get(random.nextInt(options.size()));
        randomOption.click();

        WebElement districtDropDown = driver.findElement(By.id(":rl:-form-item"));
        districtDropDown.click();
        String districtListId = districtDropDown.getAttribute("aria-controls");
        By ilceOptionsLocator = By.cssSelector("[id='" + districtListId + "'] button[role='option']");
        List<WebElement> discrictOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ilceOptionsLocator));
        Random randomDisct = new Random();
        WebElement randomDisctrict = discrictOptions.get(random.nextInt(discrictOptions.size()));
        randomDisctrict.click();

        WebElement neighbourhoodDropdownButton = driver.findElement(By.id(":rn:-form-item"));
        neighbourhoodDropdownButton.click();
        String neighborhoodListId = neighbourhoodDropdownButton.getAttribute("aria-controls");
        By neighborhoodOptionsLocator = By.cssSelector("[id='" + neighborhoodListId + "'] button[role='option']");
        List<WebElement> mahalleOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(neighborhoodOptionsLocator));
        Random randomItem = new Random();
        WebElement randomNeighborhood = mahalleOptions.get(random.nextInt(mahalleOptions.size()));
        randomNeighborhood.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(OkButton)).click();
    }

    public void goToCheckoutPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(goToCheckOutButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueWithoutSignUpButton)).click();
        String getCurrentUrl = driver.getCurrentUrl();
        Assert.assertTrue(getCurrentUrl.contains("odeme"));
    }

    public void fillMailAndPhoneNumberFields(String email, String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(guestMailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(guestPhoneNumberField)).sendKeys(phoneNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(goToCheckOutButton)).click();
    }

    public void fillDeliveryAddressForm(String addressName, String firstName, String lastName, String streetOrRoad, String buildingNo, String floor, String apartmentNo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryFormAdressNameField)).sendKeys(addressName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryFormFirstNameField)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryFormLastNameField)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryFormStreetField)).sendKeys(streetOrRoad);
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryFormBuildingNoField)).sendKeys(buildingNo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryFormFloorField)).sendKeys(floor);
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryFormApartmentNoField)).sendKeys(apartmentNo);

        wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryTime)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(goToCheckOutButton)).click();
    }

    public void makePayment(String cardName, String cardNumber, String expiryDate, String CVC) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectPaymentMethodCreditCard)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillCardInfoNameField)).sendKeys(cardName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillCardInfoNumberField)).sendKeys(cardNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillCardInfoExpireDateField)).sendKeys(expiryDate);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillCardInfoCVCField)).sendKeys(CVC);

        wait.until(ExpectedConditions.elementToBeClickable(acceptShoppingConditions)).click();
        wait.until(ExpectedConditions.elementToBeClickable(completePaymentButton)).click();


    }

}