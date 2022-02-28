package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


    public class CY19_9  extends TestBase{

        //Locators list for Modules:
        String activityStream ="//a[@title='Activity Stream']";
        String tasks ="//a[@title='Tasks']";
        String chatAndCalls ="//a[@title='Chat and Calls']";
        String workgroups ="//a[@title='Workgroups']";
        String drive ="//a[@title='Drive']";
        String calendar ="//a[@title='Calendar']";
        String mail ="//a[@title='Mail']";
        String contactCenter ="//a[@title='Contact Center']";
        String timeAndReports ="//a[@title='Time and Reports']";
        String employees ="//a[@title='Employees']";
        String services ="//a[@title='Services']";
        String company ="//a[@title='Company']";

        //Expected submodule titles:
        String subActivityStream ="Portal";
        String subTasks ="Site map";
        String subChatAndCalls = "Chat and Calls";
        String subWorkgroups = "Workgroups and projects";
        String subDrive = "Site map";
        String subCalendar ="Site map";
        String subMail ="Mailbox Integration";
        String subContactCenter = "Contact Center";
        String subTimeAndReport = "Absence Chart";
        String subEmployee ="Company Structure";
        String subServices = "Meeting Rooms";
        String subCompany ="Company";


        // Testing Activity Stream Module and verifying its submodule title.
        @Test(dataProvider = "userTypes")
        public void checkModuleActivityStreamIsCorrect(String username){
            CRM_Utilities.crm_login(driver, username);

            WebElement activityStreamModule = driver.findElement(By.xpath(activityStream));
            activityStreamModule.click();
            Assert.assertTrue(driver.getTitle().contains(subActivityStream));
            // Assert.assertEquals(driver.getTitle(), subActivityStream, driver.getTitle() + " title did not match with expected " + subActivityStream + " title");
            // System.out.println("driver.getTitle() = " + driver.getTitle());
        }

         // Testing Tasks Module and verifying its submodule title.
        @Test(dataProvider = "userTypes")
        public void checkModuleTaskIsCorrect(String username){
            CRM_Utilities.crm_login(driver, username);

            WebElement tasksModule = driver.findElement(By.xpath(tasks));
            tasksModule.click();
            Assert.assertTrue(driver.getTitle().contains(subTasks));

        }

        // Testing Chat and Calls Module and verifying its submodule title.
        @Test(dataProvider = "userTypes")
        public void checkModuleChatAndCallsIsCorrect(String username){
            CRM_Utilities.crm_login(driver, username);

            WebElement chatAndCallsModule = driver.findElement(By.xpath(chatAndCalls));
            chatAndCallsModule.click();
            Assert.assertTrue(driver.getTitle().contains(subChatAndCalls));

        }

        // Testing Workgroups Module and verifying its submodule title.
        @Test(dataProvider = "userTypes")
        public void checkModuleWorkgroupsIsCorrect(String username){
            CRM_Utilities.crm_login(driver, username);

            WebElement workgroupsModule = driver.findElement(By.xpath(workgroups));
            workgroupsModule.click();
            Assert.assertTrue(driver.getTitle().contains(subWorkgroups));

        }

        // Testing Drive Module and verifying its submodule title.
        @Test(dataProvider = "userTypes")
        public void checkModuleDriveIsCorrect(String username){
            CRM_Utilities.crm_login(driver, username);

            WebElement driveModule = driver.findElement(By.xpath(drive));
            driveModule.click();
            Assert.assertTrue(driver.getTitle().contains(subDrive));

        }

        // Testing Calendar Module and verifying its submodule title.
        @Test(dataProvider = "userTypes")
        public void checkModuleCalendarIsCorrect(String username){
            CRM_Utilities.crm_login(driver, username);

            WebElement calendarModule = driver.findElement(By.xpath(calendar));
            calendarModule.click();
            Assert.assertTrue(driver.getTitle().contains(subCalendar));

        }

        // Testing Mail Module and verifying its submodule title.
        @Test(dataProvider = "userTypes")
        public void checkModuleMailIsCorrect(String username){
            CRM_Utilities.crm_login(driver, username);

            WebElement mailModule = driver.findElement(By.xpath(mail));
            mailModule.click();
            Assert.assertTrue(driver.getTitle().contains(subMail));

        }

        // Testing Contact Center Module and verifying its submodule title.
        @Test(dataProvider = "userTypes")
        public void checkModuleContactCenterIsCorrect(String username){
            CRM_Utilities.crm_login(driver, username);

            WebElement contactCenterModule = driver.findElement(By.xpath(contactCenter));
            contactCenterModule.click();
            Assert.assertTrue(driver.getTitle().contains(subContactCenter));

        }

        // Testing Time and Report Module and verifying its submodule title.
        @Test(dataProvider = "userTypes")
        public void checkModuleTimeAndReportIsCorrect(String username){
            CRM_Utilities.crm_login(driver, username);

            WebElement timeAndReportModule = driver.findElement(By.xpath(timeAndReports));
            timeAndReportModule.click();
            Assert.assertTrue(driver.getTitle().contains(subTimeAndReport));

        }

        // Testing Employees Module and verifying its submodule title.
        @Test(dataProvider = "userTypes")
        public void checkModuleEmployeesIsCorrect(String username){
            CRM_Utilities.crm_login(driver, username);

            WebElement employeesModule = driver.findElement(By.xpath(employees));
            employeesModule.click();
            Assert.assertTrue(driver.getTitle().contains(subEmployee));

        }

        // Testing Services Module and verifying its submodule title.
        @Test(dataProvider = "userTypes")
        public void checkModuleServicesIsCorrect(String username){
            CRM_Utilities.crm_login(driver, username);

            WebElement servicesModule = driver.findElement(By.xpath(services));
            servicesModule.click();
            Assert.assertTrue(driver.getTitle().contains(subServices));

        }

        // Testing Company Module and verifying its submodule title.
        @Test(dataProvider = "userTypes")
        public void checkModuleCompanyIsCorrect(String username){
            CRM_Utilities.crm_login(driver, username);

            WebElement companyModule = driver.findElement(By.xpath(company));
            companyModule.click();
            Assert.assertTrue(driver.getTitle().contains(subCompany));

        }

}
