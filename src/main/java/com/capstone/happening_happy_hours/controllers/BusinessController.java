package com.capstone.happening_happy_hours.controllers;


import com.capstone.happening_happy_hours.models.Business;
import com.capstone.happening_happy_hours.models.Review;
import com.capstone.happening_happy_hours.models.User;
import com.capstone.happening_happy_hours.repositories.BusinessRepository;
import com.capstone.happening_happy_hours.repositories.ReviewRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class BusinessController {
    BusinessRepository businessDao;
    ReviewRepository reviewDao;

   public BusinessController (BusinessRepository businessDao, ReviewRepository reviewDao){
       this.businessDao = businessDao;
       this.reviewDao = reviewDao;
   }


    @GetMapping("/profile/business")
    public String businessProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List <Review> reviewsRating = user.getBusiness().getReviews();
        if (user.getOwnsBusiness()){
            Business business = businessDao.getBusinessByUser(user);
            model.addAttribute("business", business);
            model.addAttribute("reviews", reviewDao.findAllByBusinessId(business.getId()));
//            model.addAttribute("reviewsRating", reviewsRating);
        }
        return "businessProfile";
    }

    @GetMapping("/updateBusiness")
    public String updateProfile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Business business = businessDao.getBusinessByUser(user);
        System.out.println("business.getName() = " + business.getName());
        model.addAttribute("user", user);
        model.addAttribute("business", business);
        return "updateBusiness";
   }


    @PostMapping("/updateBusiness")
    public String postUpdateProfile(Model model){

       return "redirect: businessProfile";
    }




    @GetMapping("/business")
    public String singleBusinessProfile(Model model) {

        return "viewBusiness";
    }



}
