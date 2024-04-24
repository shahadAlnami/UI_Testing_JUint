package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class CookieTests extends Tests {
    /**
     * Breakout task: 15 minutes
     * Navigate to <a href="https://kitchen.applitools.com/ingredients/cookie">Cookies</a>
     * print the total number of cookies
     * add a new "fruit=apple" cookie
     * edit the "protein" cookie to have the value "meat"
     * delete the "vegetable" cookie
     * print all cookies
     * delete all cookies
     */

    @Test
    public void cookies(){
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

        //print the cookies with their total number
        var cookies = driver.manage().getCookies();
        System.out.println("Total number of cookies is : "+cookies.size());
        System.out.println("Cookies are :");
        cookies.forEach(System.out::println);

        //add a new "fruit=apple" cookie
        driver.manage().addCookie(new Cookie("Furies","apple"));

        //edit the "protein" cookie to have the value "meat" ( if you want to edit the cookies just add a new one with the same name )
        driver.manage().addCookie(new Cookie("protein","meat"));

        // delete the "vegetable" cookie
        driver.manage().deleteCookieNamed("vegetable");

        //print all cookies
        cookies = driver.manage().getCookies();
        System.out.println("Updated Cookies are :");
        cookies.forEach(System.out::println);

        //delete all cookies
        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0,driver.manage().getCookies().size());

    }

}
