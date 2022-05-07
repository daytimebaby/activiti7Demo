package com.example.liu.activiti7;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Liu Zelin
 * @Email: liuzelin@geek-zoo.coom
 * @Date: Create in 2022/4/20 2:10 PM
 */
@SpringBootTest
public class Part4_Task {


    @Autowired
    private TaskService taskService;


    //任务查询

    @Test
    public void getTasks(){
        List<Task> list =taskService.createTaskQuery().list();
        for (Task task:list){
            System.out.println("Id："+task.getId());
            System.out.println("Name："+task.getName());
            System.out.println("Assignee："+task.getAssignee());
//            System.out.println("："+task.ge);
        }
    }
    //查询自己的任务
    @Test
    public void getTaskByAssignee(){
        List<Task> list =taskService.createTaskQuery()
                .taskAssignee("bajie")
                .list();
        for (Task task:list){
            System.out.println("Id："+task.getId());
            System.out.println("Name："+task.getName());
            System.out.println("Assignee："+task.getAssignee());
        }
    }

    //执行任务
    @Test
    public void completeTask(){

        taskService.complete("4a65bd5e-c0c3-11ec-b5f6-56d0354b4d52");
        System.out.println("完成任务");

    }
    //拾取任务
    @Test
    public void claimTask(){
//        74ab4515-c16d-11ec-a7da-56d0354b4d52
        Task task=taskService.createTaskQuery().taskId("4a65bd5e-c0c3-11ec-b5f6-56d0354b4d52").singleResult();
        taskService.claim("4a65bd5e-c0c3-11ec-b5f6-56d0354b4d52","bajie");
    }

    //归还与交办任务
    @Test
    public void setTaskAssignee(){
        Task task=taskService.createTaskQuery().taskId("4a65bd5e-c0c3-11ec-b5f6-56d0354b4d52").singleResult();
        taskService.setAssignee("4a65bd5e-c0c3-11ec-b5f6-56d0354b4d52","null");//归还候选任务
        taskService.setAssignee("4a65bd5e-c0c3-11ec-b5f6-56d0354b4d52","wukong");//交办候选任务


    }
}
