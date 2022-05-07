package com.example.liu.activiti7;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Liu Zelin
 * @Email: liuzelin@geek-zoo.coom
 * @Date: Create in 2022/4/21 2:05 PM
 */
@SpringBootTest
public class Part6_UEL {


    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;


    //启动流程实例带参数，执行执行人
    @Test
    void initProcessInstanceWithArgs() {

        //流程变量
        Map<String, Object> variables = new HashMap<>();
        variables.put("zhixingren", "wukong");

        ProcessInstance processInstance = runtimeService.
                startProcessInstanceByKey(
                        "myProcess_UEL_V1",
                        "bKey001",
                        variables);
        System.out.println("流程实例ID：" + processInstance.getProcessInstanceId());


    }

    //完成任务带参数
    @Test
    void completeTaskWithArgs() {
//        df4af425-c148-11ec-93b0-56d0354b4d52
        //        //流程变量
        Map<String, Object> variables = new HashMap<>();
        variables.put("pay", "101");
        taskService.complete("8f9ecb93-c16c-11ec-9180-56d0354b4d52",variables);
        System.out.println("完成任务");

    }



    //启动流程实例带参数，使用实体类
    @Test
    void initProcessInstanceWithClassArgs() {
        UEL_POJO uel_pojo =new UEL_POJO();
        uel_pojo.setZhixingren("bajie");

        //流程变量
        Map<String, Object> variables = new HashMap<>();
        variables.put("uelpojo", uel_pojo);

        ProcessInstance processInstance = runtimeService.
                startProcessInstanceByKey(
                        "myProcess_uelv3",
                        "bKey001",
                        variables);
        System.out.println("流程实例ID：" + processInstance.getProcessInstanceId());


    }

    //完成任务，指定多个候选人
    @Test
    void initProcessInstanceWithCandiDateArgs() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("houxuanren", "wukong,tangseng");
        taskService.complete("8f9ecb93-c16c-11ec-9180-56d0354b4d52",variables);
        System.out.println("完成任务");

    }

    //直接指定流程变量
    @Test
    void otherArgs() {
        runtimeService.setVariable("8f9ecb93-c16c-11ec-9180-56d0354b4d52","pay","101");
//        runtimeService.setVariables();
//        taskService.setVariable();
//        taskService.setVariables();
    }

    //局部变量
    @Test
    void otherLocalArgs() {
        runtimeService.setVariableLocal("8f9ecb93-c16c-11ec-9180-56d0354b4d52","pay","101");
//        runtimeService.setVariablesLocal();
//        taskService.setVariable();
//        taskService.setVariables();

    }


}
