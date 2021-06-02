package com.supaur.framework.utils;

import com.supaur.framework.Sprint1.entity.UiTestCase;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UiTestU {

    public static UiTestCase convertXmlToSuite(String path) throws
            Exception{
        SAXReader saxReader = new SAXReader();
        Document document = null;
        InputStream stream = null;
        UiTestCase uiTestCase = null;

        document = saxReader.read(path);
        stream = new ByteArrayInputStream(document.asXML().getBytes("utf-8"));
        uiTestCase = JaxbUtil.getObjectFromXml(stream, UiTestCase.class);
        return uiTestCase;

    }
}
