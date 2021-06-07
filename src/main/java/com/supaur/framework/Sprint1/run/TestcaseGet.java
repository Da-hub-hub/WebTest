package com.supaur.framework.Sprint1.run;

import com.supaur.framework.Sprint1.entity.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestcaseGet {
    List<TestCase> testCaseList;
    public TestcaseGet(List<TestCase> testCaseList){
        this.testCaseList=testCaseList;
    }
    public Iterator<Object[]> dp1(){
        List<Object[]> objects = new ArrayList<>();
        for (Object u:testCaseList){
            objects.add(new Object[]{u});
        }
        return objects.iterator();

    }
}
