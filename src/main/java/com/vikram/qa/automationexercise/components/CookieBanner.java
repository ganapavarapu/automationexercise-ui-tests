package com.vikram.qa.automationexercise.components;

import com.vikram.qa.automationexercise.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookieBanner extends BasePage {

    private final By consentButton =
            By.xpath("//button[@aria-label='Consent']");

    /**
     * Constructor to pass the WebDriver instance to the parent Page class.
     * @param driver
     */
    public CookieBanner(WebDriver driver) {
        super(driver);
    }

    /**
     * This method is used to accept cookies if present
     */
    public void acceptIfPresent() {
        if (isDisplayedIfPresent(consentButton)) {
            click(consentButton);
        }
    }

}
