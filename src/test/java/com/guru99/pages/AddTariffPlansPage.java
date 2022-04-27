package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTariffPlansPage {
    WebDriver driver;

    @FindBy(id = "rental1") //Page factory
    WebElement monthlyRent;

    @FindBy(id = "local_minutes") //Page factory
    WebElement freeLocalMins;

    @FindBy(id = "inter_minutes") //Page factory
    WebElement freeInternationalMins;

    @FindBy(id = "sms_pack") //Page factory
    WebElement freeSmsPack;

    @FindBy(id = "minutes_charges") //Page factory
    WebElement localMinCharges;

    @FindBy(id = "inter_charges") //Page factory
    WebElement internationalMinCharges;

    @FindBy(id = "sms_charges") //Page factory
    WebElement smsPerCharges;

    @FindBy(name = "submit") //Page factory
    WebElement submitButton;

    public AddTariffPlansPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public  void setDataOnMonthlyRent(String mrent){
        monthlyRent.sendKeys(String.valueOf(mrent));
    }

    public  void setDataOnFreeLocalMins(String localmin){
        freeLocalMins.sendKeys(String.valueOf(localmin));
    }

    public  void setDataOnFreeInternationalMins(String intermins){ freeInternationalMins.sendKeys(String.valueOf(intermins)); }

    public  void setDataOnFreeSmsPack(String smspack){ freeSmsPack.sendKeys(String.valueOf(smspack));    }

    public  void setDataOnLocalMinCharges(String lMinCharges){
        localMinCharges.sendKeys(String.valueOf(lMinCharges));
    }

    public  void setDataOnInternationalMinCharges(String intermincharges){ internationalMinCharges.sendKeys(String.valueOf(intermincharges)); }

    public  void setDataOnSmsPerCharges(String smscharges){
        smsPerCharges.sendKeys(String.valueOf(smscharges));
    }

    public  void clickOnSubmitBtn(){
        submitButton.click();
    }

}
