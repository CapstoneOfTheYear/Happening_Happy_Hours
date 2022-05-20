package com.capstone.happening_happy_hours.controllers;

import com.capstone.happening_happy_hours.models.User;
import com.capstone.happening_happy_hours.repositories.UserRepository;
import com.capstone.happening_happy_hours.services.EmailService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ForgotPasswordController {

    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;


    public ForgotPasswordController(UserRepository userDao, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @GetMapping("emailVerify")
    public String getEmail(Model model, User user) {
        model.addAttribute("user", user);
        return "emailVerify";
    }

    @PostMapping("emailVerify")
    public String sendEmail(@ModelAttribute User user) {
        emailService.prepareAndSend(user, "Reset Password", "Please click to reset your password: http://localhost:8080/changePassword?from=" + user.getEmail());
        return "redirect:/login";
    }


    @GetMapping("/changePassword")
    public String showForm(Model model, User user, @RequestParam(name = "from") String from) {
            User user1 = userDao.findUserByEmail(from);
            model.addAttribute("user", user1);
            return "/changePassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute User user, @RequestParam(name = "pswd") String pswd, @RequestParam(name = "pswdConfirm") String pswdConfirm) {
        User userUpdate = userDao.findByEmail(user.getEmail());
        if (pswd.equals(pswdConfirm)) {
            String hash = passwordEncoder.encode(pswd);
            userUpdate.setPassword(hash);
        }
        userDao.save(userUpdate);
        return "redirect:/login";
    }

}
