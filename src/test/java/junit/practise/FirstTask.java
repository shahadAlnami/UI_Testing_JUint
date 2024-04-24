package junit.practise;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTask {

    //Create main method
    public static void main(String[] args) {
/*
        //Create chrome driver
        WebDriver driver = new ChromeDriver();

        //Open google home page: https://www.google.com
        driver.get("https://www.google.com");

        //Print Title on page
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        //Print Current URL on page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        //Close/Quit the browser
        driver.quit();

        // Differences between get() method and navigate to() method?
        // 1. The get() method is used to open a specific URL in the browser. It waits for the entire page to load before proceeding to the next step in your code. It ensures that all elements on the page are ready to be interacted with.
        // 2. the navigate().to() method also allows you to open a URL in the browser. However, it doesn't wait for the page to fully load. It's useful when you want to navigate to a new page quickly, even if some elements are still loading or if there are pending requests.
*/

          // Invoke Chrome Driver
          WebDriver driver2 = new ChromeDriver();

          //Navigate to Facebook homepage URL: https://www.facebook.com/
          driver2.navigate().to("https://www.facebook.com/");

          //Verify expected URL equals to the actual URL.
        String actualUrl = driver2.getCurrentUrl();
        Assertions.assertEquals("https://www.facebook.com/", actualUrl);

          //Verify that the page source of Facebook contains "Facebook"
           String pageSource = driver2.getPageSource();
           Assertions.assertTrue(pageSource.contains("Facebook"));


           driver2.quit();
    }
}
