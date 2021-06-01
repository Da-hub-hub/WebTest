package com.supaur.framework.Sprint1;

import com.supaur.framework.Sprint1.entity.TestCase;
import com.supaur.framework.utils.JaxbUtil;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class RunTest {
    //Test.xml测试用例 进行自动执行
    /**
     * 测试用
    * */
    @Test
    public void run() throws JAXBException, IOException {
        String xmlPath =  "E:\\study\\WebTest\\src\\main\\java\\com\\supaur\\framework\\Sprint1\\TestCase.xml";
        Object object = JaxbUtil.xmlToBean(xmlPath, TestCase.class);
        //获取测试用例中testcase对象
        TestCase testCase = (TestCase)object;
        //System.out.println(testCase);
        //testcase转换成可执行对象


    }

}
