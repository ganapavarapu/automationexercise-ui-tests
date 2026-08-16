package automationexercise.pages;

import automationexercise.core.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    protected void click(By locator) {
        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(locator));

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) DriverManager.getDriver())
                    .executeScript("arguments[0].click();", element);
        }
    }

    protected void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected boolean isDisplayed(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    protected boolean isDisplayedIfPresent(By locator) {
        List<WebElement> elements =
                DriverManager.getDriver().findElements(locator);

        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }
}
