package com.supaur.framework.seleniumTool;

import com.supaur.framework.Sprint1.entity.Assert;
import com.supaur.framework.Sprint1.entity.Test;
import com.supaur.framework.utils.Log;
import com.supaur.framework.utils.MyException;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.WebDriver;

import java.util.List;

/*
* 页面断言
* */
public class AssertPage {
    private String type;
    private String exceptValue;
    private WebDriver driver;
    public Log log = new Log(this.getClass().getSuperclass());
    public AssertPage(WebDriver driver){
        this.driver=driver;
    }

    //断言标题
    public void assertTitle(String expectValue)throws MyException{
        String title = driver.getTitle();
        if (title.equals(expectValue)){
            log.info("断言成功!"+"预期值："+exceptValue+";实际值："+title);
        }else {
            log.error("断言失败!!!"+"预期值："+exceptValue+";实际值："+title);
            //throw new MyException("断言失败！");

        }
    }

    //断言当前url
    public void assertCurrentUrl(String exceptValue)throws MyException{
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(exceptValue)){
            log.info("断言成功！"+"预期值："+exceptValue+";实际值："+currentUrl);
        }else {
            log.error("断言失败!!!"+"预期值："+exceptValue+";实际值："+currentUrl);
            //throw new MyException("断言失败");
        }
    }

    public void execute(Test test) throws MyException {
        List<Assert> asserts=test.getAsserts();
        for (Assert ass : asserts){
            if (ass.getType().equals("currentUrl")){
                assertCurrentUrl(ass.getExpectValue());
            }else if (ass.getType().equals("title")){
                assertTitle(ass.getExpectValue());
            }else {
                log.error("断言失败，断言参数不合法！");
                //throw new MyException("断言失败，断言参数不合法");
            }
        }




    }
}
