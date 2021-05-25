import com.supaur.framework.action.LabelCreateAction;
import com.supaur.framework.action.LoginAction;
import com.supaur.framework.seleniumTool.TestBaseCase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;

public class CdpLoginTest extends TestBaseCase {

    @Test(description="新建标签测试")
    @Parameters({"BaseUrl"})//读取testng.xml参数
    public void login(String BaseUrl) throws IOException
    {
        //调用登录方法，输入正确的用户名和密码
        //LoginAction loginAction=new LoginAction(BaseUrl+"/overview/customer","15003970273" ,"Supaur2021!@#");

        //新建标签
        LabelCreateAction labelCreateAction = new LabelCreateAction(BaseUrl + "/overview/customer", "15003970273", "Supaur2021!@#", "手动标签1", "新建的第一个手动标签");
        /*//设置检查点
        Assertion.VerityTextPresentPrecision("jd_8456195","输入正确的用户名和密码，验证是否成功进入主页");
        //设置用例断言，判断用例是否失败
        Assertion.VerityError();*/
    }
    //数据驱动案例--start
    /*@DataProvider(name="longinData")
    public Object[][] loginData()
    {
        //读取登录用例测试数据
        String filePath="src/main/resources/data/loginData.xls";
        //读取第一个sheet，第2行到第5行-第2到第4列之间的数据
        return ExcelReadUtil.case_data_excel(0, 1, 4, 1, 3,filePath);
    }
    @Test(description="登录失败用例",dataProvider = "longinData")
    public void loginFail (String userName,String password,String message) throws IOException, DocumentException {
        //代替testng参数化的方法
        String BaseUrl= XmlReadUtil.getTestngParametersValue("testng.xml","BaseUrl");
        //调用登录方法
        LoginAction loginAction=new LoginAction(BaseUrl+"/new/login.aspx",userName,password);
        action.sleep(1);
        //设置检查点
        Assertion.VerityTextPresent(message,"验证是否出现预期的错误提示信息:"+message);
        //设置断言
        Assertion.VerityError();
    }
    //数据驱动案例--end*/

}
