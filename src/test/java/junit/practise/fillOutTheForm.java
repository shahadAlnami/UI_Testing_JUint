package junit.practise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fillOutTheForm {


   // navigate to this url, asset the header value, and fill the form. (30 minutes)  https://www.selenium.dev/selenium/web/web-form.html


    @Test
    public void fillOutTheForm() throws InterruptedException {
        WebDriver driver = new ChromeDriver() ;
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String headerTitle = driver.findElement(By.tagName("h1")).getText();
        Assertions.assertEquals("Web form",headerTitle);

        WebElement textInput = driver.findElement(By.id("my-text-id"));
        textInput.click();
        textInput.sendKeys("Shahad Alnami");

        WebElement password = driver.findElement(By.name("my-password"));
        password.click();
        password.sendKeys("QA123456789");

        WebElement textarea = driver.findElement(By.name("my-textarea"));
        textarea.click();
        textarea.sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. ");

        WebElement disabledInput = driver.findElement(By.name("my-disabled"));
        System.out.println(disabledInput.isEnabled());

        WebElement readOnlyInput = driver.findElement(By.cssSelector("input[value='Readonly input']"));
        readOnlyInput.click();

        WebElement dropdownInput = driver.findElement(By.name("my-select"));
        dropdownInput.click();
        WebElement dropdownChoois = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select/option[4]"));
        dropdownChoois.click();

        //Dropdown (datalist)

        WebElement uploadFile = driver.findElement(By.name("my-file"));
        uploadFile.sendKeys("/Users/shahadalshareef/IdeaProjects/testProject/src/test/java/testPackage/image.png");

        WebElement checkbox = driver.findElement(By.id("my-check-1"));
        WebElement checkbox2 = driver.findElement(By.id("my-check-2"));
        checkbox.click();
        checkbox2.click();

        WebElement radioButton2 = driver.findElement(By.id("my-radio-2"));
        radioButton2.click();

        WebElement date = driver.findElement(By.name("my-date"));
        date.sendKeys("30/03/2023");
        date.sendKeys(Keys.RETURN); // to press enter

        WebElement linkTest = driver.findElement(By.linkText("Return to index"));
        linkTest.click();
        driver.navigate().back();
        //div[@class='inventory_item_name']

//        WebElement colorPicker = driver.findElement(By.className("form-control form-control-color"));
//        colorPicker.sendKeys("255", "255", "255");


        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-outline-primary mt-3']"));
        submitButton.submit();

        driver.quit();

    }


}
