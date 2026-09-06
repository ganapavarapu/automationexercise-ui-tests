package com.vikram.qa.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By loginUsernameField =
            By.xpath("//input[@data-qa='login-email']");

    private final By loginPasswordField =
            By.xpath("//input[@data-qa='login-password']");

    private final By loginButton =
            By.xpath("//button[@data-qa='login-button']");

    private final By loginFailure =
            By.xpath("//form[@action='/login']/p");

    private final By signUpButton =
            By.xpath("//button[@data-qa='signup-button']");

    private final By signUpUsernameField =
            By.xpath("//input[@data-qa='signup-name']");

    private final By signUpEmailField =
            By.xpath("//input[@data-qa='signup-email']");

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
    public void enterLoginUsername(String username) {
        enterText(loginUsernameField, username);
    }

    /**
     * Method to enter password
     * @param password
     */
    public void enterLoginPassword(String password) {
        enterText(loginPasswordField, password);
    }

    /**
     * Method to click Login Button
     */
    public void clickLoginBtn() {
        click(loginButton);
    }

    /**
     * Method to enter username in signup username field
     * @param username
     */
    public void enterSignUpUsername(String username){
        enterText(signUpUsernameField, username);
    }

    /**
     * Method to enter password in signup password field
     * @param password
     */
    public void enterSignUpEmail(String email){
        enterText(signUpEmailField, email);
    }

    /**
     * Method to click signUp Button
     */
    public void clickSignUpBtn(){
        click(signUpButton);
    }

    public String getLoginOrSignUpPageTitle(){
        return driver.getTitle();
    }

    /**
     * Method to get Login failure message
     * @return failure message as a String
     */
    public String getLoginFailureMessage(){
        return getText(loginFailure);
    }
}