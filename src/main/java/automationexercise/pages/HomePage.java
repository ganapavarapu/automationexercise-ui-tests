package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By logoutButton =
            By.xpath("//a[@href='/logout']");

    private final By loginFailure =
            By.xpath("//form[@action='/login']/p");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn() {
        return isDisplayed(logoutButton);
    }

    public String getLoginFailureMessage(){
        return getText(loginFailure);
    }
}