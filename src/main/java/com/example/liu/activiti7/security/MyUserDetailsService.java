package com.example.liu.activiti7.security;

import com.example.liu.activiti7.mapper.UserInfoBeanMapper;
import com.example.liu.activiti7.pojo.UserInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class MyUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserInfoBeanMapper userInfoBeanMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String passWord= passwordEncoder().encode("111");
        //没有做数据库校验
//        return new User(username,
//                passWord,
//                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ACTIVITI_USER"));
//

        //读取数据库判断用户
        //如果用户为null抛出异常
        //返回用户信息

        UserInfoBean userInfoBean =userInfoBeanMapper.selectByUsername(username);
        if (userInfoBean == null) {

            throw new UsernameNotFoundException("数据库中无此用户");
        }else {
            return  userInfoBean;
        }





    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
