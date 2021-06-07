package com.supaur.framework.Sprint1.run;

import com.supaur.framework.Sprint1.ElementLocator;
import com.supaur.framework.Sprint1.entity.TestCase;
import com.supaur.framework.Sprint1.entity.UiTestCase;
import com.supaur.framework.Sprint1.test.NewTest;
import com.supaur.framework.seleniumTool.DriverGet;
import com.supaur.framework.testCaseRun.TestCaseRun;
import com.supaur.framework.utils.Log;
import com.supaur.framework.utils.MyException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ActionRun2 {
    public List<String> pathList;
    public List<String > urlList;
    public List<TestCase> testCaseList;
    public WebDriver driver;
    //方法描述
    public static String description;
    public Log log = new Log(this.getClass().getSuperclass());

    public ActionRun2() {
    }

    public List<ElementLocator> lsit;


    @Parameters({"path"})
    @BeforeTest
    public void getPath(String path) {
        String[] split = path.split(";");
        //测试用例路径list集合
        this.pathList=Arrays.asList(split);
        log.info("测试用例路径集合已获取："+this.pathList);
    }


/*    @BeforeTest
    //解析xml文件获取testcase对象
    public TestCase getTestCase() throws JAXBException, IOException {
        //用例指明绝对路径，执行
        *//*Object object=JaxbUtil.xmlToBean(path,TestCase.class);
        this.testCase = (TestCase) object;
        log.info("测试用例已获取："+this.testCase);
        return testCase;*//*
        ClassPathResource classPathResource = new ClassPathResource(path);
        InputStream inputStream1 = classPathResource.getInputStream();
        Object object = JaxbUtil.xmlToBean(inputStream1, TestCase.class);
        this.testCase = (TestCase) object;
        log.info("测试用例已获取："+this.testCase);
        return testCase;
    }*/

    @BeforeTest
    //解析xml文件获取testcaseList对象
    public void getTestCase() throws Exception {
        /*UiTestCase uiTestCase = UiTestU.convertXmlToSuite(path);
        this.testCase = uiTestCase.getTestCase();
        log.info("测试用例已获取："+this.testCase);
        return testCase;*/
        this.testCaseList=NewTest.test(pathList);
    }

 /*   @BeforeTest
    public void getUrl1() {
        //当前testCase的url，也是driver的入参
        for (TestCase testCase:testCaseList){
            this.urlList.add(testCase.getUrl());
        }
        log.info("测试页面urlList已获取："+this.urlList);
    }
*/
    @DataProvider(name = "testcase")
    public Iterator<Object[]> getTest(){

        return new TestcaseGet(testCaseList).dp1();

    }
    @Test(dataProvider = "testcase")
    public void testProvider(TestCase testCase) throws MyException {
        this.driver.get(testCase.getUrl());
        this.driver.manage().window().maximize();
        new TestCaseRun(driver,testCase).execute();

    }



    @BeforeTest
    @Parameters({"driver"})
    public void setup(String driver) throws MalformedURLException, InterruptedException {
        this.driver = setDriver(driver);
        /*log.info("------------------开始执行测试---------------");
        if (url.equals("") || url.isEmpty()) {
            log.info("读取testng.xml配置的" + driver + "浏览器并将其初始化\n");
            try {
                this.driver = setDriver(driver);
            } catch (Exception e) {
                log.error("没有成功浏览器环境配置错误");
                e.printStackTrace();
            }
            System.out.println(url);
            this.driver.manage().window().maximize();
        } else {
            try {
                this.driver = setDriver(driver);
                log.info("浏览器驱动已获取:"+this.driver);
            } catch (Exception e) {
                // TODO: handle exception
                log.error("没有成功浏览器环境配置错误");
            }

            this.driver.get(url);
            this.driver.manage().window().maximize();
            log.info("已进入测试页面");
            //此处睡眠视为了打开浏览器，加载页面元素，否则test的方法找不到页面元素，无法执行
            Thread.sleep(1000);
        }*/

    }


/*    @Test
    public void UiTest() throws InterruptedException, MyException {
        //new CaseRun(driver,testCase).execute();
        new TestCaseRun(driver,testCase).execute();
        //Thread.sleep(3000);
    }*/



    @AfterTest
    public void tearDown() {
        this.driver.close();
        this.driver.quit();
        log.info("-------------结束测试，并关闭退出浏览器-------------");
    }




    private WebDriver setDriver(String browsername)
    {

        return DriverGet.getDriver(browsername);
    }

}
