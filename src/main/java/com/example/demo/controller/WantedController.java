package com.example.demo.controller;

import com.example.demo.entity.Wanted;
import com.example.demo.service.UserService;
import com.example.demo.service.WantedService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class WantedController {

    private final WantedService wantedService;

    @Autowired
    public WantedController(WantedService wantedService) {
        this.wantedService = wantedService;
    }

    @GetMapping("/wanted")
    public String show() {
        return "wanted";
    }
    @PostMapping("/wanted_action")
    public String insert(
        @RequestParam("subject") String subject,
        @RequestParam("location") String location,
        @RequestParam("num_students") String num_students,
        @RequestParam("period") String period,
        @RequestParam("salary") Integer salary,
        @RequestParam("content") String content){
        User user = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal).map(User.class::cast).orElse(null);
            Wanted wanted = new Wanted();
            wanted.setMid(user.getUsername());
            wanted.setSubject(subject);
            wanted.setLocation(location);
            wanted.setNum_students(num_students);
            wanted.setPeriod(period);
            wanted.setSalary(salary);
            wanted.setContent(content);

        try {        // 调用UserService中的注册方法
            wantedService.createWanted(wanted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "wanted";
    }
}
