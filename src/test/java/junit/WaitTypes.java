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

public class WaitTypes {

    WebDriver driver;
    Wait<WebDriver> wait;

    @Test
    public void googleSearchTests() throws InterruptedException {
        By searchTexfield = By.id("APjFqb");
        driver.findElement(searchTexfield).sendKeys("selenium"+ Keys.RETURN);
        By numberOfResult = By.id("result-stats");
        // INSERT SYNC POINT HERE

    // 1. Not recommended ways ( sleep ) NEVER USE THIS
            //Thread.sleep(5000);

    // 2. Not recommended ways ( implicit wait ) NEVER USE THIS
           //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    // 1. recommended way - Always use this - ( Explicit wait) :
        wait.until(d -> !driver.findElement(numberOfResult).getText().isEmpty());

    // 2. recommended way - Only use this for complex test - ( wait )
//        Wait<WebDriver> wait =
//                new FluentWait<>(driver)
//                        .withTimeout(Duration.ofSeconds(2))
//                        .pollingEvery(Duration.ofMillis(300))
//                        .ignoring(NoSuchElementException.class);

        String actualResultTest = driver.findElement(numberOfResult).getText();
        Assertions.assertNotEquals("",actualResultTest);
    }

    @BeforeEach
    public void beforeEach() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized"); // This is only work wth chrome
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.google.com/");
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    @AfterEach
    public void afterEch(){
        driver.quit();
    }
}
