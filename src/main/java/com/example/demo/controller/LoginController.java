package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";  // 返回 login.html 頁面
    }
    @ResponseBody
    @GetMapping("/gg")
    public String getSession(HttpServletRequest request){
         User user = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal).map(User.class::cast).orElse(null);
        if(user==null){
            return "null";
        }
        return user.getUsername();
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";  // 返回 logout.html 頁面
    }

    @GetMapping("/login_success")
    public String loginSuccess(HttpServletRequest request) {
            return "loginSuccess";  // 返回 login_success.html 頁面
    }

    @GetMapping("/login_fail")
    public String loginFail() {
        return "loginFail";  // 返回 login_success.html 頁面
    }
}
