package junit.practise;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
    @Test

    public void testMethod(){
        // we will follow the official user guide
        // https://www.selenium.dev/documentation/webdriver/getting_started/first_script/

        // 1. Start the session
        // Selenium Manager will download the driver for you, and it will also download the entire browser if you don't have it installed on your machine.
        // It will download it to a temporary directory, to be used in isolation, and only for your selenium tests.
        //WebDriver driver = new ChromeDriver();
       // WebDriver driver = new SafariDriver();
       // WebDriver driver = new FirefoxDriver();

        // 2. Take action on browser
        //you can either use driver.get or driver.navigate.to to navigate to any url
        //driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        //driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

        WebDriver driver2 = new ChromeDriver();
        //driver2.manage().window().maximize();
        driver2.manage().window().setPosition(new Point(0,0));
        driver2.manage().window().setSize(new Dimension(1920,1080));

        //Navigate to Facebook homepage URL: https://www.facebook.com/
        driver2.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        driver2.navigate().to("https://www.facebook.com/");
        driver2.navigate().back();
        driver2.navigate().forward();

        //3. Request browser information
        String title = driver2.getTitle();
        System.out.println("Title: " + title);

        String currentUrl = driver2.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        driver2.close();
        driver2.quit();
    }
}
