package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_5 extends TestBase{

    //Locators list for Message Tab Functionality Test
    String activityBtnLocator = "//a[@title='Activity Stream']";
    String messageTabLocator = "//span[@id='feed-add-post-form-tab-message']//span";
    String iFrameLocator = "//iframe[@class='bx-editor-iframe']";
    String bodyLocator = "//body";
    String sendBtnLocator = "//button[@id='blog-submit-button-save']";
    String textBlockLocator = "//div[@class='feed-item-wrap']//div[@class='feed-post-text-block-inner-inner']";
    String errorTextLocator = "//span[@class='feed-add-info-text']";

    @Test(dataProvider = "userTypes")
    public void MessageTab_SendText_Test(String usernames) {

        // Login function from CRM_Utilities
        CRM_Utilities.crm_login(driver, usernames);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        String message = "Test CY19: "+driver;

        //1-Step: Go to HomePage
        WebElement activityStreamButton = driver.findElement(By.xpath(activityBtnLocator));
        wait.until(ExpectedConditions.visibilityOf(activityStreamButton));
        activityStreamButton.click();


        //2-Step: Click "Message" Tab
        WebElement messageTab = driver.findElement(By.xpath(messageTabLocator));
        wait.until(ExpectedConditions.visibilityOf(messageTab));
        messageTab.click();

        //3-Step: Click on Body to enter a text
        WebElement iframe = driver.findElement(By.xpath(iFrameLocator));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        WebElement messageBody = driver.findElement(By.xpath(bodyLocator));
        wait.until(ExpectedConditions.visibilityOf(messageBody));
        messageBody.click();

        //4-Step: Enter a text
        messageBody.sendKeys(message);

        //5-Step: Click "SEND" button
        driver.switchTo().parentFrame();
        WebElement sendButton = driver.findElement(By.xpath(sendBtnLocator));
        wait.until(ExpectedConditions.visibilityOf(sendButton));
        sendButton.click();

        //6-Step: Verify text appeared in the "Activity Stream" feed
        BrowserUtils.sleep(1);
        WebElement textBlock = driver.findElement(By.xpath(textBlockLocator));
        wait.until(ExpectedConditions.visibilityOf(textBlock));
        String actualResult = textBlock.getText();
        Assert.assertEquals(actualResult, message);
    }

    @Test(dataProvider = "userTypes")
    public void MessageTab_Send_Empty_Test(String usernames) {

        // Login function from CRM_Utilities
        CRM_Utilities.crm_login(driver, usernames);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        // Message to send in Message Tab
        String message = "";

        //1-Step: Go to HomePage
        WebElement activityStreamButton = driver.findElement(By.xpath(activityBtnLocator));
        wait.until(ExpectedConditions.visibilityOf(activityStreamButton));
        activityStreamButton.click();


        //2-Step: Click "Message" Tab
        WebElement messageTab = driver.findElement(By.xpath(messageTabLocator));
        wait.until(ExpectedConditions.visibilityOf(messageTab));
        messageTab.click();

        //3-Step: Click on Body to enter a text
        WebElement iframe = driver.findElement(By.xpath(iFrameLocator));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        WebElement messageBody = driver.findElement(By.xpath(bodyLocator));
        wait.until(ExpectedConditions.visibilityOf(messageBody));
        messageBody.click();

        //4-Step: Enter a text
        messageBody.sendKeys(message);

        //5-Step: Click "SEND" button
        driver.switchTo().parentFrame();
        WebElement sendButton = driver.findElement(By.xpath(sendBtnLocator));
        wait.until(ExpectedConditions.visibilityOf(sendButton));
        sendButton.click();

        //6-Step: Verify text appeared in the "Activity Stream" feed
        BrowserUtils.sleep(1);
        WebElement textBlock = driver.findElement(By.xpath(errorTextLocator));
        wait.until(ExpectedConditions.visibilityOf(textBlock));
        String actualResult = textBlock.getText();
        Assert.assertEquals(actualResult, "The message title is not specified");
    }

    @Test(dataProvider = "userTypes")
    public void MessageTab_Send_Spaces_Test(String usernames) {

        // Login function from CRM_Utilities
        CRM_Utilities.crm_login(driver, usernames);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        // Message to send in Message Tab
        String message = "         ";

        //1-Step: Go to HomePage
        WebElement activityStreamButton = driver.findElement(By.xpath(activityBtnLocator));
        wait.until(ExpectedConditions.visibilityOf(activityStreamButton));
        activityStreamButton.click();


        //2-Step: Click "Message" Tab
        WebElement messageTab = driver.findElement(By.xpath(messageTabLocator));
        wait.until(ExpectedConditions.visibilityOf(messageTab));
        messageTab.click();

        //3-Step: Click on Body to enter a text
        WebElement iframe = driver.findElement(By.xpath(iFrameLocator));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        WebElement messageBody = driver.findElement(By.xpath(bodyLocator));
        wait.until(ExpectedConditions.visibilityOf(messageBody));
        messageBody.click();

        //4-Step: Enter a text
        messageBody.sendKeys(message);

        //5-Step: Click "SEND" button
        driver.switchTo().parentFrame();
        WebElement sendButton = driver.findElement(By.xpath(sendBtnLocator));
        wait.until(ExpectedConditions.visibilityOf(sendButton));
        sendButton.click();

        //6-Step: Verify text appeared in the "Activity Stream" feed
        BrowserUtils.sleep(1);
        WebElement textBlock = driver.findElement(By.xpath(errorTextLocator));
        wait.until(ExpectedConditions.visibilityOf(textBlock));
        String actualResult = textBlock.getText();
        Assert.assertEquals(actualResult, "The message title is not specified");
    }
}
