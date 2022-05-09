package com.capstone.happening_happy_hours.repositories;

import com.capstone.happening_happy_hours.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository <Business, Long> {
    Business getBusinessById(long id);
    Business getBusinessByName(String name);
}
