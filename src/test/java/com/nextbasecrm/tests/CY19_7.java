package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CY19_7 extends TestBase {

    @Test(dataProvider = "userTypes")
    public void crm_votingPoll_test(String usernames) {

        // Login function from CRM_Utilities
        CRM_Utilities.crm_login(driver, usernames);

        // Click to Activity Stream :
        // There is a bug when you log in, instead of seeing a homepage, user often sees an Error message.
        // To avoid it, I added extra step, to make sure that test will go through.
        WebElement activityStreamButton = driver.findElement(By.xpath("//a[@title='Activity Stream']"));
        activityStreamButton.click();

        BrowserUtils.sleep(3);

        //Confirm User is on the homepage
        Assert.assertTrue(driver.getTitle().contains("Portal"));

        // Find a poll through the filter:
        //I created my own poll with unique name, this way I don't need to create a poll each time
        String pollID = "programming123";
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='LIVEFEED_search']"));
        searchBar.sendKeys(pollID);
        searchBar.sendKeys(Keys.ENTER);

        BrowserUtils.sleep(3);

        //If Vote Again Button is displayed, click the button to refresh the poll.
        WebElement voteAgainBtn = driver.findElement(By.xpath("//button[@data-bx-vote-button='showVoteForm']"));

        if (voteAgainBtn.isDisplayed()) {
            BrowserUtils.sleep(3);
            voteAgainBtn.click();
        }
        BrowserUtils.sleep(2);

        // Selecting Python option
        WebElement radioButton2 = driver.findElement(By.xpath("//input[@id='vote_radio_1130_2542']/.."));
        radioButton2.click();

        BrowserUtils.sleep(2);

        //Selecting Java option
        WebElement radioButton1 = driver.findElement(By.xpath("//input[@id='vote_radio_1130_2543']/.."));
        radioButton1.click();

        BrowserUtils.sleep(2);

        //Clicking Vote Button
        WebElement voteButton = driver.findElement(By.xpath("//button[@data-bx-vote-button='actVoting']"));
        voteButton.click();

        //Verify result: expected to see "VoteAgain" Button
        BrowserUtils.sleep(3);
        Assert.assertTrue(voteAgainBtn.isDisplayed());
        System.out.println(voteAgainBtn.getText());

    }

}
