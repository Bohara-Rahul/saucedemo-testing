package com.saucedemo.pom.tests;

import com.saucedemo.pom.base.BaseTest;
import com.saucedemo.pom.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTests extends BaseTest {

    @Test
    public void verifyPageTitle() {
        String pageTitle = new LoginPage(driver)
                .login()
                .navigateToProductsPage()
                .addToCart()
                .navigateToCartPage()
                .checkout()
                .getPageTitle();
        assertEquals("Checkout: Your Information", pageTitle);
    }

    @Test
    public void verifyCheckoutInformationRequired() {
        String errorMessage = new LoginPage(driver)
                .login()
                .navigateToProductsPage()
                .addToCart()
                .navigateToCartPage()
                .checkout()
                .clickContinueBtn()
                .getErrorMessage();
        assertEquals("Error: First Name is required", errorMessage);
    }

    @Test
    public void verifyPaymentInformation() {
        String paymentInformation = new LoginPage(driver)
                .login()
                .navigateToProductsPage()
                .addToCart()
                .navigateToCartPage()
                .checkout()
                .enterFirstName()
                .enterLastName()
                .enterPostalCode()
                .clickContinueBtn()
                .getPaymentInformation();
        assertEquals("SauceCard #31337", paymentInformation);
    }

    @Test
    public void verifyShippingInformation() {
        String shippingInformation = new LoginPage(driver)
                .login()
                .navigateToProductsPage()
                .addToCart()
                .navigateToCartPage()
                .checkout()
                .enterFirstName()
                .enterLastName()
                .enterPostalCode()
                .clickContinueBtn()
                .getShippingInformation();
        assertEquals("Free Pony Express Delivery!", shippingInformation);
    }

    @Test
    public void verifyTotalPrice() {
        String totalPrice = new LoginPage(driver)
                .login()
                .navigateToProductsPage()
                .addToCart()
                .navigateToCartPage()
                .checkout()
                .enterFirstName()
                .enterLastName()
                .enterPostalCode()
                .clickContinueBtn()
                .getTotalPrice();
        assertEquals("32.39", totalPrice);
    }

}
