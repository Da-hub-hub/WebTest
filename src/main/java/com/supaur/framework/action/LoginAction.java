package com.supaur.framework.action;

import com.supaur.framework.pageObject.CdpLoginPage;
import com.supaur.framework.seleniumTool.ElementAction;
import com.supaur.framework.seleniumTool.TestBaseCase;

import java.io.IOException;

public class LoginAction extends TestBaseCase {
    public LoginAction(String Url, String UserName, String PassWord) throws IOException
    {
        //此driver变量继承自TestBase变量
        CdpLoginPage loginPage=new CdpLoginPage();
        loginPage.open(Url);
        System.out.println(driver.getCurrentUrl());
        ElementAction action=new ElementAction();

        action.type(loginPage.用户名输入框(),UserName);
        action.type(loginPage.密码输入框(),PassWord);
        action.click(loginPage.登录按钮());
    }
}
