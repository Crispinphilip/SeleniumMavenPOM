package com.guru99.pages;

import com.guru99.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillingPage {
    WebDriver driver;

    By customerID = By.xpath("//input[@id='customer_id']");

  /*  @FindBy(xpath = "//input[@type='text']") //Page factory
    WebElement customerID;*/

    @FindBy(name = "submit") //Page factory
    WebElement submitButton;

    public PayBillingPage(WebDriver driver){
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
 /*   public  void setDataOnCustomerID(String custID){
        customerID.sendKeys(String.valueOf(custID));
    }*/

    public  void clickOnSubmitBtn(){
        submitButton.click();
    }
}
