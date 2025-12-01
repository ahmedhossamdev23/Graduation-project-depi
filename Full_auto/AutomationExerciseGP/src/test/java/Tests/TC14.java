package Tests;

import BaseTest.BaseTest;
import Pages.ProductsPage;
import Pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends BaseTest {

    @Test
    public void VerifyCartQuantity() {
        ProductsPage productsPage = new ProductsPage(driver);

        // 1. Add first product to cart
        productsPage.AddFirstProductToCart();
        productsPage.ClickContinueShopping(); // Close popup

        // 2. Open cart
        CartPage cartPage = productsPage.OpenCart();

        // 3. Verify initial quantity is 1
        int initialQty = cartPage.GetFirstItemQuantity();
        Assert.assertEquals(initialQty, 1, "Initial quantity is not 1!");

        // 4. Update quantity to 3
        cartPage.SetFirstItemQuantity(3);

        // 5. Verify quantity updated
        int updatedQty = cartPage.GetFirstItemQuantity();
        Assert.assertEquals(updatedQty, 3, "Quantity did not update correctly!");
    }
}
