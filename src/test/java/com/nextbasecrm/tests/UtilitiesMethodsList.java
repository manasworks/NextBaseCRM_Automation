package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UtilitiesMethodsList {
    WebDriver driver;
    // List of Strings from Configurator
    private static final String browser = ConfigurationReader.getProperty("browser");
    private static final String env = ConfigurationReader.getProperty("env");

    /*
    **************************************************************************************
    If you add any utilities' method please give an example bellow with short description.
    **************************************************************************************
    *  If you don't want to create Before and After methods and Login you can extend
    *  TestBase Class  *
     */

    @Test
    public void testMethodsList() {
        // WebDriverFactory:
        // 1-Opens browser specified in Configuration
        driver = WebDriverFactory.getDriver(browser);
        // 2-Go to page specified in Configuration
        driver.get(env);


        // CRM Utilities
        // 1-Login with credentials specified in Configuration
        CRM_Utilities.crm_login(driver);
        // 2-Login with credentials manually specified
        //CRM_Utilities.crm_login(driver, "Username", "Password");
        // 3-Logout from CRM
        CRM_Utilities.crm_logout(driver);


        // BrowserUtils
        // 1-Sleep method
        BrowserUtils.sleep(2);
        // 2-Verify Title method
        BrowserUtils.verifyTitle(driver, "Authorization");
    }
}
