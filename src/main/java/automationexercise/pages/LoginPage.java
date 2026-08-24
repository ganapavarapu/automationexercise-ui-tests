package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField =
            By.xpath("//input[@data-qa='login-email']");

    private final By passwordField =
            By.xpath("//input[@data-qa='login-password']");

    private final By loginButton =
            By.xpath("//button[@data-qa='login-button']");

    /**
     * Constructor to pass the WebDriver instance to the parent Page class.
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to enter username
     * @param username
     */
    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    /**
     * Method to enter password
     * @param password
     */
    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    /**
     * Method to click Login Button
     * @return HomePage instance after clicking the login button
     */
    public HomePage clickLoginBtn() {
        click(loginButton);
        return new HomePage(driver);
    }
}