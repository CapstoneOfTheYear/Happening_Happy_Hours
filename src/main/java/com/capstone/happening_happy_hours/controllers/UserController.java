package com.capstone.happening_happy_hours.controllers;


import com.capstone.happening_happy_hours.models.Business;
import com.capstone.happening_happy_hours.models.User;
import com.capstone.happening_happy_hours.repositories.BusinessRepository;
import com.capstone.happening_happy_hours.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserRepository userDao;
    private BusinessRepository businessDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, BusinessRepository businessDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.businessDao = businessDao;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/profile/user/{username}")
//    @ResponseBody
//    public String user() {
//        return "USER PAGE";
//    }
    public String userProfile(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
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
            businessDao.save(business);
        }
        return "redirect:/login";
    }
}
