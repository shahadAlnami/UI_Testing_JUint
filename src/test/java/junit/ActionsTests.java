package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsTests extends Tests {
    /**
     * Breakout task: 20 minutes
     * navigate to https://www.selenium.dev/selenium/web/droppableItems.html
     * drag the draggable, onto the droppable
     * check that the text now shows "Dropped!"
     */

    @Test
    public void dropDownTest(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/droppableItems.html");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver).dragAndDrop(draggable, droppable).perform();
        String text = droppable.getText();
        Assertions.assertEquals("Dropped!",text);
    }

    /**
     * Breakout task: 20 minutes
     * navigate to: https://rangeslider.js.org/
     * scroll to the right until you reach 700
     * assert that the number says 700
     */

    @Test
    public void sliderTest(){
        //this code will work depending into the screen reselotions
        driver.navigate().to("https://rangeslider.js.org/");
        WebElement rangeSlider = driver.findElement(By.id("js-rangeslider-0"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(rangeSlider)
                .moveByOffset(100, 0)
                .perform();
        WebElement numberElement = driver.findElement(By.id("js-output"));
        String displayedNumber = numberElement.getText();
        Assertions.assertEquals("700",displayedNumber);

        // this will work on any screen
    }


//    @Test
//    public void javascriptExecutorTest() throws IOException {
//        driver.navigate().to("https://www.selenium.dev/");
////        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000);");
//
//        By browserStackImage = By.xpath("//img[@alt='BrowserStack']");
//
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
////        new Actions(driver).scrollToElement(driver.findElement(browserStackImage)).perform();
////        driver.findElement(browserStackImage).click();
//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(browserStackImage));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(browserStackImage));
//
//        File ElementScreenshot = driver.findElement(browserStackImage).getScreenshotAs(OutputType.FILE);
//
//        Files.copy(screenshot, new File("target/screenshot_"+System.currentTimeMillis()+".png"));
//        Files.copy(ElementScreenshot, new File("target/ElementScreenshot_"+System.currentTimeMillis()+".png"));
//
//    }
}
