package com.saucedemo.pom.tests;

import com.saucedemo.pom.base.BaseTest;
import com.saucedemo.pom.objects.Product;
import com.saucedemo.pom.objects.User;
import com.saucedemo.pom.pages.LoginPage;
import com.saucedemo.pom.pages.ProductsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTests extends BaseTest {
    User user = new User("standard_user", "secret_sauce");
    Product product = new Product("Sauce Labs Bike Light");

    @Test
    public void addToCart() {
        ProductsPage productsPage = new LoginPage(driver)
                .login(user.getUsername(), user.getPassword())
                .navigateToProductsPage()
                .addToCart(product.getProductName());
        String removeText = productsPage.getRemoveText(product.getProductName());
        String cartAmount = productsPage.getCartAmount();

        assertEquals("Remove", removeText);
        assertEquals("1", cartAmount);
    }

    @Test
    public void removeFromCart() {
        ProductsPage productsPage = new LoginPage(driver)
                .login(user.getUsername(), user.getPassword())
                .navigateToProductsPage()
                .addToCart(product.getProductName())
                .removeFromCart(product.getProductName());
        String addToCartText = productsPage.getAddToCartText(product.getProductName());
//        String cartAmount = productsPage.getCartAmount();

        assertEquals("Add to cart", addToCartText);
//        assertEquals(null, cartAmount);
    }

    @Test
    public void getItemName() {
        String itemName = new LoginPage(driver)
                .login(user.getUsername(), user.getPassword())
                .navigateToProductsPage()
                .addToCart(product.getProductName())
                .navigateToCartPage()
                .getItemName();

        assertEquals(product.getProductName(), itemName);
    }

    @Test
    public void getItemQty() {
        String itemQty = new LoginPage(driver)
                .login(user.getUsername(), user.getPassword())
                .navigateToProductsPage()
                .addToCart(product.getProductName())
                .navigateToCartPage()
                .getItemQuantity();

        assertEquals("1", itemQty);
    }
}
