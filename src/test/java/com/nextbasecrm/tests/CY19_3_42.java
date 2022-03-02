package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CY19_3_42 {
//TEST CASE CY19-3-42
public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
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
    public void verifying_log_out_button() {
        //locating the log in and password fields
        WebElement logInInput = driver.findElement(By.xpath("//input[@name= 'USER_LOGIN']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name= 'USER_PASSWORD']"));

        //logging in with credentials :
        //username : marketing55@cydeo.com
        //password: UserUser
        logInInput.sendKeys("marketing55@cydeo.com" );
        passwordInput.sendKeys("UserUser");
        WebElement logInButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        logInButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //verifying we are on the home page after pressing the button "log in"
        //expected title of the homepage is "Portal"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Portal";
        Assert.assertEquals(actualTitle, expectedTitle);

        //from the homepage of the application locating user profile button:
        WebElement userProfileButton = driver.findElement(By.xpath("//div/span[@id='user-name']"));

        //clicking the user profile tab
        userProfileButton.click();

        //locating "log out" button
        WebElement logOutButton = driver.findElement(By.xpath("//span[.='Log out']"));

        //getting a text of the located "log out" button and verifying it's text
        //expected: "Log out"
        String actualButtonName = logOutButton.getText();
        String expectedButtonName = "Log out";
        Assert.assertEquals(actualButtonName, expectedButtonName);


    }
}
