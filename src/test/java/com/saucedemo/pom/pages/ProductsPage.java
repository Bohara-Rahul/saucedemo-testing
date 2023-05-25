package com.saucedemo.pom.pages;

import com.saucedemo.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    private final By pageTitle = By.className("title");
    private final By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartLink = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
       return driver.findElement(pageTitle).getText();
    }

    public ProductsPage addToCart() {
       driver.findElement(addToCartBtn).click();
       return this;
    }

    public String getAddToCartText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack"))).getText();
    }
    public String getRemoveText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remove-sauce-labs-backpack"))).getText();
    }

    public ProductsPage removeFromCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remove-sauce-labs-backpack"))).click();
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
