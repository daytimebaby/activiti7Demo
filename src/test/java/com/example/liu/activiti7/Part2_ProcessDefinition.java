package com.example.liu.activiti7;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Liu Zelin
 * @Email: liuzelin@geek-zoo.coom
 * @Date: Create in 2022/4/19 10:03 PM
 */
@SpringBootTest
public class Part2_ProcessDefinition {

    @Autowired
    private RepositoryService repositoryService;


    //获取流程定义
    @Test
    public void getProcessDefinition(){
        List<ProcessDefinition> list =repositoryService.createProcessDefinitionQuery()
                .list();
        for(ProcessDefinition pd :list){
            System.out.println("-------------流程定义-----------------");
            System.out.println("Name："+pd.getName());
            System.out.println("Key："+pd.getKey());
            System.out.println("ResourceName："+pd.getResourceName());
            System.out.println("DeploymentId："+pd.getDeploymentId());
            System.out.println("Version："+pd.getVersion());

        }


    }
    //删除流程定义
    @Test
    public void delDefinition(){

        String pdID="4268853a-bfb3-11ec-bacf-56d0354b4d52";
        repositoryService.deleteDeployment(pdID,true);
        //deleteDeployment(String,boolean) 布尔值表示是否删除流程的历史记录 true 是 false 否 一般设置为false
        System.out.println("删除流程定义成功");

    }
}
