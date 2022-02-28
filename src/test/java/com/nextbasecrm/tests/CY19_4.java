package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_4 extends TestBase{

//Locators
String clickProfileTabLocator = "//span[@class='user-name']";
String myProfileLocator = "//span[.='My Profile']";
String editProfileSettingTextLocator = "//span[.='Edit Profile Settings']";
String themesTextLocator = "//span[.='Themes' and @class='menu-popup-item-text']";
String configureNotificationsTextLocator = "//span[.='Configure notifications' and @class = 'menu-popup-item-text']";
String logoutTextLocator = "//span[.='Log out']";


//Expected text for profile
String expectedMyProfileText = "My Profile";
String expectedEditProfileSettingsText = "Edit Profile Settings";
String expectedThemesText = "Themes";
String expectedConfigureNotificationsText = "Configure notifications";
String expectedLogoutText = "Log out";

@Test(dataProvider = "userTypes")
public void MessageTab_SendText_Test(String usernames) {

    // Login function from CRM_Utilities
    CRM_Utilities.crm_login(driver, usernames);

 //   WebDriverWait wait = new WebDriverWait(driver, 20);
    String message = "Test CY19: "+driver;

    //User story CY19-5

    WebElement clickProfileTab = driver.findElement(By.xpath(clickProfileTabLocator));
    clickProfileTab.click();

    // 1. My Profile
    WebElement myProfile = driver.findElement(By.xpath(myProfileLocator));
    String actualMyProfileText = myProfile.getText();
    Assert.assertEquals(actualMyProfileText, expectedMyProfileText);

    // 2. Edit Profile Settings
    WebElement editProfileSettingText = driver.findElement(By.xpath(editProfileSettingTextLocator));
    String actualEditProfileSettingText = editProfileSettingText.getText();
    Assert.assertEquals(actualEditProfileSettingText, expectedEditProfileSettingsText);

    System.out.println(editProfileSettingText.getText());

    // 3. Themes
    WebElement themesText = driver.findElement(By.xpath(themesTextLocator));
    String actualThemesText = themesText.getText();
    Assert.assertEquals(actualThemesText, expectedThemesText);

    // 4. Configure notifications
    WebElement configureNotificationsText = driver.findElement(By.xpath(configureNotificationsTextLocator));
    String actualConfigureNotificationsText = configureNotificationsText.getText();
    Assert.assertEquals(actualConfigureNotificationsText, expectedConfigureNotificationsText);

    // 5. Log out  ---> in paperwork log out was written without space "logout"; Expected image had space, assume typo, need to double check
    WebElement logoutText = driver.findElement(By.xpath(logoutTextLocator));
    String actualLogoutText = logoutText.getText();
    Assert.assertEquals(actualLogoutText, expectedLogoutText);

}
}