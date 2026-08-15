package automationexercise.tests;

import automationexercise.annotations.SkipLogin;
import automationexercise.base.BaseTest;
import automationexercise.components.CookieBanner;
import automationexercise.pages.HomePage;
import automationexercise.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SkipLogin
public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private CookieBanner cookieBannerObj;
    private HomePage homePage;

    @BeforeMethod
    public void initializePages() {
        cookieBannerObj=pages.getCookieBannerObject();
        loginPage = pages.getLoginPage();
    }

    @Test
    public void verifyValidLogin() {
        cookieBannerObj.acceptIfPresent();
        loginPage.enterUsername("vikramtest@email.com");
        loginPage.enterPassword("Automation@123");
        homePage = loginPage.clickLoginBtn();
        Assert.assertTrue(homePage.isUserLoggedIn(), "User login was not successful");

    }

    @Test
    public void verifyInvalidLogin() {
        cookieBannerObj.acceptIfPresent();
        loginPage.enterUsername("wrongUser@email.com");
        loginPage.enterPassword("wrongPassword");
        homePage = loginPage.clickLoginBtn();
        Assert.assertEquals(homePage.getLoginFailureMessage(),"Your email or password is incorrect!");
    }
}