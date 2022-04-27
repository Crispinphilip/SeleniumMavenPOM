package com.guru99.pages;

import com.guru99.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    WebDriver driver;

    @FindBy(xpath = "//a[.='Add Customer']") //Page factory
    WebElement addCustomer;

    @FindBy(xpath = "//a[.='Add Tariff Plan']") //Page factory
    WebElement addTariffPlan;

    @FindBy(xpath = "//a[.='Add Tariff Plan to Customer']") //Page factory
    WebElement addTariffPlanToCustomer;

    @FindBy(xpath = "//a[.='Pay Billing']") //Page factory
    WebElement payBilling;

    public IndexPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public  void clickOnAddTariffPlan(){
        addTariffPlan.click();
        Utility.switchToFrame(driver);
    }

    public  void clickOnAddCustomer(){
        addCustomer.click();
        Utility.switchToFrame(driver);
    }

    public  void clickOnAddTariffPlanToCustomer() {
        addTariffPlanToCustomer.click();
        Utility.switchToFrame(driver);
    }

    public  void clickOnpayBilling(){
        payBilling.click();
        Utility.switchToFrame(driver);
    }

}
