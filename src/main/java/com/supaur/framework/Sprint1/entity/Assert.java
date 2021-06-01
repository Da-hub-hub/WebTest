package com.supaur.framework.Sprint1.entity;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
})
public class Assert {
    @XmlAttribute(name = "value", required = false)
    protected String value;
    @XmlAttribute(name = "type", required = false)
    public String type;
    @XmlAttribute(name = "desc", required = false)
    public String desc;
    @XmlAttribute(name = "attribute", required = false)
    public String attribute;
    @XmlAttribute(name = "expectValue", required = false)
    public String expectValue;

    @Override
    public String toString() {
        return "Assert{" +
                "value='" + value + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", attribute='" + attribute + '\'' +
                ", expectValue='" + expectValue + '\'' +
                '}';
    }

    public String getExpectValue() {
        return expectValue;
    }

    public void setExpectValue(String expectValue) {
        this.expectValue = expectValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

}
