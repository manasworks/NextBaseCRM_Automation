package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_6 extends TestBase {

    //Locators

    String clickMoreTabLocator ="//span[.='More' and @id='feed-add-post-form-link-text']";
    String fileTabLocator = "//span[@class = 'menu-popup-item-text' and .='File']";
    String applicationTabLocator = "//span[@class = 'menu-popup-item-text' and .='Appreciation']";
    String announcementTabLocator = "//span[@class = 'menu-popup-item-text' and .='Announcement']";
    String workflowTabLocator = "//span[@class = 'menu-popup-item-text' and .='Workflow']";

    //Expected text for profile

    String expectedFileTab = "File";
    String expectedAppreciationTabText = "Appreciation";
    String expectedAnnouncementTabText = "Announcement";
    String expectedWorkflowText = "Workflow";


    @Test(dataProvider = "userTypes")
    public void ProfileTab_TestTest(String usernames) {

        // Login function from CRM_Utilities
        CRM_Utilities.crm_login(driver, usernames);

        //   WebDriverWait wait = new WebDriverWait(driver, 20);
        String message = "Test CY19: " + driver;

        //User story CY19-6

        WebElement clickMoreTab = driver.findElement(By.xpath(clickMoreTabLocator));
        clickMoreTab.click();

        // 1. File

        WebElement fileTab = driver.findElement(By.xpath(fileTabLocator));
        String actualFileTab = fileTab.getText();
        Assert.assertEquals(actualFileTab, expectedFileTab);

        // 2. Appreciation

        WebElement applicationTab = driver.findElement(By.xpath(applicationTabLocator));
        String actualAppreciationTabText = applicationTab.getText();
         Assert.assertEquals(actualAppreciationTabText, expectedAppreciationTabText);

        // 3. Announcement
        WebElement announcementTab = driver.findElement(By.xpath(announcementTabLocator));
        String actualAnnouncementTabText = announcementTab.getText();
        Assert.assertEquals(actualAnnouncementTabText, expectedAnnouncementTabText);

        // 4. Workflow
        WebElement workflowTab = driver.findElement(By.xpath(workflowTabLocator));
        String actualWorkflowText = workflowTab.getText();
        Assert.assertEquals(actualWorkflowText, expectedWorkflowText);

    }
}