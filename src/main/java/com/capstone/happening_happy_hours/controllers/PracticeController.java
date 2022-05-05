package com.capstone.happening_happy_hours.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PracticeController {
    @GetMapping("/practice")
    public String mapboxAPI() {
        return "practice";
        }

}
