package com.saucedemo.pom.pages;

import com.saucedemo.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By itemName = By.className("inventory_item_name");
    private final By itemQty = By.className("cart_quantity");
    private final By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public String getItemQuantity() {
        return driver.findElement(itemQty).getText();
    }

    public CheckoutPage checkout() {
        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
}
