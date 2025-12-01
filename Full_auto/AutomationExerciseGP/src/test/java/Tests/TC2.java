package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2 extends BaseTest {
    @Test
    public void SuccessfulLoginScenario (){
//Before running test case 2 you must create account because at end of test case the account is deleted
        //email=awg@gmail.com
        //pass=12345678
        Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page is not visible");
        loginPage= homePage.Clickonlogin();
        Assert.assertTrue(loginPage.GetActualLoginMsg().contains(loginPage.GetExpectedLoginMsg()));
        loginPage.SetLoginFields("manual_user@gmail.com","manual@user2025");
logedInPage=loginPage.ClickonLogin();
Assert.assertEquals(logedInPage.LoggedInUserActual(),"Manual User");
        deleteAccPage=logedInPage.ClickonDeleteAcc();
        Assert.assertTrue(deleteAccPage.GetActualMsg().contains(deleteAccPage.GetExpectedMsg()));
        deleteAccPage.ClickOnContinue();


    }


}
