package com.capstone.happening_happy_hours.controllers;


import com.capstone.happening_happy_hours.models.User;
import com.capstone.happening_happy_hours.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    private UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }


    @GetMapping("/profile/user")
//    @ResponseBody
//    public String user() {
//        return "USER PAGE";
//    }
    public String userProfile() {
        return "userProfile";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        userDao.save(user);
        return "redirect:/login";
    }
}
