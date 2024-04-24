package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsTests {
    /**
     * Navigate to <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
     * login as standard_user
     * use Selenium Relative Locators to identify the login button
     */

    WebDriver driver;
    String landingPageUrl = "https://www.saucedemo.com/v1/inventory.html";


    @Test
    public void RelativeLocatorsTest(){
        login();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(landingPageUrl,currentUrl);
    }
    public void login(){
        By usernameTextArea = By.id("user-name");
        By passwordTextArea = By.id("password");
        By loginButton = RelativeLocator.with(By.tagName("input")).below(passwordTextArea);

        driver.findElement(usernameTextArea).sendKeys("standard_user");
        driver.findElement(passwordTextArea).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
    }
    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

}
