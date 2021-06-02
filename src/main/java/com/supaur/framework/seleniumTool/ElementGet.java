package com.supaur.framework.seleniumTool;

import com.supaur.framework.utils.Log;
import com.supaur.framework.utils.MyException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

/*
* 根定位信息获取元素
* */
public class ElementGet {
    public WebDriver driver;
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
                 //log.info("元素已找到");
                 return element;
             }else {
                    //log.error("8s内没有定位到元素");
                    throw new MyException("8s内没有定位到元素");
             }
    }


    //根据name定位元素
    public WebElement getElementByName(String name) throws MyException{
        waitElementIsEnable=new WaitElementIsEnable(driver);
        if (waitElementIsEnable.implicitWait(By.name(name))){
            element = driver.findElement(By.name(name));
            //log.info("元素已找到");
            return element;
        }else {
            //log.error("8s内没有定位到元素");
            throw new MyException("8s内没有定位到元素");
        }
    }
    //根据name定位元素
    public WebElement getElementByXpath(String xpath) throws MyException {
        waitElementIsEnable=new WaitElementIsEnable(driver);
        if (waitElementIsEnable.implicitWait(By.xpath(xpath))){
            element = driver.findElement(By.xpath(xpath));
            //log.info("元素已找到");
            return element;
        }else {
            //log.error("8s内没有定位到元素");
            throw new MyException("8s内没有定位到元素");

        }
    }

    //根据className定位元素
    public WebElement getElementByClassName(String className) throws MyException {
        waitElementIsEnable=new WaitElementIsEnable(driver);
        if (waitElementIsEnable.implicitWait(By.className(className))){
            element = driver.findElement(By.className(className));
            //log.info("元素已找到");
            return element;
        }else {
            //log.error("8s内没有定位到元素");
            throw new MyException("8s内没有定位到元素");
        }
    }


    //根据tagName定位元素
    public WebElement getElementByTagName(String tagName) throws MyException {
        waitElementIsEnable=new WaitElementIsEnable(driver);
        if (waitElementIsEnable.implicitWait(By.tagName(tagName))){
            element = driver.findElement(By.tagName(tagName));
            //log.info("元素已找到");
            return element;
        }else {
            //log.error("8s内没有定位到元素");
            throw new MyException("8s内没有定位到元素");
        }
    }

    //根据Linktext定位元素
    public WebElement getElementByLinktext(String linktext) throws MyException {
        waitElementIsEnable=new WaitElementIsEnable(driver);
        if (waitElementIsEnable.implicitWait(By.linkText(linktext))){
            element = driver.findElement(By.linkText(linktext));
            //log.info("元素已找到");
            return element;
        }else {
            //log.error("8s内没有定位到元素");
            throw new MyException("8s内没有定位到元素");
        }
    }

    //根据Cssselector定位元素
    public WebElement getElementByCssselector(String Cssselector) throws MyException {
        waitElementIsEnable=new WaitElementIsEnable(driver);
        if (waitElementIsEnable.implicitWait(By.cssSelector(Cssselector))){
            element = driver.findElement(By.cssSelector(Cssselector));
            //log.info("元素已找到");
            return element;
        }else {
            //log.error("8s内没有定位到元素");
            throw new MyException("8s内没有定位到元素");
        }
    }

    public WebElement getElement(String type,String value) throws MyException {
        switch (type){
            case "id":getElementById(value);break;
            case "name":getElementByName(value);break;
            case "xpath":getElementByXpath(value);break;
            case "className":getElementByClassName(value);break;
            case "linkText":getElementByLinktext(value);break;
            case "cssSelector":getElementByCssselector(value);break;
            case "tagName":getElementByTagName(value);break;
        }
        return element;

    }



}
