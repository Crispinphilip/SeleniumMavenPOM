package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTariffPlanSuccessPage {
    WebDriver driver;

    public AddTariffPlanSuccessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isTariffPlanAdded(){
        return driver.findElements(By.xpath("//h2")).size()>0 ? true : false;
    }
}
