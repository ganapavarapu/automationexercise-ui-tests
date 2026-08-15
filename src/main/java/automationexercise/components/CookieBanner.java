package automationexercise.components;

import automationexercise.core.DriverManager;
import automationexercise.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookieBanner extends BasePage {

    private final By consentButton =
            By.xpath("//button[@aria-label='Consent']");

    public CookieBanner(WebDriver driver) {
        super(driver);
    }


    public void acceptIfPresent() {
        if (isDisplayedIfPresent(consentButton)) {
            click(consentButton);
        }
    }

}
