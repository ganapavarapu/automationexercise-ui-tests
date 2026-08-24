package automationexercise.core;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static WebDriver getDriver() {

        WebDriver currentDriver = driver.get();

        if (currentDriver == null) {
            throw new IllegalStateException(
                    "WebDriver is not initialized. Call createDriver() first."
            );
        }

        return currentDriver;
    }

    public static void quitDriver() {

        WebDriver currentDriver = driver.get();

        if (currentDriver != null) {
            currentDriver.quit();
            driver.remove();
        }
    }
}