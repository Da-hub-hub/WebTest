package com.supaur.framework.pageObject;
import java.io.IOException;
import java.io.InputStream;
import com.supaur.framework.seleniumTool.BaseAction;
import com.supaur.framework.seleniumTool.Locator;
import com.supaur.framework.pageObjectConfig.PageObjectAutoCode;//登录页面_对象库类
public class CdpLoginPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/supaur/framework/pageObjectConfig/CdpLogin.xml";
 public   CdpLoginPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 用户名输入框
* @return
* @throws IOException
*/
public Locator 用户名输入框() throws IOException
 {
   Locator locator=getLocator("用户名输入框");
   return locator;
 }

/***
* 密码输入框
* @return
* @throws IOException
*/
public Locator 密码输入框() throws IOException
 {
   Locator locator=getLocator("密码输入框");
   return locator;
 }

/***
* 登录
* @return
* @throws IOException
*/
public Locator 登录按钮() throws IOException
 {
   Locator locator=getLocator("登录按钮");
   return locator;
 }
}