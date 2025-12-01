package Tests;

import BaseTest.BaseTest;
import Pages.AccountCreation.LoginPage;
import Pages.ProductsPage;
import Pages.CheckoutPage;
import Pages.PaymentPage;
import Pages.ConfirmationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends BaseTest {

    @Test
    public void VerifyUserCanLoginAndPlaceOrder() {
        ProductsPage productsPage = new ProductsPage(driver);

        // 1. Add first product to cart
        productsPage.AddFirstProductToCart();
        productsPage.ClickonViewCartbtn();  // Close popup
        CheckoutPage checkoutPage = productsPage.OpenCart().ClickProceedToCheckout(); // Proceed to cart/checkout


        LoginPage loginPage = homePage.Clickonlogin();
        loginPage.SetLoginFields("manual_user@gmail.com", "manual@user2025");
        PaymentPage paymentPage = checkoutPage.ClickPlaceOrder();
        paymentPage.EnterCardDetails("4111111111111111", "12", "26","123");
        paymentPage.CompletePayment();

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        Assert.assertTrue(confirmationPage.IsOrderPlacedSuccessfully(), "Order was not placed successfully!");
    }
}
