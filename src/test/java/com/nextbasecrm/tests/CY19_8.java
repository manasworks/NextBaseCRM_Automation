package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CY19_8 extends TestBase {


    @Test(dataProvider = "userTypes")

    public void locateTabs(String usernames) {

        // Login function from CRM_Utilities
        CRM_Utilities.crm_login(driver, usernames);


        // users click "Chat and Calls" module on the left side of homepage

        //span[contains(text(),'Chat and Calls')]
        WebElement chatAndCalls = driver.findElement(By.xpath("//span[normalize-space(text())='Chat and Calls']"));
        chatAndCalls.isDisplayed();

        chatAndCalls.click();

        //Verify that users can see 4 tab icons in the chat and calls window Message(s), Notifications, Settings, Active Stream

        WebElement messageIcon = driver.findElement(By.xpath("//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-im']"));
        messageIcon.isDisplayed();
        WebElement notificationsIcon = driver.findElement(By.xpath("//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-notify']"));
        notificationsIcon.isDisplayed();
        WebElement settingsIcon = driver.findElement(By.xpath("//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-config']"));
        settingsIcon.isDisplayed();
        WebElement activityStreamIcon = driver.findElement(By.xpath("//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-im-lf']"));
        activityStreamIcon.isDisplayed();





    }


}