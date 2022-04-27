package com.guru99.pages;

import com.guru99.utilities.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddApprovedTariffPlansPage {
    WebDriver driver;
    //input[@id='sele']/parent::td/label
    @FindBy(xpath = "//input[@id='sele']/../label") //Page factory
    WebElement selectRadioBtn;

    @FindBy(name = "submit") //Page factory
    WebElement addTariffPlanButton;

    public AddApprovedTariffPlansPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public  void clickOnSelectRadioBtn(){
        //Utility.scrollDownToViewElement(driver,selectRadioBtn);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",selectRadioBtn);
    }

    public  void clickOnAddTariffPlanButton() {
        addTariffPlanButton.click();
    }

}
