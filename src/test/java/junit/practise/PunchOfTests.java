package junit.practise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PunchOfTests
{
    /**
     //First
     Navigate to https://testpages.herokuapp.com/styled/index.html
     Click on Simple Calculator under Micro Apps.
     Type any number in the first input.
     Type any number in the second input.
     Click on Calculate.
     Get the result.
     Print the result.


     //second
     Go to URL: https://www.linkedin.com/
     Locate the "Email or phone", "password", "Sign in" button using absolute xpath and relative xpath

     //third
     find the locators of webelements on page https://www.linkedin.com/
     id, name, className, linkText, PLinkText
     */

    WebDriver driver;

    //First
    @Test
    public void firstTest(){
        WebElement calculate = driver.findElement(By.id("calculatetest"));
        calculate.click();
        WebElement firstInput = driver.findElement(By.id("number1"));
        firstInput.sendKeys("4");
        WebElement secondInput = driver.findElement(By.id("number2"));
        secondInput.sendKeys("2");
        WebElement calculateButton = driver.findElement(By.id("calculate"));
        calculateButton.click();
        String resultText = driver.findElement(By.id("answer")).getText();
        System.out.println("the result is "+resultText);
    }

/**
 *      //second
        //absolute xpath
        WebElement emailOrPhone = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[1]/div[1]/div/div/input"));
        WebElement password = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[1]/div[2]/div/div/input"));
        WebElement signIn = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/button"));

        //relative xpath
        WebElement emailOrPhoneRelative = driver.findElement(By.xpath("//input[@id='session_key']"));
        WebElement passwordRelative = driver.findElement(By.xpath("//input[@id='session_password']"));
        WebElement signInButtonRelative = driver.findElement(By.xpath("//button[@type='submit']"));

**/

/**

 Using ID:
 * WebElement emailOrPhoneElement = driver.findElement(By.id("session_key"));
 * WebElement passwordElement = driver.findElement(By.id("session_password"));

  Using Name:
 * WebElement emailOrPhoneElement = driver.findElement(By.name("session_key"));
 * WebElement passwordElement = driver.findElement(By.name("session_password"));

 Using ClassName:
 * WebElement signInButtonElement = driver.findElement(By.className("btn-md btn-primary flex-shrink-0 cursor-pointer sign-in-form__submit-btn--full-width"));

 Using LinkText:
 * WebElement forgotPasswordLinkElement = driver.findElement(By.linkText("Forgot password?"));

 Using Partial LinkText:
 * WebElement joinNowLinkElement = driver.findElement(By.partialLinkText("New to LinkedIn?"));

  */

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.eviltester.com/styled/index.html");
    }

    @AfterEach
    public void afterEach(){ driver.quit();}

}
