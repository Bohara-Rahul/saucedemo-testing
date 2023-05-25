package com.saucedemo.pom.pages;

import com.saucedemo.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckoutPage extends BasePage {
    private final By pageTitle = By.className("title");

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By checkoutInfoValues = By.className("summary_value_label");
    private final By itemQty = By.className("cart_quantity");
    private final By itemName = By.className("inventory_item_name");
    private final By totalPrice = By.cssSelector(".summary_info_label.summary_total_label");

    private String shippingInformation;
    private String paymentInformation;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public CheckoutPage enterFirstName() {
        driver.findElement(firstName).sendKeys("test");
        return this;
    }

    public CheckoutPage enterLastName() {
        driver.findElement(lastName).sendKeys("test");
        return this;
    }

    public CheckoutPage enterPostalCode() {
        driver.findElement(postalCode).sendKeys("24315");
        return this;
    }

    public CheckoutPage clickContinueBtn() {
        driver.findElement(continueBtn).click();
        return this;
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public String getItemQuantity() {
        return driver.findElement(itemQty).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText().replace("Total: $", "");
    }

    private List<WebElement> getCheckoutInformation() {
        return driver.findElements(checkoutInfoValues);
    }

    public String getPaymentInformation() {
        List<WebElement> elements = getCheckoutInformation();
        return elements.get(0).getText();
    }

    public String getShippingInformation() {
        List<WebElement> elements = getCheckoutInformation();
        return elements.get(1).getText();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.tagName("h3"))
        ).getText();
    }

}
