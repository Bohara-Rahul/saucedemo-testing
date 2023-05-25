package com.saucedemo.pom.tests;

import com.saucedemo.pom.base.BaseTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.saucedemo.pom.objects.User;
import com.saucedemo.pom.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {
    User validUser = new User("standard_user", "secret_sauce");
    User lockedOutUser = new User("locked_out_user", "secret_sauce");

    @Test
    public void verifyCanLogin() {
        String pageTitle = new LoginPage(driver)
                .login(validUser.getUsername(), validUser.getPassword())
                .navigateToProductsPage()
                .getPageTitle();

        assertEquals("Products", pageTitle);
    }

    @Test
    public void verifyLoginError() {
        String errorMessage = new LoginPage(driver).clickLoginButton().getErrorMessage();
        assertEquals("Epic sadface: Username is required", errorMessage);
    }

    @Test
    public void verifyLockedOutUser() {
        String errorMessage = new LoginPage(driver)
                .login(lockedOutUser.getUsername(), lockedOutUser.getPassword())
                .getErrorMessage();
        assertEquals("Epic sadface: Sorry, this user has been locked out.", errorMessage);
    }
}
