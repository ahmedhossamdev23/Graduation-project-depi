package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    WebDriver driver;

    By ProductName = By.className("product-information");
    By Category = By.xpath("//p[contains(text(),'Category')]");
    By Price = By.xpath("//span[contains(text(),'Rs.')]");
    By Availability = By.xpath("//b[contains(text(),'Availability')]");
    By Condition = By.xpath("//b[contains(text(),'Condition')]");
    By Brand = By.xpath("//b[contains(text(),'Brand')]");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean IsProductDetailsVisible() {
        return driver.findElement(ProductName).isDisplayed()
                && driver.findElement(Category).isDisplayed()
                && driver.findElement(Price).isDisplayed()
                && driver.findElement(Availability).isDisplayed()
                && driver.findElement(Condition).isDisplayed()
                && driver.findElement(Brand).isDisplayed();
    }
}
