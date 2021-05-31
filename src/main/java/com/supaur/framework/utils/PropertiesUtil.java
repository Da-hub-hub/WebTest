package com.supaur.framework.utils;

import java.util.ResourceBundle;
/*
* 配置文件中读取驱动的绝对路径
* */
public class PropertiesUtil {
    private static ResourceBundle resourceBundle;
        static {
            resourceBundle=ResourceBundle.getBundle("driverConfig");
        }

        public static String getVal(String key){
            return resourceBundle.getString(key);
        }
}
