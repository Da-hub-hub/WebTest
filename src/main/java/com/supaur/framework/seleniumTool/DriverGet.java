package com.supaur.framework.seleniumTool;

import com.supaur.framework.utils.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * @Auther 齐传扬
 * @Date  2021/5/25
 * 获取驱动的工具类
 */
public class DriverGet {

        public  static WebDriver getDriver(String driverName){
              WebDriver driver;
              /*
              * jar包方式执行需要指定这里驱动的位置，否则无法执行
              * */
            switch (driverName){
                case "FirefoxDriver":
                    System.setProperty("webdriver.firefox.driver", PropertiesUtil.getVal("FirefoxDriver"));
                     driver=new FirefoxDriver();
                    break;
                case "ChromeDriver":
                    System.setProperty("webdriver.chrome.driver", PropertiesUtil.getVal("ChromeDriver"));
                    driver=new ChromeDriver();
                    break;
                default:
                    driver=new ChromeDriver();
                    break;
            }
            return driver;
            }
        }

