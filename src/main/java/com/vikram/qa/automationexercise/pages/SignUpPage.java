package com.vikram.qa.automationexercise.pages;

import com.vikram.qa.automationexercise.models.SignUpData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    private final By passwordField = By.id("password");
    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By addressField = By.xpath("//input[@data-qa='address']");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");
    private final By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    /**
     * Constructor to pass the WebDriver instance to the parent Page class.
     *
     * @param driver
     */
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void createAccount(SignUpData signUpData) {
        enterText(passwordField, signUpData.getPassword());
        enterText(firstNameField, signUpData.getFirstName());
        enterText(lastNameField, signUpData.getLastName());
        enterText(addressField, signUpData.getAddress());
        enterText(stateField, signUpData.getState());
        enterText(cityField, signUpData.getCity());
        enterText(zipcodeField, signUpData.getZipcode());
        enterText(mobileNumberField, signUpData.getMobileNumber());
        click(createAccountBtn);
    }

    public String getSignUpPageTitle() {
        return driver.getTitle();
    }
}
