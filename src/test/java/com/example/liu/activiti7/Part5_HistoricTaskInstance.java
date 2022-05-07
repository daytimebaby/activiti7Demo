package com.example.liu.activiti7;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Liu Zelin
 * @Email: liuzelin@geek-zoo.coom
 * @Date: Create in 2022/4/21 12:23 PM
 */
@SpringBootTest
public class Part5_HistoricTaskInstance {


    @Autowired
    private HistoryService historyService;

    //根据用户名查询历史记录
    @Test
    public void HistoricTaskInstanceByUser(){
        List<HistoricTaskInstance> list =historyService.createHistoricTaskInstanceQuery()
                .orderByHistoricTaskInstanceEndTime().asc()
                .taskAssignee("bajie")
                .list();
        for(HistoricTaskInstance ht:list){
            System.out.println("Id："+ht.getId());
            System.out.println("ProcessInstanceId："+ht.getProcessInstanceId());
            System.out.println("Name："+ht.getName());

        }


    }

    //根据流程实例ID查询历史
    @Test
    public void HistoricTaskInstanceByPID(){
        List<HistoricTaskInstance> list =historyService.createHistoricTaskInstanceQuery()
                .orderByHistoricTaskInstanceEndTime().asc()
                .processInstanceId("349b2396-c0a2-11ec-8f78-56d0354b4d52")
                .list();
        for(HistoricTaskInstance ht:list){
            System.out.println("Id："+ht.getId());
            System.out.println("ProcessDefinitionId："+ht.getProcessDefinitionId());
            System.out.println("Name："+ht.getName());

        }



    }
}
