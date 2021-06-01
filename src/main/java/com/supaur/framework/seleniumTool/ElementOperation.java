package com.supaur.framework.seleniumTool;

import com.supaur.framework.Sprint1.entity.Test;
import com.supaur.framework.utils.MyException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/*
* 操作元素
* */
public class ElementOperation extends ElementGet {
    public Test test;
    public BrowserOperation browserOperation;
    public SpecialElementOperation specialElementOperation;
    public AssertPage assertPage;
    public AssertElement assertElement;
    public ElementOperation(Test test,WebDriver driver){
        super(driver);
        this.test=test;
    }
    public void execute() throws MyException {
        //浏览器操作
        browserOperation=new BrowserOperation(driver);
        //特殊元素操作
        specialElementOperation=new SpecialElementOperation(driver);
        //页面断言
        assertPage=new AssertPage(driver);
        //元素断言
        assertElement=new AssertElement(driver);
        switch (test.getOperator()){
            case "click":
                if (test.getHandle()==null){
                    RedirectJudge.judgeRedirect(driver);
                    getElement(test.getType(), test.getValue()).click();
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }else {
                    RedirectJudge.judgeRedirect(driver,test);
                    getElement(test.getType(), test.getValue()).click();
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }
                break;

            case "sendKeys":
                if (test.getHandle()==null){
                    RedirectJudge.judgeRedirect(this.driver);
                    getElement(test.getType(), test.getValue()).sendKeys(test.getParam());
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }else {
                    RedirectJudge.judgeRedirect(driver,test);
                    getElement(test.getType(), test.getValue()).sendKeys(test.getParam());
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }
                break;
            case "clear":
                if (test.getHandle()==null){
                    RedirectJudge.judgeRedirect(driver);
                    getElement(test.getType(),test.getValue()).clear();
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }else {
                    RedirectJudge.judgeRedirect(driver,test);
                    getElement(test.getType(),test.getValue()).clear();
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }
                break;
            case "navigate":
                if (test.getHandle()==null){
                    RedirectJudge.judgeRedirect(driver);
                    browserOperation.execute(test);
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }else {
                    RedirectJudge.judgeRedirect(driver,test);
                    browserOperation.execute(test);
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }
                break;
            case "alert":
                if (test.getHandle()==null){
                    RedirectJudge.judgeRedirect(driver);
                    specialElementOperation.alertOperation(test.getValue());
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }else {
                    RedirectJudge.judgeRedirect(driver,test);
                    specialElementOperation.alertOperation(test.getValue());
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }
                break;
            case "confirm":
                if (test.getHandle()==null){
                    RedirectJudge.judgeRedirect(driver);
                    specialElementOperation.confirmOperation(test.getValue());
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }else {
                    RedirectJudge.judgeRedirect(driver,test);
                    specialElementOperation.confirmOperation(test.getValue());
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }
                break;
            case "iframe":
                if (test.getHandle()==null){
                    RedirectJudge.judgeRedirect(driver);
                    specialElementOperation.switchToIframe(test.getType(),test.getValue());
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }else {
                    RedirectJudge.judgeRedirect(driver,test);
                    specialElementOperation.switchToIframe(test.getType(),test.getValue());
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }
                break;
                //系统断言
            case "systemAssert":
                if (test.getHandle()==null){
                    RedirectJudge.judgeRedirect(driver);
                    assertPage.execute(test);
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }else {
                    RedirectJudge.judgeRedirect(driver,test);
                    assertPage.execute(test);
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }
                break;
            case "elementAssert":
                if (test.getHandle()==null){
                    RedirectJudge.judgeRedirect(driver);
                    assertElement.execute(test);
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }else {
                    RedirectJudge.judgeRedirect(driver,test);
                    assertElement.execute(test);
                    log.info("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                    Reporter.log("desc："+test.getDesc()+";name:"+test.getName()+";定位信息："+test.getValue());
                }
                break;
        }
    }
}
