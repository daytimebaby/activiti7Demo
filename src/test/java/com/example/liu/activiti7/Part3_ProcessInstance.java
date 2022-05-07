package com.example.liu.activiti7;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Liu Zelin
 * @Email: liuzelin@geek-zoo.coom
 * @Date: Create in 2022/4/19 10:34 PM
 */
@SpringBootTest
public class Part3_ProcessInstance {

    @Autowired
    private RuntimeService runtimeService;

    //初始化流程实例
    @Test
    public void initProcessIntstance(){
        //1， 获取页面表单填报的内容，请假时间，请假事由，String fromData
        //2，fromData 写入业务表，返回业务表主键ID==businessKey
        //3,把业务数据与Activiti7流程数据关联
        ProcessInstance processInstance =runtimeService.startProcessInstanceByKey("myProcess_uelv3","bKey001");
        System.out.println("流程实例ID："+processInstance.getProcessDefinitionId());
    }

    //获取流程实例
    @Test
    public void getProcessIntstances(){


        List<ProcessInstance> list =runtimeService.createProcessInstanceQuery().list();
        for (ProcessInstance pi:list){
            System.out.println("ProcessInstanceId："+pi.getProcessInstanceId());
            System.out.println("ProcessDefinitionId："+pi.getProcessDefinitionId());
            System.out.println("isEnded："+pi.isEnded());
            System.out.println("isSuspended："+pi.isSuspended());
        }
    }



    //挂起与激活流程实例
    @Test
    public void stopAndStartProcessIntstances(){
//        runtimeService.suspendProcessInstanceById("3f5628b5-bff0-11ec-8c60-56d0354b4d52");
//        System.out.println("挂起流程实例");
        runtimeService.activateProcessInstanceById("3f5628b5-bff0-11ec-8c60-56d0354b4d52");
        System.out.println("激活流程实例");
    }

    //删除流程实例
    @Test
    public void delProcessIntstances(){

        runtimeService.deleteProcessInstance("3f5628b5-bff0-11ec-8c60-56d0354b4d52","删除");
    }

}
