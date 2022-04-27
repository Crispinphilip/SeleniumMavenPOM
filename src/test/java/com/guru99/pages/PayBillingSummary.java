package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PayBillingSummary {
    WebDriver driver;

    public PayBillingSummary(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isPayBillingSummary(){
        return driver.findElements(By.xpath("//h3")).size()>0 ? true : false;
    }
}
