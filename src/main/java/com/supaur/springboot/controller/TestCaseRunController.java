package com.supaur.springboot.controller;

import com.supaur.framework.Sprint1.baseEntity.Response2;
import com.supaur.framework.Sprint1.testReport.TestResult;
import com.supaur.springboot.service.TestCaseRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Testcase")
public class TestCaseRunController {
    @Autowired
    TestCaseRunService testCaseRun;
    @GetMapping("/run")
    public Response2 runTestCase(@RequestParam(value = "casePath", required = true) String casePath){
        testCaseRun.executeTestCase(casePath);
        if (TestResult.result){
            return Response2.yes("执行成功");
        }else {
            return Response2.no("执行失败");
        }


    }
}
