package junit.practise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    /**
     * breakout task:
     * <br/> - navigate to this url <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
     * <br/> - do a successful login
     * <br/> - assert that the login is successful
     */

/**
 * breakout task:
 * <br/> - navigate to this url <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
 * <br/> - do a locked_out_user login
 * <br/> - assert that the login was not successful (do a negative test, and a positive test)
 */


// the way i did it


    WebDriver driver ;

    @Test
    public void testSuccessfulLogin(){
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.submit();

        String url = driver.getCurrentUrl();
        String successful = "https://www.saucedemo.com/v1/inventory.html";
        Assertions.assertEquals(successful,url);

    }

    @Test
    public void testUnsuccessfulLogin(){
        // do a locked_out_user login ( positive )
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        WebElement userName2 = driver.findElement(By.id("user-name"));
        userName2.sendKeys("locked_out_user");

        WebElement password2 = driver.findElement(By.id("password"));
        password2.sendKeys("secret_sauce");

        WebElement login2 = driver.findElement(By.id("login-button"));
        login2.submit();

        // ( positive )
        String error = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        String errorMessege = "Epic sadface: Sorry, this user has been locked out.";
        Assertions.assertEquals(errorMessege,error);

        // ( negative )
        String url2 = driver.getCurrentUrl();
        String Unsuccessful = "https://www.saucedemo.com/v1/inventory.html";
        Assertions.assertNotEquals(Unsuccessful,url2);
    }


    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

}
