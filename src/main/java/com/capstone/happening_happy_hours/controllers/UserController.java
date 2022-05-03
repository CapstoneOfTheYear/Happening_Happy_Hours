package com.capstone.happening_happy_hours.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @GetMapping("/profile/user")
//    @ResponseBody
//    public String user() {
//        return "USER PAGE";
//    }
    public String userProfile() {
        return "userProfile";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
