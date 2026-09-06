package com.vikram.qa.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By loginOrSignUpButton =
            By.xpath("//a[@href='/login']");

    private final By logoutButton =
            By.xpath("//a[@href='/logout']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginOrSignUpButton(){
        click(loginOrSignUpButton);
    }

    public boolean isUserLoggedIn() {
        return isDisplayed(logoutButton);
    }


}