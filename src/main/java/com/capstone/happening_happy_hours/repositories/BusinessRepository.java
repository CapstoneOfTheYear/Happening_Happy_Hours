package com.capstone.happening_happy_hours.repositories;

import com.capstone.happening_happy_hours.models.Business;
import com.capstone.happening_happy_hours.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessRepository extends JpaRepository <Business, Long> {


    Business getBusinessByUser(User user);
    Business getBusinessByUserId(long id);
    Business getBusinessById(long id);
    Business getBusinessByName(String name);
    List<Business> getAllByNameContaining(String name);

}
