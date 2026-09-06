package com.vikram.qa.automationexercise.tests;

import com.vikram.qa.automationexercise.annotations.NoTestUser;
import com.vikram.qa.automationexercise.annotations.SkipLogin;
import com.vikram.qa.automationexercise.base.BaseTest;
import com.vikram.qa.automationexercise.models.SignUpData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void navigateToLoginPage(){
        pages().homePage().clickLoginOrSignUpButton();
        Assert.assertEquals(pages().loginPage().getLoginOrSignUpPageTitle(),"Automation Exercise - Signup / Login");
    }

    @Test @SkipLogin
    public void verifyValidLogin() {
        pages().loginPage().enterLoginUsername(testUser.get().getEmail());
        pages().loginPage().enterLoginPassword(testUser.get().getPassword());
        pages().loginPage().clickLoginBtn();
        Assert.assertTrue(pages().homePage().isUserLoggedIn(), "User login was not successful");
    }

    @Test @SkipLogin
    public void verifyInvalidLogin() {
        String invalidPassword = testUser.get().getPassword() + "wrongPassword";
        pages().loginPage().enterLoginUsername(testUser.get().getEmail());
        pages().loginPage().enterLoginPassword(invalidPassword);
        pages().loginPage().clickLoginBtn();
        Assert.assertEquals(pages().loginPage().getLoginFailureMessage(),"Your email or password is incorrect!");
    }

    @Test @NoTestUser
    public void signUpUser()  {
        SignUpData signUpData = testDataGenerator.generateValidSignUpData();
        pages().loginPage().enterSignUpUsername(signUpData.getName());
        pages().loginPage().enterSignUpEmail(signUpData.getEmail());
        pages().loginPage().clickSignUpBtn();
        Assert.assertEquals(pages().signUpPage().getSignUpPageTitle(),"Automation Exercise - Signup");
        pages().signUpPage().createAccount(signUpData);
        Assert.assertEquals(pages().accountCreatedPage().getAccountCreatedMessage(),"ACCOUNT CREATED!");
        setUserForCleanup(signUpData);
    }
}