package com.capstone.happening_happy_hours.controllers;

import com.capstone.happening_happy_hours.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final BusinessRepository businessRepository;

    @Value("${mapbox.api.key}")
    private String apiKey;

    public HomeController(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("apiKey", apiKey);
        model.addAttribute("business", businessRepository.findAll());
        return "home";
    }

}
