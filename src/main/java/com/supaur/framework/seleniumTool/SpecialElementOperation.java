package com.supaur.framework.seleniumTool;

import com.supaur.framework.Sprint1.entity.Test;
import com.supaur.framework.utils.Log;
import com.supaur.framework.utils.MyException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
* 特殊元素操作
* */
public class SpecialElementOperation {
    public WebDriver driver;
    public WebElement webElement;
    public Log log = new Log(this.getClass().getSuperclass());
    public SpecialElementOperation(){

    }
    public SpecialElementOperation(WebDriver driver){
        this.driver=driver;
    }
    //切换iframe
    /*
    * type:元素定位类型
    * value:元素定位值
    * */
    public void switchToIframe(String type,String value) throws MyException {
        ElementGet element = new ElementGet(driver);

        switch (type){
            case "id":webElement=element.getElementById(value);
            case "name":webElement=element.getElementByName(value);
            case "xpath":webElement=element.getElementByXpath(value);
            case "className":webElement=element.getElementByClassName(value);
            case "tagName":webElement=element.getElementByTagName(value);
            case "linktext":webElement=element.getElementByLinktext(value);
            case "cssselector":webElement=element.getElementByCssselector(value);
            default:webElement=element.getElementByXpath(value);
        }
        //iframe跳转
        driver.switchTo().frame(webElement);
        log.info("已切换至指定iframe");
    }
    //回到默认iframe
    public void switchToDefaultIframe(){
        driver.switchTo().defaultContent();
        log.info("已回到默认iframe");
    }

    //alert弹窗操作
    public void alertOperation(String value) throws MyException {
        switch (value){
            case "accept":try{
                driver.switchTo().alert().accept();
                log.info("弹窗已确认");
            }catch (Exception e ){
                throw new MyException("未捕获到弹窗,确认操作失败");
            }
            case "dismiss":try{
                driver.switchTo().alert().dismiss();
                log.info("弹窗已消失");
            }catch (Exception e){
                throw new MyException("未捕获到弹窗，弹窗消失操作失败");
            }
        }
    }
    //confirm弹窗操作
    public void confirmOperation(String value) throws MyException {
        switch (value){
            case "accept":try{
                driver.switchTo().alert().accept();
                log.info("弹窗已确认");
            }catch (Exception e ){
                throw new MyException("未捕获到弹窗,确认弹窗操作失败");
            }
            case "dismiss":try{
                driver.switchTo().alert().dismiss();
                log.info("弹窗已取消");
            }catch (Exception e){
                throw new MyException("未捕获到弹窗，取消弹窗操作失败");
            }
        }
    }

}
