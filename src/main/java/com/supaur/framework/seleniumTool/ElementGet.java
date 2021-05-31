package com.supaur.framework.seleniumTool;

import com.supaur.framework.utils.Log;
import com.supaur.framework.utils.MyException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*
* 根定位信息获取元素
* */
public class ElementGet {
    private WebDriver driver;
    private WebElement element;
    public Log log = new Log(this.getClass().getSuperclass());
    public ElementGet(){
    }
    public ElementGet(WebDriver driver){
        this.driver=driver;
    }
    public WaitElementIsEnable waitElementIsEnable;
    //根据id定位元素
    public WebElement getElementById(String id) throws MyException{
        waitElementIsEnable=new WaitElementIsEnable(driver);
        if (waitElementIsEnable.implicitWait(By.id(id))){
                 element = driver.findElement(By.id(id));
                 log.info("元素已找到");
                 return element;
             }else {
                    log.error("8s内没有定位到元素");
                    throw new MyException("8s内没有定位到元素");
             }
    }


    //TODO


    //根据name定位元素
    public WebElement getElementByName(String name){
        try{
            element = driver.findElement(By.name(name));
        }catch (Exception e){
            System.out.println(e.getMessage());
            log.error("根据："+name+"未定位到元素");
        }
        return element;
    }
    //根据name定位元素
    public WebElement getElementByXpath(String xpath){
        try{
            element = driver.findElement(By.xpath(xpath));
        }catch (Exception e){
            System.out.println(e.getMessage());
            log.error("根据："+xpath+"未定位到元素");
        }
        return element;
    }

    //根据className定位元素
    public WebElement getElementByClassName(String className){
        try{
            element = driver.findElement(By.className(className));
        }catch (Exception e){
            System.out.println(e.getMessage());
            log.error("根据："+className+"未定位到元素");
        }
        return element;
    }


    //根据tagName定位元素
    public WebElement getElementByTagName(String tagName){
        try{
            element = driver.findElement(By.tagName(tagName));
        }catch (Exception e){
            System.out.println(e.getMessage());
            log.error("根据："+tagName+"未定位到元素");
        }
        return element;
    }

    //根据Linktext定位元素
    public WebElement getElementByLinktext(String linktext){
        try{
            element = driver.findElement(By.linkText(linktext));
        }catch (Exception e){
            System.out.println(e.getMessage());
            log.error("根据："+linktext+"未定位到元素");
        }
        return element;
    }

    //根据Cssselector定位元素
    public WebElement getElementByCssselector(String Cssselector){
        try{
            element = driver.findElement(By.cssSelector(Cssselector));
        }catch (Exception e){
            System.out.println(e.getMessage());
            log.error("根据："+Cssselector+"未定位到元素");
        }
        return element;
    }



}
