package com.vikram.qa.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    private final By accountCreatedMessage =By.xpath("//h2[@data-qa='account-created']");

    /**
     * Constructor to initialize driver
     *
     * @param driver
     */
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountCreatedMessage(){
        return getText(accountCreatedMessage);
    }

}
