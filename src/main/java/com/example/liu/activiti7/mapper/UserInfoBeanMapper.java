package com.example.liu.activiti7.mapper;

import com.example.liu.activiti7.pojo.UserInfoBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserInfoBeanMapper  {


    //generator

    @Select(" select * from user where username =#{username}")
    UserInfoBean selectByUsername(@Param("username")String username);

}
