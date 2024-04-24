package junit.practise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tsk1 {

    //second assignment part01

    @Test
    public void test (){
////// Invoke Chrome Browser
//       WebDriver driver = new ChromeDriver();
////
////// Navigate to URL: https://www.w3schools.com/
//       driver.navigate().to("https://www.w3schools.com/");
////
////// Navigate to URL: https://stackoverflow.com/
//       driver.navigate().to("https://stackoverflow.com/");
////
////// Come back to the w3schools using the back command.
//        driver.navigate().back();
////
////// Again go back to the stackoverflow website using forward command
//        driver.navigate().forward();
////
////// Refresh the Browser using refresh command.
//       driver.navigate().refresh();
////
////// Close the Browser.
////        driver.quit();


        //second assignment part02

// Expected Title
        String expectedTitle = "W3Schools Online Web Tutorials";

// Set Path of the Chrome driver
       System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

// Launch Chrome browser
        WebDriver driver = new ChromeDriver();

// Open URL of Website
        driver.get("https://www.w3schools.com");

// Maximize Window
        driver.manage().window().maximize();

// Get Title of current Page
        String currentTitle = driver.getTitle();

// Validate/Compare Page Title
        Assertions.assertEquals(expectedTitle,currentTitle);

// Close Browser
        driver.quit();

    }
}
