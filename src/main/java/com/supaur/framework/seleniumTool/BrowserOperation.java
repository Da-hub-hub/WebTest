package com.supaur.framework.seleniumTool;

import org.openqa.selenium.WebDriver;
/*
* 浏览器操作
* */
public class BrowserOperation {
    private WebDriver driver;
    private String value;
    public BrowserOperation(){

    }
    public BrowserOperation(WebDriver driver,String value){
        this.driver=driver;
        this.value=value;
    }

    //浏览器后退
    public void BrowserBack(String type){
        driver.navigate().back();
    }

    //浏览器前进
    public void Browserforward(String type){
        driver.navigate().forward();
    }

    //浏览跳转指定url
    public void BrowserToUrl(String type){
        driver.navigate().to(type);
    }

    //浏览器刷新
    public void BrowseRefresh(String type){
        driver.navigate().refresh();
    }
}
