package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SynchronizationTests {

    /**
     * Use Google Chrome
     * Navigate to <a href="https://www.google.com/">Google.com</a>
     * Search for "Selenium"
     * Check that results stats is not empty
     * Change to using Firefox
     */

    /**
     *
     *  Thread.sleep(5000);///It is a java thing not selenium ( DO NOT USE THIS ) : because even if thr element ready it will also wait for the seconds you specified
     *  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // this will wit until he able to find the element but don't wait for the element result or text ( DO NOT USE THIS ) because this will break your test
     *
     */

    WebDriver driver;
    Wait<WebDriver> wait;

    @Test
    public void googleSearchTests() throws InterruptedException {
        By searchTexfield = By.id("APjFqb");
        driver.findElement(searchTexfield).sendKeys("selenium"+ Keys.RETURN);

        // INSERT SYNC POINT HERE

        //recommended way ( Explicit )
        By numberOfResult = By.id("result-stats");
        wait.until(d -> !driver.findElement(numberOfResult).getText().isEmpty()); // this wait tell the driver to wait for ( something )- lambda expression will wait until the method executed and return the result )
        String actualResultTest = driver.findElement(numberOfResult).getText();
        Assertions.assertNotEquals("",actualResultTest);
    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized"); // This is only work wth chrome
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.google.com/");
        wait = new WebDriverWait(driver,Duration.ofSeconds(5)); // till the browser to wait ( but wait for what ? )


        // Todo : check this with different Wifi
//        driver = new FirefoxDriver();
//        driver.get("https://www.google.com/");

    }

    @AfterEach
    public void afterEch(){
        driver.quit();
    }
}
