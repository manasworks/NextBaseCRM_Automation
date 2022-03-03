package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class CY19_14 {


    public static WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        // open a Chrome browser
        driver = WebDriverFactory.getDriver("chrome");

        // maximize window
        driver.manage().window().maximize();

        // provide extra time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://login2.nextbasecrm.com/");

    }
    @Test
    public void desktopClient(){
        CRM_Utilities.crm_login(driver,"hr57@cydeo.com", "UserUser");
        System.out.println();

        WebElement windowsButton = driver.findElement(By.xpath("//span[.='Windows']"));
        Assert.assertTrue(windowsButton.isDisplayed());

        WebElement macosButton = driver.findElement(By.xpath("//span[.='Mac OS']"));
        Assert.assertTrue(macosButton.isDisplayed());

        WebElement linuxButton = driver.findElement(By.xpath("//span[.='Linux']"));
        Assert.assertTrue(linuxButton.isDisplayed());



    }

    @AfterMethod
    public void tearDown() {
        driver.close();

    }
}
