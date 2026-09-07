package com.vikram.qa.automationexercise.core;

import com.vikram.qa.automationexercise.pages.PageObjectManager;

public final class AuthenticationManager {

    private AuthenticationManager() {
    }

    public static void login(PageObjectManager pages, String username, String password) {

        if (username == null || username.isBlank()) {
            throw new IllegalStateException("Username must not be null or blank.");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalStateException("Password must not be null or blank.");
        }
        pages.homePage().clickLoginOrSignUpButton();
        pages.loginPage().enterLoginUsername(username);
        pages.loginPage().enterLoginPassword(password);
        pages.loginPage().clickLoginBtn();

        if (!pages.homePage().isUserLoggedIn()) {
            throw new IllegalStateException("Login failed. User is not authenticated.");
        }
    }
}