package com.saucedemo.pom.pages;

import com.saucedemo.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.className("error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    public LoginPage login() {
        driver.findElement(username).sendKeys("standard_user");
        driver.findElement(password).sendKeys("secret_sauce");
        clickLoginButton();
        return this;
    }

    public ProductsPage navigateToProductsPage() {
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

}
