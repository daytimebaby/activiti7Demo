package com.example.liu.activiti7;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * @Author: Liu Zelin
 * @Email: liuzelin@geek-zoo.coom
 * @Date: Create in 2022/4/19 3:30 PM
 */

@SpringBootTest
public class Part1_Deployment {


    @Autowired
    private RepositoryService repositoryService;

    //通过bpmn部署流程
    @Test
    public void initDeploymentBPMN(){
//        String fileName="BPMN/part1_Deployment.bpmn";
//        String fileName="BPMN/part4_Task.bpmn";
//        String fileName="BPMN/part4_Task_claim.bpmn";
//        String fileName="BPMN/part6_UEL_V1.bpmn";
//        String fileName="BPMN/part6_UEL_V2.bpmn";
//        String fileName="BPMN/part6_UEL_V3.bpmn";
//        String fileName="BPMN/part7_Parallel.bpmn";
//        String fileName="BPMN/part7_Exclusive.bpmn";
//        String pngName="BPMN/part1_Deployment.png";
        String fileName="BPMN/part8_ProcessRuntime.bpmn";
        Deployment deployment =repositoryService.createDeployment()
                .addClasspathResource(fileName)
//                .addClasspathResource(pngName)
                .name("包含网关BPMN")
                .deploy();
        System.out.println(deployment.getName());

    }

    //通过zip部署流程
    @Test
    public void initDeploymentZip(){
        String zipName="BPMN/part1_Deployment_v2.zip";
        InputStream inputStream =this.getClass()
                .getClassLoader()
                .getResourceAsStream(zipName);
        ZipInputStream zipInputStream =new ZipInputStream(inputStream);
        Deployment deployment= repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("流程部署测试zip")
                .deploy();
        System.out.println(deployment.getName());

    }

    //通过流程部署
    @Test
    public  void getDeployments(){
        List<Deployment> list= repositoryService.createDeploymentQuery().list();
        for (Deployment dep:list){
            System.out.println("id："+dep.getId());
            System.out.println("name："+dep.getName());
            System.out.println("deploymentDate："+dep.getDeploymentTime());
            System.out.println("key："+dep.getKey());

        }

    }




}
