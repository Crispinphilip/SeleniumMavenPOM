package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TariffPlanAssignedPage {
    WebDriver driver;

    public TariffPlanAssignedPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isTariffPlanAssigned(){
        return driver.findElements(By.xpath("//h2[.='Congratulation Tariff Plan assigned']")).size()>0 ? true : false;
    }
}
