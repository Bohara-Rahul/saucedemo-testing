package com.saucedemo.pom.pages;

import com.saucedemo.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    private final By pageTitle = By.className("title");

    private final By cartLink = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
       return driver.findElement(pageTitle).getText();
    }

    public By getAddToCartBtnElement(String productName) {
        return By.id("add-to-cart-" + productName.toLowerCase().replace(" ", "-"));
    }

    public ProductsPage addToCart(String productName) {
        By addToCartBtn = getAddToCartBtnElement(productName);
        driver.findElement(addToCartBtn).click();
        return this;
    }

    public String getAddToCartText(String productName) {
        By addToCartBtn = getAddToCartBtnElement(productName);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn)).getText();
    }

    public By getRemoveBtnElement(String productName) {
        return By.id("remove-" + productName.toLowerCase().replace(" ", "-"));
    }
    public String getRemoveText(String productName) {
        By removeFromCartBtn = getRemoveBtnElement(productName);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeFromCartBtn)).getText();
    }

    public ProductsPage removeFromCart(String productName) {
        By removeFromCartBtn = getRemoveBtnElement(productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeFromCartBtn)).click();
        return this;
    }

    public String getCartAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge"))).getText();
    }

    public CartPage navigateToCartPage() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }

}
