package com.capstone.happening_happy_hours.controllers;


import com.capstone.happening_happy_hours.models.Business;
import com.capstone.happening_happy_hours.models.Review;
import com.capstone.happening_happy_hours.models.User;
import com.capstone.happening_happy_hours.repositories.BusinessRepository;
import com.capstone.happening_happy_hours.repositories.ReviewRepository;
import com.capstone.happening_happy_hours.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserRepository userDao;
    private BusinessRepository businessDao;
    private ReviewRepository reviewDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, BusinessRepository businessDao, ReviewRepository reviewDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.businessDao = businessDao;
        this.reviewDao = reviewDao;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/profile/user")
//
    public String userProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user1 = userDao.getById(user.getId());
        model.addAttribute("User", user1);
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

    @PostMapping(value = "/register", params = {"imageUrl"})
    public String saveUser(@ModelAttribute User user, @ModelAttribute Business business, @RequestParam(value = "imageUrl", required = false) String imageUrl) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        if (user.getOwnsBusiness()) {
            user.setBusinesses(business);
            business.setBusinessImages(imageUrl);
            businessDao.save(business);
        }
        return "redirect:/login";
    }

    @PostMapping(value = "/register")
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

    @GetMapping("/updateProfile")
    public String updateProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user2 = userDao.getById(user.getId());
        model.addAttribute("user", user2);
        return "updateUser";
    }

    @PostMapping("/updateProfile/{id}")
    public String updateUser(@ModelAttribute User user, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            user.setId(id);
            return "updateUser";
        }
        Business business = businessDao.getBusinessByUserId(user.getId());
        user.setBusinesses(business);
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/profile/user";
    }

    @PostMapping("/deleteProfile/{id}")
    public String deleteUser(@ModelAttribute User user, BindingResult result, @PathVariable long id, HttpSession ses) {
        if (result.hasErrors()) {
            user.setId(id);
            return "updateUser";
        }
        Business business = businessDao.getBusinessByUserId(user.getId());
        user.setBusinesses(business);
        businessDao.delete(business);
        userDao.delete(user);
        ses.invalidate();
        return "redirect:/home";
    }

    @PostMapping("/updateReview/{id}")
    public String updateUser(@ModelAttribute Review review, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            review.setId(id);
            return "userProfile";
        }
        reviewDao.save(review);
        return "redirect:/profile/user";
    }
}
