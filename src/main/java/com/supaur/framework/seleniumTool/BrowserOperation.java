package com.supaur.framework.seleniumTool;

import com.supaur.framework.Sprint1.entity.Test;
import org.openqa.selenium.WebDriver;
/*
* 浏览器操作
* */
public class BrowserOperation {
    private WebDriver driver;
    public BrowserOperation(){

    }
    public BrowserOperation(WebDriver driver){
        this.driver=driver;

    }

    //浏览器后退
    public void BrowserBack(){
        driver.navigate().back();
    }

    //浏览器前进
    public void Browserforward(){
        driver.navigate().forward();
    }

    //浏览跳转指定url
    public void BrowserToUrl(String url){
        driver.navigate().to(url);
    }

    //浏览器刷新
    public void BrowseRefresh(){
        driver.navigate().refresh();
    }

    public void execute(Test test){
        switch (test.getType()){
            case "back":BrowserBack();break;
            case "forward":Browserforward();break;
            case "toUrl":BrowserToUrl(test.getValue());break;
        }
    }
}
