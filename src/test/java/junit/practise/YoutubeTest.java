package junit.practise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YoutubeTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void beforeEach() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.youtube.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void afterEch(){
        driver.quit();}

    @Test
    public void youtubePlayInFrameTest() {
        By searchBy = By.name("search_query");
        wait.until(d -> d.findElement(searchBy).isDisplayed());

        driver.findElement(searchBy).sendKeys("java");
        driver.findElement(searchBy).submit();

        String title = getTitleVideo(1);
        clickVideo(1);
        Assertions.assertEquals("Java Full Course for free ☕", title);
    }

    private String getTitleVideo(int titleVideoNumber) {

        WebElement titleVide = driver.findElement(
                By.xpath("(//div[@id='title-wrapper' and @class='style-scope ytd-video-renderer'])[" + titleVideoNumber + "]")
        );
        return titleVide.getText();
    }

    private void clickVideo(int click) {
        WebElement titleVide = driver.findElement(
                By.xpath("(//div[@id='title-wrapper' and @class='style-scope ytd-video-renderer'])[" + click + "]//h3//a")
        );
        titleVide.click();
    }
}
