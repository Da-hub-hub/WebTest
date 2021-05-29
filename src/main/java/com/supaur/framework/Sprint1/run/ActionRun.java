package com.supaur.framework.Sprint1.run;

import com.supaur.framework.Sprint1.ElementLocator;
import com.supaur.framework.Sprint1.entity.TestCase;
import com.supaur.framework.seleniumTool.DriverGet;
import com.supaur.framework.utils.JaxbUtil;
import com.supaur.framework.utils.Log;
import org.openqa.selenium.WebDriver;
import org.springframework.core.io.ClassPathResource;
import org.testng.annotations.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;

@Listeners(com.supaur.framework.Sprint1.testReport.TestResult.class)
public class ActionRun {
    public String path;
    public String url;
    public TestCase testCase;
    public static WebDriver driver;
    //方法描述
    public static String description;
    public Log log = new Log(this.getClass().getSuperclass());

    public ActionRun() {
    }

    public List<ElementLocator> lsit;


    @Parameters({"path"})
    @BeforeTest
    public void getPath(String path) {
        this.path = path;
        log.info("测试用例路径已获取："+this.path);
    }


    @BeforeTest
    //解析xml文件获取testcase对象
    public TestCase getTestCase() throws JAXBException, IOException {
        //用例指明绝对路径，执行
        /*Object object=JaxbUtil.xmlToBean(path,TestCase.class);
        this.testCase = (TestCase) object;
        log.info("测试用例已获取："+this.testCase);
        return testCase;*/
        /*
        * 用例放在类路径下，获取输入流，进行执行
        * */
        ClassPathResource classPathResource = new ClassPathResource(path);
        InputStream inputStream1 = classPathResource.getInputStream();
        Object object = JaxbUtil.xmlToBean(inputStream1, TestCase.class);
        this.testCase = (TestCase) object;
        log.info("测试用例已获取："+this.testCase);
        return testCase;
    }

    @BeforeTest
    public void getUrl1() {
        //当前testCase的url，也是driver的入参
        this.url = testCase.getUrl();
        log.info("测试页面url已获取："+this.url);
    }


    @BeforeTest
    @Parameters({"driver"})
    public void setup(String driver) throws MalformedURLException, InterruptedException {
        log.info("------------------开始执行测试---------------");
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
        }

    }


    @Test
    public void UiTest() throws InterruptedException {
        new CaseRun(driver,testCase).execute();
        Thread.sleep(3000);
    }



    @AfterTest
    public void tearDown() {
        this.driver.close();
        this.driver.quit();
        log.info("-------------结束测试，并关闭退出浏览器-------------");
    }

    /**
     * 根据配置文件的driver名称，设置对应的驱动
     */
    private WebDriver setDriver(String browsername)
    {

        return DriverGet.getDriver(browsername);
    }





}




