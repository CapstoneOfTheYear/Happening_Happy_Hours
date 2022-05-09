package com.capstone.happening_happy_hours.controllers;


import com.capstone.happening_happy_hours.models.Business;
import com.capstone.happening_happy_hours.models.User;
import com.capstone.happening_happy_hours.repositories.BusinessRepository;
import com.capstone.happening_happy_hours.repositories.ReviewRepository;
import com.capstone.happening_happy_hours.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserRepository userDao;
    private BusinessRepository businessDao;
    private ReviewRepository reviewDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, BusinessRepository businessDao, ReviewRepository reviewDao,PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.businessDao = businessDao;
        this.reviewDao = reviewDao;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/profile/user")
//
    public String userProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("User", user);
        model.addAttribute("reviews", reviewDao.findAllByUserId(user.getId()));
        model.addAttribute("businesses", businessDao.findAll());
        return "userProfile";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("business", new Business());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user, @ModelAttribute Business business) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        if (user.getOwnsBusiness()) {
            user.setBusinesses(business);
            businessDao.save(business);
        }
        return "redirect:/login";
    }
}
