package com.saucedemo.pom.tests;

import com.saucedemo.pom.base.BaseTest;
import com.saucedemo.pom.objects.User;
import com.saucedemo.pom.pages.LoginPage;
import com.saucedemo.pom.pages.ProductsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTests extends BaseTest {
    User user = new User("standard_user", "secret_sauce");

    @Test
    public void addToCart() {
        ProductsPage productsPage = new LoginPage(driver)
                .login(user.getUsername(), user.getPassword())
                .navigateToProductsPage()
                .addToCart();
        String removeText = productsPage.getRemoveText();
        String cartAmount = productsPage.getCartAmount();

        assertEquals("Remove", removeText);
        assertEquals("1", cartAmount);
    }

    @Test
    public void removeFromCart() {
        ProductsPage productsPage = new LoginPage(driver)
                .login(user.getUsername(), user.getPassword())
                .navigateToProductsPage()
                .addToCart()
                .removeFromCart();
        String addToCartText = productsPage.getAddToCartText();
//        String cartAmount = productsPage.getCartAmount();

        assertEquals("Add to cart", addToCartText);
//        assertEquals(null, cartAmount);
    }

    @Test
    public void getItemName() {
        String itemName = new LoginPage(driver)
                .login(user.getUsername(), user.getPassword())
                .navigateToProductsPage()
                .addToCart()
                .navigateToCartPage()
                .getItemName();

        assertEquals("Sauce Labs Backpack", itemName);
    }

    @Test
    public void getItemQty() {
        String itemQty = new LoginPage(driver)
                .login(user.getUsername(), user.getPassword())
                .navigateToProductsPage()
                .addToCart()
                .navigateToCartPage()
                .getItemQuantity();

        assertEquals("1", itemQty);
    }
}
