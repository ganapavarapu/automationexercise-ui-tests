package automationexercise.components;

import automationexercise.core.DriverManager;
import automationexercise.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
