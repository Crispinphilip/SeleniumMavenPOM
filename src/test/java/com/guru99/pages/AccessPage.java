package com.guru99.pages;

import com.guru99.tests.BaseTest;
import com.guru99.utilities.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessPage {
    WebDriver driver;

    By customerID = By.xpath("//h3");

    public AccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCustomerIDGenerated() {
        return driver.findElements(customerID).size() > 0 ? true : false;
    }

    public void setCustometIDInGlobalVariable() {
        Constants.CUSTOMERID = driver.findElement(customerID).getText();
    }

}
