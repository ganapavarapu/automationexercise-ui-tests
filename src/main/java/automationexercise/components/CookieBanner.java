package automationexercise.components;

import automationexercise.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookieBanner extends BasePage {

    private final By consentButton =
            By.xpath("//button[@aria-label='Consent']");

    public CookieBanner(WebDriver driver) {
        super(driver);
    }

    public void clickConsentButton(){
        click(consentButton);
    }

}
