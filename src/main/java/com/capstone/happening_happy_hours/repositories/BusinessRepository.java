package com.capstone.happening_happy_hours.repositories;

import com.capstone.happening_happy_hours.models.Business;
import com.capstone.happening_happy_hours.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository <Business, Long> {

    Business getBusinessByUser(User user);
}
