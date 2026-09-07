package com.vikram.qa.automationexercise.pages;

import com.vikram.qa.automationexercise.components.CookieBanner;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver driver;

    private LoginPage loginPage;
    private CookieBanner cookieBanner;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private AccountCreatedPage accountCreatedPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public CookieBanner cookieBanner(){
        if(cookieBanner == null){
            cookieBanner = new CookieBanner(driver);
        }
        return cookieBanner;
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public SignUpPage signUpPage() {
        if (signUpPage == null) {
            signUpPage = new SignUpPage(driver);
        }
        return signUpPage;
    }

    public AccountCreatedPage accountCreatedPage() {
        if (accountCreatedPage == null) {
            accountCreatedPage = new AccountCreatedPage(driver);
        }
        return accountCreatedPage;
    }

}