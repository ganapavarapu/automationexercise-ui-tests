package automationexercise.core;

import automationexercise.pages.HomePage;
import automationexercise.pages.LoginPage;
import automationexercise.utils.ConfigReader;

public final class AuthenticationManager {

    private AuthenticationManager() {
    }

    public static void login() {

        String username =
                ConfigReader.getProperty("username");

        String password =
                ConfigReader.getProperty("password");

        if (username == null || username.isBlank()) {
            throw new IllegalStateException(
                    "Username is not configured."
            );
        }

        if (password == null || password.isBlank()) {
            throw new IllegalStateException(
                    "Password is not configured."
            );
        }

        LoginPage loginPage =
                new LoginPage(DriverManager.getDriver());

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();

        HomePage homePage =
                new HomePage(DriverManager.getDriver());

        if (!homePage.isUserLoggedIn()) {
            throw new IllegalStateException(
                    "Login failed. User is not authenticated."
            );
        }
    }
}