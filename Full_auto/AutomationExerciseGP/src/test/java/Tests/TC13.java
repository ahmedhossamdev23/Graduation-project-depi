package Tests;

import BaseTest.BaseTest;
import Pages.ProductsPage;
import Pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13 extends BaseTest {

    @Test
    public void VerifyRemoveItemFromCart() {
        ProductsPage productsPage = new ProductsPage(driver);

        // 1. Add first product to cart
        productsPage.AddFirstProductToCart();
        productsPage.ClickContinueShopping(); // Close popup

        // 2. Open cart
        CartPage cartPage = productsPage.OpenCart();

        // 3. Remove the item
        cartPage.RemoveFirstItem();

        // 4. Verify cart is empty
        Assert.assertTrue(cartPage.IsCartEmpty(), "Cart is not empty after removing the item!");
    }
}
