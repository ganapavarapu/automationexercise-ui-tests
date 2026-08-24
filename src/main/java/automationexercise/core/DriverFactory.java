package automationexercise.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static void createDriver(
            String browser,
            boolean headless) {

        if (browser == null || browser.isBlank()) {
            throw new IllegalArgumentException(
                    "Browser is not configured."
            );
        }

        WebDriver webDriver;

        switch (browser.toLowerCase()) {

            case "chrome":

                ChromeOptions chromeOptions =
                        new ChromeOptions();

                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }

                webDriver =
                        new ChromeDriver(chromeOptions);

                break;

            case "edge":

                EdgeOptions edgeOptions =
                        new EdgeOptions();

                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                }

                webDriver =
                        new EdgeDriver(edgeOptions);

                break;

            case "firefox":

                FirefoxOptions firefoxOptions =
                        new FirefoxOptions();

                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }

                webDriver =
                        new FirefoxDriver(firefoxOptions);

                break;

            default:

                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }

        webDriver.manage().window().maximize();

        DriverManager.setDriver(webDriver);
    }
}