package Pages;
import Pages.ContactUsPage;
import Pages.AccountCreation.AccountInfoPage;
import Pages.AccountCreation.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By HomeBtnLocator=By.linkText("Home");

    String ExpectedColor="rgb(255, 165, 0)";
    By loginLink = By.cssSelector("a[href='/login']");


public HomePage (WebDriver driver){
        this.driver=driver;

    }
    public String GetActualColor (){
        return driver.findElement(HomeBtnLocator).getCssValue("color");
    }
    public String GetExpectedlColor () {
        return  ExpectedColor;
    }
    public LoginPage Clickonlogin(){
        driver.findElement(loginLink).click();
        return  new LoginPage (driver);

    }

    By contactUsBtn = By.linkText("Contact us");

    public ContactUsPage ClickOnContactUs(){
        driver.findElement(contactUsBtn).click();
        return new ContactUsPage(driver);
    }

    By TestCasesBtn = By.linkText("Test Cases");

    public TestCasePage ClickOnTestCases() {
        driver.findElement(TestCasesBtn).click();
        return new TestCasePage(driver);
    }

    By ProductsBtn = By.xpath("//a[@href='/products']");

    public ProductsPage ClickOnProducts() {
        driver.findElement(ProductsBtn).click();
        return new ProductsPage(driver);
    }



}
