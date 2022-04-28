package com.guru99.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guru99.pages.IndexPage;
import com.guru99.pages.PayBillingPage;
import com.guru99.pages.PayBillingSummary;
import com.guru99.utilities.Constants;
import com.guru99.utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PayBllingTests extends BaseTest {
    WebDriver driver;
    IndexPage indexPage;
    PayBillingPage payBillingPage;
    PayBillingSummary payBillingSummary;
    ExtentTest extentTest;


    @BeforeMethod(alwaysRun = true)
    public void setUp( ITestResult iTestResult) {
        extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
        driver = openApplication();
        indexPage = new IndexPage(driver);
        payBillingPage = new PayBillingPage(driver);
        payBillingSummary = new PayBillingSummary(driver);
    }

    @Test(groups = {"smoke", "regression"})
    public void PayBllingTest1() {

        System.out.println("*********************** Start ofPayBlling  Test1************************** ");
        indexPage.clickOnpayBilling();
        extentTest.log(Status.PASS, "Clicked On Pay Billing");
        payBillingPage.setDataOnCustomerID(Constants.CUSTOMERID);
        // payBillingPage.setDataOnCustomerID(Utility.readDataFromProperties("CUSTOMERID"));
        payBillingPage.clickOnSubmitBtn();
        extentTest.log(Status.PASS, "Clicked on Submit button");
        Assert.assertTrue(payBillingSummary.isPayBillingSummary(), "Tariff Plan to Customer not added");
        System.out.println("************************ End of PayBllingTest1 **********************");
    }
}
