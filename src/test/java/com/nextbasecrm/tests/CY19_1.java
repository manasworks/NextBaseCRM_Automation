package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
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

public class CY19_1 {
    public static WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }

    @Test
    public void crmLoginPositiveTestWithLoginBtn() {


        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("username"));


        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));

        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));


        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));

        loginButton.click();

    }

    @Test
    public void loginWithValidCredentialsWithEnterBtn() {

        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);


    }


    @Test
    public void crm_verifyTitle() {


        String expectedTitleAfterLogin = "Authorization";
        String actualTitle = driver.getTitle();


        Assert.assertEquals(actualTitle, expectedTitleAfterLogin);


    }

    @Test
    public void RememberMeButton_Displayed(){

        WebElement rememberMeButton = driver.findElement(By.xpath("//input[@id='USER_REMEMBER']"));

        Assert.assertTrue(rememberMeButton.isDisplayed());

    }

    @Test
    public static void crmLoginWith_ValidUserName_InvalidPassword() {


        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("username"));


        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));

        inputPassword.sendKeys("aaa12365");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));

        loginButton.click();

        //  5 verify error message
        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }

    @Test

    public void LoginWithValidUserNameEmptyPassword() {

        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName.sendKeys(ConfigurationReader.getProperty("username"));


        WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys("  ");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        BrowserUtils.sleep(3);
        loginBtn.click();


        //  5 verify error message
        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);


    }

    @Test
    public void login_with_valid_username_blank_password() {

        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys("");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        BrowserUtils.sleep(3);
        loginBtn.click();

        //  5 verify error message
        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }

    @Test

    public void crmLoginWith_InvalidUserName_CorrectPassword() {

        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("SultanShahinian");


        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));

        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));

        loginButton.click();

        //  5 verify error message
        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }

    @Test

    public void crmLoginWith_InvalidUserName_InvalidPassword() {

        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("SultanShahinian");


        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));

        inputPassword.sendKeys("aa123654789");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));

        loginButton.click();

        //  5 verify error message
        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }
}



