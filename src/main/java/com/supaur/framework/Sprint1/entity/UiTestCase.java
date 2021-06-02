package com.supaur.framework.Sprint1.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
        "testcase"
})
@XmlRootElement(name = "Uitestcase")
public class UiTestCase {
    public TestCase testcase;

    public TestCase getTestCase() {
        return testcase;
    }

    public void setTestCase(TestCase testcase) {
        this.testcase = testcase;
    }

    @Override
    public String toString() {
        return "Uitestcase{" +
                "testCase=" + testcase +
                '}';
    }
}
