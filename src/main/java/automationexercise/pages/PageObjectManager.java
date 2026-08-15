package automationexercise.pages;

import automationexercise.components.CookieBanner;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver driver;

    private LoginPage loginPage;
    private CookieBanner cookieBanner;
    private HomePage homePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {

        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }

        return loginPage;
    }

    public CookieBanner getCookieBannerObject(){
        if(cookieBanner == null){
            cookieBanner = new CookieBanner(driver);
        }
        return cookieBanner;
    }

    public HomePage getHomePage() {

        if (homePage == null) {
            homePage = new HomePage(driver);
        }

        return homePage;
    }

}