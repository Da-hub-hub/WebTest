package com.supaur.framework.utils;

import com.supaur.framework.Sprint1.entity.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 判断页面是否重定向,如果重定向的话就切换到当前句柄
 */

public class RedirectJudge {

    //如果未指定需要的窗口，则自动切换到最新的句柄
    public  static WebDriver judgeRedirect(WebDriver driver){
        //全部句柄是set集合，是无序的
        Set<String> windowHandles = driver.getWindowHandles();
        //将set集合转换成list有序结合，进行句柄的切换
        List<String > handles=new ArrayList<String >(windowHandles);
        if (handles.size()!=1){
            handles.remove(0);
        }
        driver.switchTo().window(handles.get(0));
        return driver;
    }

    //如果test中存在的handle参数，则将句柄切换到对应指定的句柄

    public static WebDriver judgeRedirect(WebDriver driver, Test test){
        String handle = test.getHandle();
        int i = Integer.parseInt(handle)-1;
        //全部句柄是set集合，是无序的
        Set<String> windowHandles = driver.getWindowHandles();
        //将set集合转换成list有序结合，进行句柄的切换
        List<String > handles=new ArrayList<String >(windowHandles);
        driver.switchTo().window(handles.get(i));
        return driver;

    }
}
