package com.example.liu.activiti7;

import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Liu Zelin
 * @Email: liuzelin@geek-zoo.coom
 * @Date: Create in 2022/4/25 5:20 PM
 */
@SpringBootTest
public class Part8_ProcessRuntime {

    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private SecurityUtil securityUtil;

    //获取流程实例子
    @Test
    void getProcessInstance() {

        securityUtil.logInAs("wukong");
        Page<ProcessInstance> processInstancePage =processRuntime.processInstances(Pageable.of(0,100));
        System.out.println("打印流程实例数量："+processInstancePage.getTotalItems());
        List<ProcessInstance> list =processInstancePage.getContent();

        for (ProcessInstance pi:list) {
            System.out.println("id："+pi.getId());
            System.out.println("name："+pi.getName());
            System.out.println("ProcessDefinitionId："+pi.getProcessDefinitionId());
            System.out.println("ProcessDefinitionKey："+pi.getProcessDefinitionKey());
            System.out.println("StartDate："+pi.getStartDate());
            System.out.println("Status："+pi.getStatus());

        }



    }


    //启动流程实例子
    @Test
    void startProcessInstance() {
        securityUtil.logInAs("wukong");
        ProcessInstance processInstance =processRuntime.
                start(ProcessPayloadBuilder.
                        start().
                        withProcessDefinitionKey("myProcess_ProcessRuntime").
                        withName("第一个流程实例名称").
                        //withVariable("",""),
                        withBusinessKey("自定义bkey").
                        build());



    }
    //删除流程实例子
    @Test
    void delProcessInstance() {


        securityUtil.logInAs("wukong");
        ProcessInstance processInstance =processRuntime.
                delete(ProcessPayloadBuilder.
                        delete().
                        withProcessInstanceId("35cf5144-c48b-11ec-9880-22633c9710b0").
                        build());

    }

    //挂起流程实例子
    @Test
    void suspendProcessInstance() {

        securityUtil.logInAs("wukong");
        ProcessInstance processInstance =processRuntime.suspend(ProcessPayloadBuilder.
                        suspend().
                        withProcessInstanceId("df446471-c148-11ec-93b0-56d0354b4d52").
                        build());


    }

    //激活流程实例子
    @Test
    void resumeProcessInstance() {

        securityUtil.logInAs("wukong");
        ProcessInstance processInstance =processRuntime.resume(ProcessPayloadBuilder.
                resume().
                withProcessInstanceId("df446471-c148-11ec-93b0-56d0354b4d52").
                build());

    }


}
