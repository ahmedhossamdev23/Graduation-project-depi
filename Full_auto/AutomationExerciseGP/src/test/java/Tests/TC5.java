package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC5 extends BaseTest {

    @Test
    public void AlreadyRegisteredEmailSignup() {
        Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page is not visible");
        loginPage = homePage.Clickonlogin();
        Assert.assertEquals(loginPage.getActualSignUpMsg(), loginPage.getExpectedSignUpMsg(), "'New User Signup!' message is incorrect");
        loginPage.AddNameAndEmail("Manual User", "manual_user@gmail.com"); // already registered email

        accountInfoPage = loginPage.ClickonSignUp();
        String expectedError = "Email Address already exist!";
        String actualError = accountInfoPage.GetActualEmailExistErrorMsg(); // <-- you need this method in AccountInfoPage
        Assert.assertTrue(actualError.contains(expectedError), "Error message is incorrect. Expected to contain: " + expectedError);

    }
}
