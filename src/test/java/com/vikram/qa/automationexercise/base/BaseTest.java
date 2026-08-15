package automationexercise.base;

import automationexercise.annotations.SkipLogin;
import automationexercise.core.AuthenticationManager;
import automationexercise.core.DriverFactory;
import automationexercise.core.DriverManager;
import automationexercise.pages.PageObjectManager;
import automationexercise.utils.ConfigReader;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class BaseTest {

    protected PageObjectManager pages;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {

        String browser =
                ConfigReader.getProperty("browser");

        boolean headless =
                Boolean.parseBoolean(
                        ConfigReader.getProperty("headless")
                );

        DriverFactory.createDriver(browser, headless);

        DriverManager.getDriver().get(
                ConfigReader.getProperty("baseUrl")
        );

        pages = new PageObjectManager(DriverManager.getDriver());

        boolean skipLogin =
                method.isAnnotationPresent(SkipLogin.class)
                        || method.getDeclaringClass()
                        .isAnnotationPresent(SkipLogin.class);

        if (!skipLogin) {
            AuthenticationManager.login();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}