package com.supaur.springboot.service;


import org.springframework.stereotype.Service;
import org.testng.TestNG;
import org.testng.xml.SuiteXmlParser;
import org.testng.xml.XmlSuite;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestCaseRunService {
    public void executeTestCase(String casePath){
        String xmlName = "testng.xml";
        InputStream inputStream = TestCaseRunService.class.getClassLoader().getResourceAsStream(xmlName);
        TestNG testNG = new TestNG();
        SuiteXmlParser suiteXmlParser = new SuiteXmlParser();
        List<XmlSuite> suites = new ArrayList<>();
        XmlSuite xmlSuite = suiteXmlParser.parse(xmlName, inputStream, true);
        suites.add(xmlSuite);
        Map<String,String> parameters = new HashMap<>();
        //TODO  springboot框架搭建时，接口所需的参数，xml的存放地址，如果部署在oss上，需增加ossUtils类

        parameters.put("path", casePath);

        parameters.put("driver","ChromeDriver");
        xmlSuite.setParameters(parameters);
        testNG.setXmlSuites(suites);
        testNG.run();
    }

}
