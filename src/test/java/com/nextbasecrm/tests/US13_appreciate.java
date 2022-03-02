package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US13_appreciate {
    public WebDriver driver;

    //Setup browser and go to home page --->>> login
    @BeforeMethod
    public void setupBrowser() {
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
        WebElement clickUserName = driver.findElement(By.xpath("//input[@class='login-inp' and @name= 'USER_LOGIN' ]"));
        clickUserName.sendKeys("helpdesk56@cydeo.com");
        WebElement clickPassword = driver.findElement(By.xpath("//input[@class='login-inp' and @name= 'USER_PASSWORD' ]"));
        clickPassword.sendKeys("UserUser");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }


    @Test
    public void clickMoreButton() throws InterruptedException {
        //  "more" button is located It is a html dropdown(non-select)
        WebElement moreButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-more']"));
        // click to "more" button to see options
        moreButton.click();
        // appreciation is located from the more menu
        WebElement appreciation = driver.findElement(By.xpath("//span[.='Appreciation' and @class=\"menu-popup-item-text\"]"));
        // click the "appreciation" to go message part
        appreciation.click();


        // "send" button is located
        WebElement sendButton = driver.findElement(By.xpath("//button[@id=\"blog-submit-button-save\"]"));
        // click the "send" button to try to send empty message
        sendButton.click();
        // after clicking the send button error message is located
        WebElement errorMessage = driver.findElement(By.xpath("//*[.='The message title is not specified']"));
        //actual error message
        String actualResult = errorMessage.getText();
         // expected result
        String expectedResult = "The message title is not specified";
      // if expected and actual result are different, we will get warning
        Assert.assertEquals(actualResult, expectedResult, "that means something went wrong");

    }

    @Test
    public void test2() {

        //  "more" button is located It is a html dropdown(non-select)
        WebElement moreButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-more']"));
        // click to "more" button to see options
        moreButton.click();
        // appreciation is located from the more menu
        WebElement appreciation = driver.findElement(By.xpath("//span[.='Appreciation' and @class=\"menu-popup-item-text\"]"));
        // click the "appreciation" to go message part
        appreciation.click();
        // iframe is located
        WebElement iframe = driver.findElement(By.tagName("iframe"));
       //to write text in the body, driver switch to frame
        driver.switchTo().frame(iframe);
      // text part is located
        WebElement text = driver.findElement(By.xpath("//body[@contenteditable='true']"));
       // try to send text random message
        text.sendKeys("test");
      // after text driver focus on main part so switch to parentFrame
        driver.switchTo().parentFrame();
        // "send" button is located
        WebElement sendButton = driver.findElement(By.xpath("//button[@id=\"blog-submit-button-save\"]"));
       // click to send button to send the message
        sendButton.click();

    }


}
