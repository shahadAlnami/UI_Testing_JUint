package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class doubleClickElement extends Tests{

      /*
    Go to URL: https://api.jquery.com/dblclick/
    Double-click on the blue square at the bottom of the page
    Write the changed color on search box on the top of the page
    Click "jQuery in Action" at the bottom of the page.

     */

    @Test
    public void doubleClickElementCheck(){
        Actions action = new Actions(driver);
        driver.navigate().to("https://api.jquery.com/dblclick/");

        WebElement dbClickElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(dbClickElement);

        WebElement beforeClickColor = driver.findElement(By.cssSelector("body>div"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //for moving
        js.executeScript("arguments[0].scrollIntoView();",beforeClickColor);

        //for double clicking
        action.doubleClick(beforeClickColor).perform();

        //for coloring
        String color = beforeClickColor.getCssValue("background-color");
        System.out.println("color"+color);
        Assertions.assertNotEquals(beforeClickColor,color);

        // to ???
        driver.switchTo().defaultContent();

        WebElement searchBar = driver.findElement(By.name("s"));
        js.executeScript("arguments[0].scrollIntoView();",searchBar);
        //js.executeScript("window.scrollTo(0,0)"); // this will goes up
        searchBar.sendKeys(color);

        WebElement jQueryInActionImage = driver.findElement(By.xpath("//a[@href='https://www.manning.com/books/jquery-in-action-third-edition']"));
        js.executeScript("arguments[0].scrollIntoView();",jQueryInActionImage);
        jQueryInActionImage.click();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.manning.com/books/jquery-in-action-third-edition",currentUrl);
    }
}
