package com.capstone.happening_happy_hours.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BusinessController {
    @GetMapping("/business")
    @ResponseBody
    public String businessProfile() {
        return "It's here";
    }
}
