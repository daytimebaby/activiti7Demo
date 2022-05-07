activiti7 整合Springboot

pom文件
        <dependency>
            <groupId>org.activiti</groupId>
            <artifactId>activiti-spring-boot-starter</artifactId>
            <version>7.1.0.M4</version>
        </dependency>
        <dependency>
            <groupId>org.activiti.dependencies</groupId>
            <artifactId>activiti-dependencies</artifactId>
            <version>7.1.0.M4</version>
            <type>pom</type>
        </dependency>


-------------------------------分割线------------------------------



appliction.properties 配置

#mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/oa?useSSL=true
spring.datasource.username=root
spring.datasource.password=123456

#activiti流程部署创建数据库表默认不创建加历史表 添加此配置后重新流程部署会创建历史表
#activiti 历史表创建
spring.activiti.history-level=full
spring.activiti.db-history-used=true

#自动部署 项目启动检查 bpmn文件
#activiti7 启动前会检查bmpn文件 设置为false关闭
spring.activiti.check-process-definitions=false

注意activiti 自动创建的表缺少两个字段这个是官方的问题 需要手动添加
-- ----------------------------
-- 修复Activiti7的M4版本缺失字段Bug
-- ----------------------------
alter table ACT_RE_DEPLOYMENT add column PROJECT_RELEASE_VERSION_ varchar(255) DEFAULT NULL;
alter table ACT_RE_DEPLOYMENT add column VERSION_ varchar(255) DEFAULT NULL;


-------------------------------分割线------------------------------



数据库添加user表（用户表）
因为查询候选人任务时activiti7需要安全框架的用户而activiti7m9没有带


-------------------------------分割线------------------------------

并行网关：将一路审批分开成多路最后合并，多用于一个审批需要多人审批
排他网关：流程按住逻辑与计算条件执行，当结果为true时进入下一个流程当为false时抛出异常，当
结果多个条件都满足，排他网关执行时顺序考前的网关

包容网关：能够添加条件的并行网关
事件网关：事件网关只能连接事件事件必须大于一件或两件

边界事件：
中间事件：
自流程：

