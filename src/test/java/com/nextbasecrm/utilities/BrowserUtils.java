package com.nextbasecrm.utilities;
/*
In this class only general utility methods that are not related to some specific page.
 */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserUtils {

    /*
    This method will accept int (in seconds) and execute Thread.sleep
    for given duration
     */
    public static void sleep(double second){
        int sec = (int) (second *1000);
        try {
            Thread.sleep(sec);
        }catch (InterruptedException e ) {

        }
    }

    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(WebDriver driver ,String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    //This method accepts a String "expectedTitle" and Asserts if it contains in actual title
    public static void verifyTitleContains(WebDriver driver ,String expectedTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }
}