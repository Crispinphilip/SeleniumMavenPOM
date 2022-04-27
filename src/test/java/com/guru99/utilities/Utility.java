package com.guru99.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {

    public static void switchToFrame(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@id,'google_ads_iframe')]")));
            // WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id,'google_ads_iframe')]"));
            driver.switchTo().frame(frame);
            driver.findElement(By.xpath("//div[@id='dismiss-button']/div")).click();
            driver.switchTo().defaultContent();
        } catch (Exception e) {
        }
    }

    public static String readDataFromProperties(String key) {
        try {
            FileInputStream fileInputStream = new FileInputStream("guru99.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void scrollDownToViewElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static boolean isElementDisplayed(WebDriver driver, By xpath) {

        int MAXTRY = 10;
        for (int i = 0; i < MAXTRY; i++) {
            if (!(driver.findElements(xpath).size() > 0)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                return true;
            }
        }
        return false;
    }

}

