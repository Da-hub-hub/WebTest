package com.supaur.framework.seleniumTool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitElementIsEnable {
    public WebDriver driver;
    public WaitElementIsEnable(){
    }
    public WaitElementIsEnable(WebDriver driver){
        this.driver=driver;
    }
    //隐式等待,等待时间：8s
    public Boolean implicitWait(By by){
        try{
            long waitTime=8;
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            (new WebDriverWait(driver,waitTime)).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
