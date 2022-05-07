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
 * @Date: Create in 2022/4/22 4:05 PM
 */
@SpringBootTest
public class Part7_Gateway {



    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;



    @Test
    void initProcessInstanceWithArgs() {
        ProcessInstance processInstance =runtimeService.startProcessInstanceByKey("myProcess_inclusive","bKey001");
        System.out.println("流程实例ID："+processInstance.getProcessDefinitionId());


    }

    @Test
    void completeTask() {

        //流程实例：969ce449-c24c-11ec-b520-22633c9710b0
        //悟空：155784c4-c24d-11ec-9f57-22633c9710b0
        //沙僧：155784c2-c24d-11ec-9f57-22633c9710b0

        taskService.complete("1557abd6-c24d-11ec-9f57-22633c9710b0");

//        taskService.complete("155784c4-c24d-11ec-9f57-22633c9710b0");
//        taskService.complete("155784c2-c24d-11ec-9f57-22633c9710b0");

        System.out.println("完成任务");

    }
}
