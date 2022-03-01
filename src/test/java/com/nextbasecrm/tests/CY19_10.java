package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CY19_10 {
    WebDriver driver;

    @BeforeMethod
    public void openSesame() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
    }
    @Test
    public void TaskTabTest() {

        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement taskTabButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        taskTabButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement frame = driver.findElement(By.xpath("(//iframe[@class=\"bx-editor-iframe\"])[2]"));
        driver.switchTo().frame(frame);

        WebElement enterBodyMessage = driver.findElement(By.xpath("//body[@style='min-height: 84px;']"));
        enterBodyMessage.click();
        enterBodyMessage.sendKeys("Entering body message");

        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement sendButton = driver.findElement(By.xpath("//button[@id=\"blog-submit-button-save\"]"));
        sendButton.click();

        WebElement popupError = driver.findElement(By.xpath("//div[@class='task-message-label error']"));
        Assert.assertTrue(popupError.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

