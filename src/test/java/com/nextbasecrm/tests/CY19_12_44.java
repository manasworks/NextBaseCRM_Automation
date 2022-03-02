package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CY19_12_44 {
    //TEST CASE CY19_12_44
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //creating before method to log in to the NextBaseCRM application
        //setting up driver
        driver = WebDriverFactory.getDriver("chrome");

        //maximizing the window
        driver.manage().window().maximize();

        //setting up implicit selenium wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //redirecting to the NextBaseCRM application log in page
        driver.get("https://login2.nextbasecrm.com/");

    }

    @Test
    public void announcement_tab(){
        WebElement logInInput = driver.findElement(By.xpath("//input[@name= 'USER_LOGIN']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name= 'USER_PASSWORD']"));
        //logging in with credentials :
        //username : marketing55@cydeo.com
        //password: UserUser
        logInInput.sendKeys("marketing55@cydeo.com" );
        passwordInput.sendKeys("UserUser");
        WebElement logInButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        logInButton.click();


        //verifying "More" button from "task" module
        WebElement moreButton = driver.findElement(By.xpath("//div/span[@id='feed-add-post-form-link-more']"));

        //clicking "more" button
        moreButton.click();

        //locating "Announcement" button
        WebElement announcementButton = driver.findElement(By.xpath("//div/span[.='Announcement']"));

        //clicking announcement button
        announcementButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //locating the text field by locating as web element and pass in frame() method
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'bx-editor-iframe']")));

        //locate the field for typing
        WebElement textBox = driver.findElement(By.xpath("//body"));

        //typing a test data in a text box
        textBox.sendKeys("Test 1" );

        //switching back to parent frame
        driver.switchTo().parentFrame();

        //locating a "send" button
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));

        //clicking the send button
        sendButton.click();













    }
}
