package com.capstone.happening_happy_hours.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

//    @Value("${mapbox.api.key}")
//    private String mapKey;
//
//
//    public String getMapKey() {
//        return mapKey;
//    }
//
//    public void setMapKey(String mapKey) {
//        this.mapKey = mapKey;
//    }
//}
