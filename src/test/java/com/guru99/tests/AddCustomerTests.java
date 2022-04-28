package com.guru99.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guru99.pages.AccessPage;
import com.guru99.pages.AddCustomerPage;
import com.guru99.pages.IndexPage;
import com.guru99.utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCustomerTests extends BaseTest {
    WebDriver driver;
    IndexPage indexPage;
    AddCustomerPage addCustomerPage;
    AccessPage accessPage;
    ExtentTest extentTest;

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestResult iTestResult) {
   // public void setUp() {
     //   String browserName = System.getProperty("browser");
       // String env = System.getProperty("env");
        extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
        driver = openApplication();
        indexPage = new IndexPage(driver);
        addCustomerPage = new AddCustomerPage(driver);
        accessPage = new AccessPage(driver);
    }

    @Test(groups = {"smoke", "regression"})
    public void addCustomerTest1() {
        System.out.println("**************************** Start Add Customer Test1 **************************");
        indexPage.clickOnAddCustomer();
        extentTest.log(Status.PASS, "Clicked on Add Customer");
        addCustomerPage.clickOnDoneRadioBtn();
        extentTest.log(Status.PASS, "Clicked on Done Radio button");
        addCustomerPage.setDataOnFname(Utility.readDataFromProperties("FIRSTNAME"));
        extentTest.log(Status.PASS, "Enterned data in Firstname");
        addCustomerPage.setDataOnLname(Utility.readDataFromProperties("LASTNAME"));
        addCustomerPage.setDataOnEmail(Utility.readDataFromProperties("EMAIL"));
        addCustomerPage.setDataOnAddress(Utility.readDataFromProperties("ADDRESS"));
        addCustomerPage.setDataOnTelephoneNo(Utility.readDataFromProperties("PHONENUMBER"));
        addCustomerPage.clickOnSubmitBtn();
        extentTest.log(Status.PASS, "Clicked on Submit button");
        Assert.assertTrue(accessPage.isCustomerIDGenerated(), "Customer ID is not generated");
        accessPage.setCustometIDInGlobalVariable();
        System.out.println("****************************End of Add customer tEST**************************");
    }

}
