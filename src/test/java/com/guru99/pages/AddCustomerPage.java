package com.guru99.pages;

import com.guru99.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    WebDriver driver;

    @FindBy(xpath = "//label[.='Done']") //Page factory
    WebElement doneRadioBtn;

    @FindBy(id = "fname") //Page factory
    WebElement fname;

    @FindBy(id = "lname") //Page factory
    WebElement lname;

    @FindBy(id = "email") //Page factory
    WebElement email;

    @FindBy(xpath = "//textarea[@id='message']") //Page factory
    WebElement address;

    @FindBy(id = "telephoneno") //Page factory
    WebElement telephoneNo;

    @FindBy(name = "submit") //Page factory
    WebElement submitBtn;

    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public  void clickOnSubmitBtn(){
        submitBtn.click();
    }

    public  void clickOnDoneRadioBtn() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",doneRadioBtn);
        //doneRadioBtn.click();
    }

    public  void setDataOnFname(String fn){
        fname.sendKeys(fn);
    }

    public  void setDataOnTelephoneNo(String phoneNumber){
        telephoneNo.sendKeys(phoneNumber);
    }

    public  void setDataOnLname(String ln){
        lname.sendKeys(ln);
    }

    public  void setDataOnEmail(String mail){
        email.sendKeys(mail);
    }

    public  void setDataOnAddress(String addr){
        address.sendKeys(addr);
    }
}
