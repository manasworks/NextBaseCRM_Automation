package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    private static final String browser = ConfigurationReader.getProperty("browser");
    private static final String env = ConfigurationReader.getProperty("env");

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Go to CRM Page
        driver.get(env);
        // Login function from CRM_Utilities
        CRM_Utilities.crm_login(driver);
    }

    @AfterMethod
    public void tearDown() {
        // Log out from CRM
        CRM_Utilities.crm_logout(driver);
        driver.close();
    }
}
