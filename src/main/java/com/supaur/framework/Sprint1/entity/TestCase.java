package com.supaur.framework.Sprint1.entity;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "test"
})
//@XmlRootElement(name = "testcase")
public class TestCase {
    @XmlAttribute(name = "url", required = true)
    protected String url;
    protected List<Test> test;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Test> getTest() {
        return test;
    }

    public void setTest(List<Test> test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "url='" + url + '\'' +
                ", test=" + test +
                '}';
    }
}
