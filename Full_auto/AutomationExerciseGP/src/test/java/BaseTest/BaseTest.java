package BaseTest;

import Pages.AccountCreation.AccountCreated;
import Pages.AccountCreation.AccountInfoPage;
import Pages.AccountCreation.LogedInPage;
import Pages.DeleteAccPage;
import Pages.HomePage;
import Pages.AccountCreation.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected AccountInfoPage accountInfoPage;
    protected AccountCreated accountCreated;
    protected LogedInPage logedInPage;
    protected DeleteAccPage deleteAccPage;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage = new HomePage(driver);
    }
    @BeforeMethod
    public void goToHomePage(){
        driver.get("https://automationexercise.com/");
//      homePage = new HomePage(driver);

    }

//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}
