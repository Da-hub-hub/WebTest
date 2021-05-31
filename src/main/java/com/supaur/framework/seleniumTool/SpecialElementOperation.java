package com.supaur.framework.seleniumTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
* 特殊元素操作
* */
public class SpecialElementOperation {
    public WebDriver driver;
    public String value;
    public SpecialElementOperation(){

    }
    public SpecialElementOperation(WebDriver driver,String value){
        this.driver=driver;
        this.value=value;
    }
    //切换iframe
    public void switchToIframe(String value){
        ElementGet element = new ElementGet(driver);
        switch (value){

        }


    }

}
