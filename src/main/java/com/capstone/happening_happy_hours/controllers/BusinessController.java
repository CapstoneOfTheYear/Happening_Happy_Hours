package com.capstone.happening_happy_hours.controllers;


import com.capstone.happening_happy_hours.models.Business;
import com.capstone.happening_happy_hours.models.User;
import com.capstone.happening_happy_hours.repositories.BusinessRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class BusinessController {
    BusinessRepository businessDao;

   public BusinessController (BusinessRepository businessDao){
       this.businessDao = businessDao;
   }


    @GetMapping("/profile/business")
    public String businessProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getOwnsBusiness()){
            Business business = businessDao.getBusinessByUser(user);
            model.addAttribute("business", business);
        }
        return "businessProfile";
    }
}
