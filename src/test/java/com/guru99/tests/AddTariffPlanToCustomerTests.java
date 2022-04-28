package com.guru99.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guru99.pages.*;
import com.guru99.utilities.Constants;
import com.guru99.utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AddTariffPlanToCustomerTests extends BaseTest {
    WebDriver driver;
    IndexPage indexPage;
    AddTariffPlanToCustomerPage addTariffPlanToCustomerPage;
    AddApprovedTariffPlansPage addApprovedTariffPlansPage;
    TariffPlanAssignedPage tariffPlanAssignedPage;
    ExtentTest extentTest;

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestResult iTestResult) {
        extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
        driver = openApplication();
        indexPage = new IndexPage(driver);
        addTariffPlanToCustomerPage = new AddTariffPlanToCustomerPage(driver);
        addApprovedTariffPlansPage = new AddApprovedTariffPlansPage(driver);
        tariffPlanAssignedPage = new TariffPlanAssignedPage(driver);
    }

    @Test(groups = {"smoke", "regression"})
    public void AddTariffPlanToCustomerTest1() {
        System.out.println("******************Start of AddTariffPlanToCustomerTest1*************");
        indexPage.clickOnAddTariffPlanToCustomer();
        extentTest.log(Status.PASS, "Clicked on Add Tariff Plan To Customer");
        addTariffPlanToCustomerPage.setDataOnCustomerID(Constants.CUSTOMERID);
        addTariffPlanToCustomerPage.clickOnSubmitBtn();
        addApprovedTariffPlansPage.clickOnSelectRadioBtn();
        addApprovedTariffPlansPage.clickOnAddTariffPlanButton();
        extentTest.log(Status.PASS, "Clicked on Add Tariff Plan button");
        Assert.assertTrue(tariffPlanAssignedPage.isTariffPlanAssigned(), "Tariff Plan to Customer not added");
        System.out.println("****************** End of AddTariffPlanToCustomerTest1*****************");
    }
}
