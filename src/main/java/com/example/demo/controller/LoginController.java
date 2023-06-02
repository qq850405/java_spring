package com.example.demo.controller;

import com.example.demo.repo.UserRepository;
import com.example.demo.service.MailService;
import com.example.demo.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class LoginController {
    private final UserServiceImpl userServiceImpl;

    public LoginController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

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

    @GetMapping("/send_verify")
    public String send_verify() {
        User user = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal).map(User.class::cast).orElse(null);

        if (user == null) {
            return "login";
        }
        try {
            //random number
            int verifyCode = (int) ((Math.random() * 9 + 1) * 10000);
            MailService mailService = new MailService();
            mailService.sendMail(user.getUsername(), "test", String.valueOf(verifyCode));

            userServiceImpl.setVerifyCode(user.getUsername(), String.valueOf(verifyCode));
        } catch (Exception e) {
            e.printStackTrace();
        }
            //update verify code


        return "verify";  // 返回 verify.html 頁面

    }


    @GetMapping("/show_verify")
    public String showVerify() {
        return "verify";  // 返回 verify.html 頁面
    }
    @PostMapping("/verify")
    public String verify(@RequestParam("code") String code) {
        try {
            User user = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                    .map(Authentication::getPrincipal).map(User.class::cast).orElse(null);
            userServiceImpl.checkVerifyCode(user.getUsername(), code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "verifySuccess";  // 返回 verify.html 頁面
    }
}
