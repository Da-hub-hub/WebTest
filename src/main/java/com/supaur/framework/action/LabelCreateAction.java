package com.supaur.framework.action;

import com.supaur.framework.pageObject.LabelCreatePage;
import com.supaur.framework.seleniumTool.ElementAction;
import com.supaur.framework.seleniumTool.TestBaseCase;
import java.io.IOException;
public class LabelCreateAction extends TestBaseCase {
    public LabelCreateAction(String url,String username,String password,String labelName,String labelDetail) throws IOException{
        LabelCreatePage labelCreatePage = new LabelCreatePage();
        labelCreatePage.open(url);
        System.out.println(driver.getCurrentUrl());
        ElementAction action=new ElementAction();

        action.type(labelCreatePage.用户名输入框(),username);
        action.type(labelCreatePage.密码输入框(),password);
        action.click(labelCreatePage.登录按钮());

        action.click(labelCreatePage.进入标签管理());
        action.click(labelCreatePage.点击标签管理());
        action.click(labelCreatePage.进入手动标签列表(),1);
        action.click(labelCreatePage.新建手动标签页面());

        action.type(labelCreatePage.输入标签名称(),labelName);
        action.click(labelCreatePage.选择事件());
        action.click(labelCreatePage.选择分页3事件());
        action.click(labelCreatePage.选择标签样式());
        action.click(labelCreatePage.选择手动标签样式(),4);
        action.type(labelCreatePage.标签描述(),labelDetail);


    }
}
