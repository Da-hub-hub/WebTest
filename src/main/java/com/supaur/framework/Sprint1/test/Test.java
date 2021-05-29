package com.supaur.framework.Sprint1.test;

import org.testng.TestNG;
import org.testng.xml.SuiteXmlParser;
import org.testng.xml.XmlSuite;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String xmlName = "testng.xml";
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream(xmlName);
        TestNG testNG = new TestNG();
        SuiteXmlParser suiteXmlParser = new SuiteXmlParser();
        List<XmlSuite> suites = new ArrayList<>();
        XmlSuite xmlSuite = suiteXmlParser.parse(xmlName, inputStream, true);
        suites.add(xmlSuite);
        Map<String,String> parameters = new HashMap<>();


        //parameters.put("path", "E:\\WebTest\\src\\main\\java\\com\\supaur\\framework\\Sprint1\\TestCase.xml");
        //类路径下
        parameters.put("path","testcase/TestCase.xml");

        parameters.put("driver","ChromeDriver");
        xmlSuite.setParameters(parameters);
        testNG.setXmlSuites(suites);
        testNG.run();
    }
    }


