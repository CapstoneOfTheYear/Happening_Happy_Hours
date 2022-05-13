package com.capstone.happening_happy_hours.controllers;


import com.capstone.happening_happy_hours.models.Business;
import com.capstone.happening_happy_hours.models.Review;
import com.capstone.happening_happy_hours.models.User;
import com.capstone.happening_happy_hours.repositories.BusinessRepository;
import com.capstone.happening_happy_hours.repositories.ReviewRepository;
import com.capstone.happening_happy_hours.repositories.UserRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.util.List;


@Controller
public class BusinessController {
    BusinessRepository businessDao;
    ReviewRepository reviewDao;
    UserRepository userDao;

    public BusinessController(BusinessRepository businessDao, ReviewRepository reviewDao, UserRepository userDao) {
        this.businessDao = businessDao;
        this.reviewDao = reviewDao;
        this.userDao = userDao;
    }


    @GetMapping("/profile/business")
    public String businessProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user.getOwnsBusiness()) {
            Business business = businessDao.getBusinessByUser(user);
            model.addAttribute("business", business);
            model.addAttribute("reviews", reviewDao.findAllByBusinessId(business.getId()));
            model.addAttribute("images", business.getBusinessImages());
        }
        return "businessProfile";
    }


    @GetMapping("/updateBusiness")
    public String updateProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Business business = businessDao.getBusinessByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("business", business);
        return "updateBusiness";
    }


    @PostMapping("/updateBusiness/{id}")
    public String postUpdateProfile(Model model, @ModelAttribute Business business, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            business.setId(id);
            return "updateBusiness";
        }
        System.out.println("business.getName() = " + business.getName());
        System.out.println("business.getLocation() = " + business.getLocation());
        System.out.println("business.getCity() = " + business.getCity());
        businessDao.save(business);
        return "redirect:/profile/business";
    }

    @GetMapping("/business/{id}")
    public String singleBusinessProfile(Model model, @PathVariable String id) {
        Business business = businessDao.getBusinessById(Long.parseLong(id));
        model.addAttribute("business", business);
        model.addAttribute("reviews", reviewDao.findAllByBusinessId(business.getId()));
        model.addAttribute("review", new Review());
        return "viewBusiness";
    }

    @PostMapping("/review/{id}")
    public String postReview(Model model, @PathVariable long id, Review review) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user2 = userDao.getById(user.getId());
        Business business = businessDao.getBusinessById(id);
        reviewDao.add(review.getBody(),review.getScore(),business.getId(),user2.getId());
        return "redirect:/profile/user";
    }


}
