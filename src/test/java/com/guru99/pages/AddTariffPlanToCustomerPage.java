package com.guru99.pages;

import com.guru99.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTariffPlanToCustomerPage {
    WebDriver driver;

    By customerID = By.xpath("//input[@id='customer_id']");

    @FindBy(name = "submit") //Page factory
    WebElement submitButton;

    public AddTariffPlanToCustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public  void setDataOnCustomerID(String custID){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(Utility.isElementDisplayed(driver,customerID)){
            driver.findElement(customerID).sendKeys(custID);
        }
    }

    public  void clickOnSubmitBtn(){
        submitButton.click();
    }
}
