package com.capstone.happening_happy_hours.controllers;

import com.capstone.happening_happy_hours.models.User;
import com.capstone.happening_happy_hours.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ForgotPasswordController {

    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;

    public ForgotPasswordController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/changePassword")
    public String showForm() {
        return "changePassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam(name = "email") String email, @RequestParam(name = "pswd") String pswd, @RequestParam(name = "pswdConfirm") String pswdConfirm) {
        User user = userDao.findUserByEmail(email);
        if (pswd.equals(pswdConfirm)) {
            String hash = passwordEncoder.encode(pswd);
            user.setPassword(hash);
        }
        userDao.save(user);
        return "redirect:/login";
    }

}
