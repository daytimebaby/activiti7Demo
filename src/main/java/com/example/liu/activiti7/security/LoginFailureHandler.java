package com.example.liu.activiti7.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("loginFailureHandler")
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        response.setStatus(500);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("登陆登陆失败loginSuccessHandler"+ exception.getMessage());
    }
}
