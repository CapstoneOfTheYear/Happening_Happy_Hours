package com.capstone.happening_happy_hours.controllers;

import com.capstone.happening_happy_hours.models.User;
import com.capstone.happening_happy_hours.repositories.UserRepository;
import com.capstone.happening_happy_hours.services.EmailService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    //TODO: In the body change =>
    // http://localhost:8080/ use for non-deployed changes
    // use http://happeninghappyhours.com/ for deployed site

    @PostMapping("emailVerify")
    public String sendEmail(@ModelAttribute User user) {
        System.out.println(user.getEmail());
        emailService.prepareAndSend(user, "Reset Password", "Please click to reset your password: http://happeninghappyhours.com/changePassword?from=" + user.getEmail());
        return "redirect:/login";
    }

    @GetMapping("/changePassword")
    public String showForm(Model model, @RequestParam(name = "from") String from) {
        User user1 = userDao.findUserByEmail(from);
        model.addAttribute("user", user1);
        return "/changePassword";
    }

    @PostMapping("/changePassword/{email}")
    public String changePassword(@ModelAttribute User user, @RequestParam(name = "password") String password, @RequestParam(name = "passwordConfirm") String passwordConfirm, @PathVariable String email) {
        User userTest = userDao.findUserByEmail(email);
        if (password.equals(passwordConfirm)) {
            userTest.setPassword(passwordEncoder.encode(passwordConfirm));
            userDao.save(userTest);
        }
        return "redirect:/login";
    }
}
