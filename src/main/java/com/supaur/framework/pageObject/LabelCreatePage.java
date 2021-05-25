package com.supaur.framework.pageObject;
import java.io.IOException;
import java.io.InputStream;
import com.supaur.framework.seleniumTool.BaseAction;
import com.supaur.framework.seleniumTool.Locator;
import com.supaur.framework.pageObjectConfig.PageObjectAutoCode;//登录页面_对象库类
public class LabelCreatePage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/supaur/framework/pageObjectConfig/LabelCreate.xml";
 public   LabelCreatePage() {
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

/***
* 进入标签管理
* @return
* @throws IOException
*/
public Locator 进入标签管理() throws IOException
 {
   Locator locator=getLocator("进入标签管理");
   return locator;
 }

/***
* 点击标签管理
* @return
* @throws IOException
*/
public Locator 点击标签管理() throws IOException
 {
   Locator locator=getLocator("点击标签管理");
   return locator;
 }

/***
* 进入手动标签列表
* @return
* @throws IOException
*/
public Locator 进入手动标签列表() throws IOException
 {
   Locator locator=getLocator("进入手动标签列表");
   return locator;
 }

/***
* 新建手动标签页面
* @return
* @throws IOException
*/
public Locator 新建手动标签页面() throws IOException
 {
   Locator locator=getLocator("新建手动标签页面");
   return locator;
 }

/***
* 输入标签名称
* @return
* @throws IOException
*/
public Locator 输入标签名称() throws IOException
 {
   Locator locator=getLocator("输入标签名称");
   return locator;
 }

/***
* 选择事件
* @return
* @throws IOException
*/
public Locator 选择事件() throws IOException
 {
   Locator locator=getLocator("选择事件");
   return locator;
 }

/***
* 选择分页3事件
* @return
* @throws IOException
*/
public Locator 选择分页3事件() throws IOException
 {
   Locator locator=getLocator("选择分页3事件");
   return locator;
 }

/***
* 选择标签样式
* @return
* @throws IOException
*/
public Locator 选择标签样式() throws IOException
 {
   Locator locator=getLocator("选择标签样式");
   return locator;
 }

/***
* 选择手动标签样式
* @return
* @throws IOException
*/
public Locator 选择手动标签样式() throws IOException
 {
   Locator locator=getLocator("选择手动标签样式");
   return locator;
 }

/***
* 标签描述
* @return
* @throws IOException
*/
public Locator 标签描述() throws IOException
 {
   Locator locator=getLocator("标签描述");
   return locator;
 }
}