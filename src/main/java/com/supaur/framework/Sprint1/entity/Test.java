package com.supaur.framework.Sprint1.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "test", propOrder = {
        "asserts"
})
public class Test{
    protected List<Assert> asserts;
    @XmlAttribute(name = "param", required = true)
    protected String  param;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "value", required = true)
    protected String value;
    @XmlAttribute(name = "timeout", required = true)
    protected String  timeout;
    @XmlAttribute(name = "name", required = true)
    protected String  name;
    @XmlAttribute(name = "desc", required = false)
    protected String  desc;
    @XmlAttribute(name = "operator", required = true)
    protected String  operator;
    @XmlAttribute(name = "handle",required = false)
    protected  String  handle;



    @Override
    public String toString() {
        return "Test{" +
                "param='" + param + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", timeout='" + timeout + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", operator='" + operator + '\'' +
                ", handle='" + handle + '\'' +
                ", asserts=" + asserts +
                '}';
    }

    public String getHandle() {
        return handle;
    }

    public List<Assert> getAsserts() {
        return asserts;
    }

    public void setAsserts(List<Assert> asserts) {
        this.asserts = asserts;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }


    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



    //为type设置默认值，如果xml中未解析出对应Bytype时，自动赋值为“xpath”
    public String getType() {
        if ("".equals(type) || type==null){
            return "xpath";
        }
        return type;
    }

    public void setType(String type) {
        this.type = type==null ? null : type.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String  getTimeout() {
        return timeout;
    }

    public void setTimeout(String  timeout) {
        this.timeout = timeout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
