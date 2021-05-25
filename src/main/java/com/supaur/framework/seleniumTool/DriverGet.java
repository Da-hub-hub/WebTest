package com.supaur.framework.seleniumTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @Auther qichuanyang
 * @Date  2021/5/25
 * 获取驱动的工具类
 */
public class DriverGet {

        public  static WebDriver getDriver(String driverName){
              WebDriver driver;
            switch (driverName){
                case "FirefoxDriver":
                    System.setProperty("webdriver.firefox.driver", "src\\main\\resources\\geckodriver.exe");
                     driver=new FirefoxDriver();
                    break;
                case "ChromeDriver":
                    System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                    driver=new ChromeDriver();
                    break;
                case "InternetExplorerDriver":
                    System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
                    DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
                    dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    dc.setCapability("ignoreProtectedModeSettings", true);
                    driver=new InternetExplorerDriver(dc);
                    break;
                case "HtmlUnitDriver":
                    driver=new HtmlUnitDriver();
                    break;
                default:
                    driver=new FirefoxDriver();
                    break;
            }
            return driver;
            }
        }

