package com.saucedemo.pom.tests;

import com.saucedemo.pom.base.BaseTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.saucedemo.pom.pages.LoginPage;
import com.saucedemo.pom.pages.ProductsPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.BooleanSupplier;

public class LoginTests extends BaseTest {

    @Test
    public void login() {
        String pageTitle = new LoginPage(driver)
                .login()
                .navigateToProductsPage()
                .getPageTitle();

        assertEquals("Products", pageTitle);
    }

    @Test
    public void verifyLoginError() {
        String errorMessage = new LoginPage(driver).clickLoginButton().getErrorMessage();
        assertEquals("Epic sadface: Username is required", errorMessage);
    }
}
