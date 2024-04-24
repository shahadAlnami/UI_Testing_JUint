package junit.practise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task5 {
    /**
     * //Task 1:
     * Go to URL: https://demoqa.com/radio-button
     * Verify whether all 3 options given to the question can be selected.
     * When each option is selected, print the following texts on the console.
     *
     *  //Task 2:
     *      * breakout task: (in a separate class)
     *      * navigate to this url https://www.saucedemo.com/v1/inventory.html
     *      * add the first item you find to your cart
     *      * open your cart*
     *      * assert that the item name is correct inside the cart
     */

    WebDriver driver;

    @Test
    public void testRadioButtonSelection() {
        // Select and verify each option
        selectAndVerifyOption("yesRadio");
        selectAndVerifyOption("impressiveRadio");
        WebElement option3 = driver.findElement(By.xpath("//input[@id='noRadio']"));
        boolean option3Selectable = option3.isEnabled();
        System.out.println("Option 3 selectable: " + option3Selectable);
    }

    private void selectAndVerifyOption(String optionId) {
        WebElement option = driver.findElement(By.xpath("//label[@for='" + optionId + "']"));
        option.click();
        boolean optionSelectable = option.isEnabled();
        WebElement optionText = driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println("Option selectable: " + optionSelectable);
        System.out.println(optionText.getText());
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
    }

    @AfterEach
    public void afterEach(){ driver.quit();}
}
