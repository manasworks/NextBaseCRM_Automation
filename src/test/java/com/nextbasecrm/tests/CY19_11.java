package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CY19_11 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Go to CRM Page
        driver.get("https://login1.nextbasecrm.com");


    }

    //  The "My Profile" option should be displayed when the user clicks the user profile from the homepage.

    @Test
    public void MyProfile() {

        CRM_Utilities.crm_login(driver,"hr55@cydeo.com","UserUser");
        System.out.println();
        WebElement userblock = driver.findElement(By.xpath("//div[@ id='user-block']"));
        userblock.click();

        WebElement myprofile = driver.findElement(By.xpath("//span[.='My Profile']"));
        myprofile.click();

        System.out.println();

        WebElement generaltab = driver.findElement(By.xpath("//div[@id='profile-menu-filter']//a[1]"));
        Assert.assertTrue(generaltab.isDisplayed());

        WebElement drive = driver.findElement(By.xpath("//div[@id='profile-menu-filter']//a[2]"));
        Assert.assertTrue(drive.isDisplayed());

        WebElement task = drive.findElement(By.xpath("//div[@id='profile-menu-filter']//a[3]"));
        Assert.assertTrue(drive.isDisplayed());

        WebElement calendar = drive.findElement(By.xpath("//div[@id='profile-menu-filter']//a[4]"));
        Assert.assertTrue(drive.isDisplayed());

        WebElement conversations = drive.findElement(By.xpath("//div[@id='profile-menu-filter']//a[5]"));
        Assert.assertTrue(drive.isDisplayed());


    }


    // 2. There should be five tabs on my profile page:

    //These include: "General" "Drive" "Tasks" "Calendar" Conversations"
}
