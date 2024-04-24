package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FileUploadTest extends Tests {
    /**
     * Breakout Activity: 20 minute
     * navigate to <a href="https://the-internet.herokuapp.com/upload">Upload Test</a>
     * uploading any file from your machine (make it small please)
     * checking to see that the file was successfully uploaded
     */
    @Test
    public void uploadFile(){
        String Url = "https://the-internet.herokuapp.com/upload";
        logger.info("Navigating to: "+Url);
        driver.get(Url);


        By fileUploadFile = By.name("file");
        driver.findElement(fileUploadFile).sendKeys("/Users/shahadalshareef/Desktop/IMG_1974.PNG");

        // because the submit button is inside a form so it will not work if we use click so that wy we used submit
        driver.findElement(fileUploadFile).submit();

        By uploadSeccfly = By.tagName("h3");
        Assertions.assertEquals("File Uploaded!",driver.findElement(uploadSeccfly).getText());
    }
}
