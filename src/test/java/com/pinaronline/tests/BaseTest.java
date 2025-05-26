package com.pinaronline.tests;

import com.pinaronline.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://testrio.pinaronline.com");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
