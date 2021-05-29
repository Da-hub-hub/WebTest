package com.supaur.framework.Sprint1.run;

import com.supaur.framework.Sprint1.entity.Test;
import com.supaur.framework.Sprint1.entity.TestCase;
import com.supaur.framework.utils.Log;
import com.supaur.framework.utils.RedirectJudge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class CaseRun {
    WebDriver driver;
    TestCase testCase;

    public Log log = new Log(this.getClass().getSuperclass());
    public CaseRun(WebDriver driver,TestCase testCase){
        this.driver=driver;
        this.testCase=testCase;
    }
    //智能等待
    public Boolean waitElementIsEnableBy(By by){
        try{
            long waitTime=8;
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            (new WebDriverWait(driver,waitTime)).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public  void execute(){
        List<Test> tests = testCase.getTest();
        for (Test test : tests) {

            if (test.getHandle()==null){
                this.driver=RedirectJudge.judgeRedirect(driver);
            }else {
                this.driver=RedirectJudge.judgeRedirect(driver,test);
                log.info("已切换到第"+test.getHandle()+"个页面！");
            }
            WebElement webElement=null;
            switch (test.getType()) {
                case "xpath":
                    if (waitElementIsEnableBy(By.xpath(test.getValue()))){
                        webElement = driver.findElement(By.xpath(test.getValue()));
                        break;
                    }else {
                        log.error("8s内没有找到：“"+test.getDesc());
                        break;
                    }

                case "id":
                    if (waitElementIsEnableBy(By.id(test.getValue()))){
                        webElement = this.driver.findElement(By.id(test.getValue()));
                        break;
                    }else {
                        log.error("8s内没有找到：“"+test.getDesc());
                        break;
                    }
                case "cssSelector":
                    if (waitElementIsEnableBy(By.cssSelector(test.getValue()))){
                        webElement = this.driver.findElement(By.cssSelector(test.getValue()));
                        break;
                    }else {
                        log.error("8s内没有找到：“"+test.getDesc());
                        break;
                    }
                case "name":
                    if (waitElementIsEnableBy(By.name(test.getValue()))){
                        webElement = this.driver.findElement(By.name(test.getValue()));
                        break;
                    }else {
                        log.error("8s内没有找到：“"+test.getDesc());
                        break;
                    }
                case "className":
                    if (waitElementIsEnableBy(By.className(test.getValue()))){
                        webElement = this.driver.findElement(By.className(test.getValue()));
                        break;
                    }else {
                        log.error("8s内没有找到：“"+test.getDesc());
                        break;
                    }
                case "linkText":
                    if (waitElementIsEnableBy(By.linkText(test.getValue()))){
                        webElement = this.driver.findElement(By.linkText(test.getValue()));
                        break;
                    }else {
                        log.error("8s内没有找到：“"+test.getDesc());
                        break;
                    }
                case "partialLinkText":
                    if (waitElementIsEnableBy(By.partialLinkText(test.getValue()))){
                        webElement = this.driver.findElement(By.partialLinkText(test.getValue()));
                        break;
                    }else {
                        log.error("8s内没有找到：“"+test.getDesc());
                        break;
                    }
                case "tagName":
                    if (waitElementIsEnableBy(By.tagName(test.getValue()))){
                        webElement = this.driver.findElement(By.tagName(test.getValue()));
                        break;
                    }else {
                        log.error("8s内没有找到：“"+test.getDesc());
                        break;
                    }
                default:
                    if (waitElementIsEnableBy(By.xpath(test.getValue()))){
                        webElement = this.driver.findElement(By.xpath(test.getValue()));
                        break;
                    }else {
                        log.error("8s内没有找到：“"+test.getDesc());
                        break;
                    }
            }

                if (test.getParam()!= null) {
                    webElement.sendKeys(test.getParam().getValue());
                    log.info("元素描述："+test.getDesc()+";元素定位方式："+test.getType()+";元素定位值："+test.getValue()+";操作类型：输入"+";输入值："+test.getParam().getValue());
                } else {
                    webElement.click();
                    log.info("元素描述："+test.getDesc()+";元素定位方式："+test.getType()+";元素定位值："+test.getValue()+";操作类型：点击");
                }
            /*Thread.sleep(Long.parseLong(test.getTimeout()));
            log.info("下一元素加载所需时间："+Integer.parseInt(test.getTimeout())/1000+"秒");*/





        }
    }
}
