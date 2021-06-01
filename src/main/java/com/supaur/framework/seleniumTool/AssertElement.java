package com.supaur.framework.seleniumTool;

import com.supaur.framework.Sprint1.entity.Assert;
import com.supaur.framework.Sprint1.entity.Test;
import com.supaur.framework.utils.Log;
import com.supaur.framework.utils.MyException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
* 元素断言
* */
public class AssertElement {
    private String exceptValue;
    private WebDriver driver;
    public Log log = new Log(this.getClass().getSuperclass());
    public AssertElement(WebDriver driver){
        this.driver=driver;
    }
    //获取所要断言的元素
    public WebElement getElement(String type,String value) throws MyException {
        ElementGet webElement = new ElementGet(driver);
        WebElement element;
        switch (type){
            case "id":element=webElement.getElementById(value);break;
            case "name":element=webElement.getElementByName(value);break;
            case "xpath":element=webElement.getElementByXpath(value);break;
            case "className":element=webElement.getElementByClassName(value);break;
            case "tagName":element=webElement.getElementByTagName(value);break;
            case "linktext":element=webElement.getElementByLinktext(value);break;
            case "cssselector":element=webElement.getElementByCssselector(value);break;
            default:element=webElement.getElementByXpath(value);break;
        }
        return element;
    }

    //断言
    public void execute(Test test) throws MyException {
        WebElement element = getElement(test.getType(), test.getValue());
        for (Assert ass:test.getAsserts()){
            switch (ass.getType()){
                case "text":
                    //System.out.println(element.getText());
                    if (ass.getExpectValue().equals(element.getText())){
                        log.info("断言成功!"+"预期值:"+ass.getExpectValue()+";实际值："+element.getText());
                    }else{
                        log.error("断言失败!!!"+"预期值:"+ass.getExpectValue()+";实际值："+element.getText());
                    }
                    break;
                case "value":
                    //System.out.println(element.getAttribute("value"));
                    if (ass.getExpectValue().equals(element.getAttribute("value"))){
                        log.info("断言成功!"+"预期值:"+ass.getExpectValue()+";实际值："+element.getAttribute("value"));
                    }else{
                        log.error("断言失败!!!"+"预期值:"+ass.getExpectValue()+";实际值："+element.getAttribute("value"));
                    }
                    break;
                case "isDisplay":
                    //System.out.println(element.isDisplayed());
                    if (Boolean.parseBoolean(ass.getExpectValue())==element.isDisplayed()){
                        log.info("断言成功!"+"预期值:"+ass.getExpectValue()+";实际值："+element.isDisplayed());
                    }else {
                        log.error("断言失败!!!"+"预期值:"+ass.getExpectValue()+";实际值："+element.isDisplayed());
                    }
                    break;

            }
        }
    }



}
