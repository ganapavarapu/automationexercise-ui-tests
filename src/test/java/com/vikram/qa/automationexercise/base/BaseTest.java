package com.vikram.qa.automationexercise.base;

import com.vikram.qa.automationexercise.annotations.NoTestUser;
import com.vikram.qa.automationexercise.annotations.SkipLogin;
import com.vikram.qa.automationexercise.core.AuthenticationManager;
import com.vikram.qa.automationexercise.core.DriverFactory;
import com.vikram.qa.automationexercise.core.DriverManager;
import com.vikram.qa.automationexercise.models.SignUpData;
import com.vikram.qa.automationexercise.pages.PageObjectManager;
import com.vikram.qa.automationexercise.utils.ConfigReader;

import com.vikram.qa.automationexercise.api.UserApiClient;
import com.vikram.qa.automationexercise.api.model.CreateUserRequest;
import com.vikram.qa.automationexercise.testdata.TestDataGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class BaseTest {

    protected final ThreadLocal<PageObjectManager> pages = new ThreadLocal<>();
    protected final ThreadLocal<CreateUserRequest> testUser = new ThreadLocal<>();
    protected final ThreadLocal<String> userEmail = new ThreadLocal<>();
    protected final ThreadLocal<String> userPassword = new ThreadLocal<>();
    protected final TestDataGenerator testDataGenerator = new TestDataGenerator();
    private final UserApiClient userApiClient = new UserApiClient();

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {

        String browser =
                ConfigReader.getProperty("browser");

        boolean headless =
                Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        boolean noTestUser =
                method.isAnnotationPresent(NoTestUser.class)
                        || method.getDeclaringClass()
                        .isAnnotationPresent(NoTestUser.class);

        boolean skipLogin =
                method.isAnnotationPresent(SkipLogin.class)
                        || method.getDeclaringClass()
                        .isAnnotationPresent(SkipLogin.class);

        if (!noTestUser) {
            testUser.set(testDataGenerator.generateUser());
            userApiClient.createUser(testUser.get());
            userEmail.set(testUser.get().getEmail());
            userPassword.set(testUser.get().getPassword());
        }

        DriverFactory.createDriver(browser, headless);
        DriverManager.getDriver().get(ConfigReader.getProperty("baseUrl"));
        pages.set(new PageObjectManager(DriverManager.getDriver()));
        pages().cookieBanner().acceptIfPresent();

        if (!skipLogin && !noTestUser) {
            AuthenticationManager.login(pages(),testUser.get().getEmail(),
                    testUser.get().getPassword());
        }
    }

    protected void setUserForCleanup(SignUpData signUpData) {

        userEmail.set(signUpData.getEmail());
        userPassword.set(signUpData.getPassword());
    }

    protected PageObjectManager pages() {
        return pages.get();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            if (userEmail.get() != null && userPassword.get() != null) {
                userApiClient.deleteUser(userEmail.get(), userPassword.get());
            }
        } finally {
            pages.remove();
            testUser.remove();
            userEmail.remove();
            userPassword.remove();

            DriverManager.quitDriver();
        }
    }
}