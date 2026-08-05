package com.vikram.qa.automationexercise.tests;

import automationexercise.core.DriverManager;
import com.vikram.qa.automationexercise.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyGoogleTitle() {

        DriverManager.getDriver().get("https://google.com");

        String title = DriverManager.getDriver().getTitle();

        Assert.assertEquals(title,"Google");

    }

}
