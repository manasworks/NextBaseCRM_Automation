package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    private static final String browser = ConfigurationReader.getProperty("browser");
    private static final String env = ConfigurationReader.getProperty("env");

    private static final String username1 = ConfigurationReader.getProperty("username1");
    private static final String username2 = ConfigurationReader.getProperty("username2");
    private static final String username3 = ConfigurationReader.getProperty("username3");
    private static final String username4 = ConfigurationReader.getProperty("username1");
    private static final String username5 = ConfigurationReader.getProperty("username2");
    private static final String username6 = ConfigurationReader.getProperty("username3");
    private static final String username7 = ConfigurationReader.getProperty("username1");
    private static final String username8 = ConfigurationReader.getProperty("username2");
    private static final String username9 = ConfigurationReader.getProperty("username3");

    @DataProvider(name="userTypes")
    public Object[][] userGroups(){
        return new Object[][]{
                {username1},
                {username2},
                {username3},
        };
    }

    @DataProvider(name="allUsers")
    public Object[][] allUsers(){
        return new Object[][]{
                {username1},
                {username2},
                {username3},
                {username4},
                {username5},
                {username6},
                {username7},
                {username8},
                {username9},
        };
    }

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Go to CRM Page
        driver.get(env);
    }

    @AfterMethod
    public void tearDown() {
        // Log out from CRM
        CRM_Utilities.crm_logout(driver);
        driver.close();
    }
}
