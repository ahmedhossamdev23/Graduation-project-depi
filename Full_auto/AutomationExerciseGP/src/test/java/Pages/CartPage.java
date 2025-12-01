package Pages;

import Pages.AccountCreation.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;
    By CartProduct = By.className("cart_description");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean IsProductDisplayedInCart(){
        return driver.findElement(CartProduct).isDisplayed();
    }

    By ProceedToCheckoutBtn = By.xpath("//a[text()='Proceed To Checkout']");
    By RegisterLoginBtn = By.xpath("//u[text()='Register / Login']");

    By CheckoutBtn = By.xpath("//a[text()='Proceed To Checkout']");

    public CheckoutPage ClickProceedToCheckout(){
        driver.findElement(CheckoutBtn).click();
        return new CheckoutPage(driver);
    }

    public LoginPage ClickRegisterLogin() {
        driver.findElement(RegisterLoginBtn).click();
        return new LoginPage(driver);
    }

    By removeBtn = By.xpath("//a[text()='X']"); // Adjust if your site uses a different selector
    By emptyCartMsg = By.xpath("//p[contains(text(),'Your shopping cart is empty')]");

    public void RemoveFirstItem() {
        driver.findElement(removeBtn).click();
    }

    // Verify cart is empty
    public boolean IsCartEmpty() {
        return driver.findElement(emptyCartMsg).isDisplayed();
}

    By quantityField = By.xpath("//input[@type='text' and contains(@name,'quantity')]"); // Adjust if needed
    By updateBtn = By.xpath("//button[text()='Update']");

    public int GetFirstItemQuantity() {
        WebElement qty = driver.findElement(quantityField);
        return Integer.parseInt(qty.getAttribute("value"));
    }

    public void SetFirstItemQuantity(int qty) {
        WebElement qtyField = driver.findElement(quantityField);
        qtyField.clear();
        qtyField.sendKeys(String.valueOf(qty));

        driver.findElement(updateBtn).click();
    }
}
