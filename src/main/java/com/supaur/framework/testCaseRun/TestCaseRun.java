package com.supaur.framework.testCaseRun;

import com.supaur.framework.Sprint1.entity.Test;
import com.supaur.framework.Sprint1.entity.TestCase;
import com.supaur.framework.seleniumTool.ElementGet;
import com.supaur.framework.seleniumTool.ElementOperation;
import com.supaur.framework.utils.MyException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class TestCaseRun {
    public WebDriver driver;
    public TestCase testCase;
    public TestCaseRun(WebDriver driver,TestCase testCase){
        this.driver=driver;
        this.testCase=testCase;
    }
    public ElementGet elementGet;
    public void execute() throws MyException {
        List<Test> tests = testCase.getTest();
        for (Test test:tests){
                new ElementOperation(test,driver).execute();
            }
        }
    }
