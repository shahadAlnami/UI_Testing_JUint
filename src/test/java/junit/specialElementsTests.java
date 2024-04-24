package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class specialElementsTests {

    WebDriver driver;

    @Test
    public void checkBoxPositiveTest(){
        By checkbox = By.id("my-check-2");
        driver.findElement(checkbox).click();
        boolean isChecked = driver.findElement(checkbox).isSelected();
        Assertions.assertTrue(isChecked);
    }

    @Test
    public void checkBoxNegativeTest(){
        By checkbox = By.id("my-check-2");
        driver.findElement(checkbox).click();
        driver.findElement(checkbox).click();
        boolean isChecked = driver.findElement(checkbox).isSelected();
        Assertions.assertFalse(isChecked);
    }

    @Test
    public void radioButton(){
        By radioButton = By.id("my-radio-2");
        driver.findElement(radioButton).click();
        boolean isChecked = driver.findElement(radioButton).isSelected();
        Assertions.assertTrue(isChecked);
    }

    @Test
    public void selectFromDropDownMenuTest(){
        By selectElement = By.name("my-select");
        Select select = new Select(driver.findElement(selectElement));
        select.selectByValue("2");
        String actualText = select.getAllSelectedOptions().getFirst().getText();
        Assertions.assertEquals("Two",actualText);
    }

    @Test
    public void registerNewUserTest(){
        // generate unique email

        //TODO: Why this not working ???

        var email =  "email_"+ System.currentTimeMillis() + "@gmail.com";
        var email2 = "email_"+ System.currentTimeMillis() + "@gmail.com";
        var email3 = "email_"+ System.currentTimeMillis() + "@gmail.com";

        Assertions.assertNotEquals(email,email3);
    }


    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}

