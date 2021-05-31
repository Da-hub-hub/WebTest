package com.supaur.framework.Sprint1.test;

import com.supaur.framework.seleniumTool.DriverGet;
import com.supaur.framework.seleniumTool.ElementGet;
import com.supaur.framework.utils.MyException;
import org.openqa.selenium.WebDriver;

public class NewTest {
    public static void main(String[] args) {
        WebDriver chromeDriver = DriverGet.getDriver("ChromeDriver");
        chromeDriver.get("https://www.baidu.com");
        ElementGet daskhdaj = new ElementGet(chromeDriver);
        try {
            daskhdaj.getElementById("ssssu").click();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
