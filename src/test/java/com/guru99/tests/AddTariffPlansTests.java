package com.guru99.tests;

import com.aventstack.extentreports.ExtentTest;
import com.guru99.pages.*;
import com.guru99.utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddTariffPlansTests extends BaseTest {

    WebDriver driver;
    IndexPage indexPage;
    AddTariffPlansPage addTariffPlansPage;
    AddTariffPlanSuccessPage addTariffPlanSuccessPage;
    ExtentTest extentTest;

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestResult iTestResult) {
        // public void setUp() {
        //   String browserName = System.getProperty("browser");
        // String env = System.getProperty("env");
        extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
        driver = openApplication();
        indexPage = new IndexPage(driver);
        addTariffPlansPage = new AddTariffPlansPage(driver);
        addTariffPlanSuccessPage = new AddTariffPlanSuccessPage(driver);
    }

    @Test(groups = {"smoke", "regression"})
    public void AddTariffPlansTest1() {
        System.out.println("****************************Test Case 1**************************");
        indexPage.clickOnAddTariffPlan();
        addTariffPlansPage.setDataOnMonthlyRent(Utility.readDataFromProperties("MONTHLYRENT"));
        addTariffPlansPage.setDataOnFreeLocalMins(Utility.readDataFromProperties("FREELOCALMINS"));
        addTariffPlansPage.setDataOnFreeInternationalMins(Utility.readDataFromProperties("FREEINTERMINS"));
        addTariffPlansPage.setDataOnFreeSmsPack(Utility.readDataFromProperties("FREESMSPACK"));
        addTariffPlansPage.setDataOnLocalMinCharges(Utility.readDataFromProperties("LOCALMINCHARGES"));
        addTariffPlansPage.setDataOnInternationalMinCharges(Utility.readDataFromProperties("INTERMINCHARGES"));
        addTariffPlansPage.setDataOnSmsPerCharges(Utility.readDataFromProperties("SMSPERCHARGE"));
        addTariffPlansPage.clickOnSubmitBtn();
        Assert.assertTrue(addTariffPlanSuccessPage.isTariffPlanAdded(), "Add Tariff Plan to Customer is unsuccessful");

    }


    @Test(groups = {"regression"})
    public void AddTariffPlansTest2() {
        System.out.println("*********************Test case 2****************************");
        indexPage.clickOnAddCustomer();
        addTariffPlansPage.setDataOnMonthlyRent(Utility.readDataFromProperties("MONTHLYRENT"));
        addTariffPlansPage.setDataOnFreeLocalMins(Utility.readDataFromProperties("FREELOCALMINS"));
        addTariffPlansPage.setDataOnFreeInternationalMins(Utility.readDataFromProperties("FREEINTERMINS"));
        addTariffPlansPage.setDataOnFreeSmsPack(Utility.readDataFromProperties("FREESMSPACK"));
        addTariffPlansPage.setDataOnLocalMinCharges(Utility.readDataFromProperties("LOCALMINCHARGES"));
        addTariffPlansPage.setDataOnInternationalMinCharges(Utility.readDataFromProperties("INTERMINCHARGES"));
        addTariffPlansPage.setDataOnSmsPerCharges(Utility.readDataFromProperties("SMSPERCHARGE"));
        addTariffPlansPage.clickOnSubmitBtn();
        Assert.assertTrue(addTariffPlanSuccessPage.isTariffPlanAdded(), "Add Tariff Plan to Customer is unsuccessful");

    }
}
