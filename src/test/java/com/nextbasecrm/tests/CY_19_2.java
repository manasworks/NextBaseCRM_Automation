package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CY_19_2 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void US_2() {

        //Log In Page
        driver.get("https://login2.nextbasecrm.com/");

        //Enter user username and password-- helpdesk1@cybertekschool.com  UserUser
        WebElement inputUsername = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");


        //Verify user can check the "remember me" checkbox
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"USER_REMEMBER\"]"));
        checkbox.click();
        System.out.println("Checkbox is selected = " + checkbox.isSelected());

        //  Verify there is a “Remember me on this computer” message displayed
        WebElement rememberMe = driver.findElement(By.xpath("//label[@class='login-item-checkbox-label']"));
        System.out.println("Remember Me is displayed = " + rememberMe.isDisplayed());

        String Actual_RememberMe= rememberMe.getText();
        String Expected_RememberMe="Remember me on this computer";
        Assert.assertEquals(Actual_RememberMe,Expected_RememberMe,"Actual \"remember me\" document does not match the expected one!");

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

}
