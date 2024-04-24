package junit.practise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddTheFirstElementToTheCart {

    WebDriver driver;
/**
     Test Isolation -> every test runs on its own without depending on other tests (to prevent domino effect)
     beforeeach/aftereach rather than beforeall/afterall
     tests should begin with a navigation action
     a test should include exactly one assertion point
     a test should end with that assertion point
 */

    @Test
    public void addTheFirstElement () {
        //never use class = in xpath
        // never use the text with xpath (the website may have several languages )

        WebElement addToCartButton = driver.findElement(By.xpath("(//button[contains(@class,'btn_inventory')])[1]"));
        addToCartButton.click();

        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']"));
        cart.click();

        String ActualitemInTheCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assertions.assertEquals("Sauce Labs Backpack",ActualitemInTheCart);
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/inventory.html");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

}
