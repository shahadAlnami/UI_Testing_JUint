package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestPerfect {

/**
 *  (in a separate class)
 *  * breakout task:
 *  * <br/> - navigate to this url <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
 *  * <br/> - do a successful login
 *  * <br/> - assert that the login is successful
 *  * breakout task:
 *  * <br/> - navigate to this url <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
 *  * <br/> - do a locked_out_user login
 *  * <br/> - assert that the login was not successful (do a negative test, and a positive test)
 *  */

   // *** it is better to have all the test data in one place in case of any change we could change it easily ***

   WebDriver driver;
   String loginPageUr = "https://www.saucedemo.com/v1/index.html";
   String landingPageUrl = "https://www.saucedemo.com/v1/inventory.html";
   String standardUser = "standard_user";
   String lockedOutUser = "locked_out_user";
   String unifiedPassword = "secret_sauce";
   String errorMessage = "Epic sadface: Sorry, this user has been locked out.";


   @Test
    public void successfulLogin(){
       login(standardUser, unifiedPassword);
       String currentUrl = driver.getCurrentUrl();
       Assertions.assertEquals(landingPageUrl,currentUrl);
   }

    @Test
    public void lockedOutErrorMessage(){ // This the positive test
        By errorMessageLabel = By.xpath("//h3[@data-test='error']");
        login(lockedOutUser,unifiedPassword);
        String errorMessageText = driver.findElement(errorMessageLabel).getText();
        Assertions.assertEquals(errorMessage,errorMessageText);
    }

    @Test
    public void lockedOutNotRedirectedToLandingPage(){ // This is the negative test
        login(lockedOutUser,unifiedPassword);
        String currentUrl = driver.getCurrentUrl();
        // NotEquals because i want to make sure that the user did not redirect to the homepage
        Assertions.assertNotEquals(landingPageUrl,currentUrl);
    }

    private void login(String username, String password){
        By usernameTextArea = By.id("user-name");
        By passwordTextArea = By.id("password");
        By loginButton = By.id("login-button");

        driver.findElement(usernameTextArea).sendKeys(username);
        driver.findElement(passwordTextArea).sendKeys(password);
        driver.findElement(loginButton).click();
    }


    @BeforeEach
    public void beforeEach(){
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get(loginPageUr);

    }

    @AfterEach
    public void afterEach(){
       driver.quit();
    }
}
