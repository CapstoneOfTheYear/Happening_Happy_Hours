package com.capstone.happening_happy_hours.repositories;

import com.capstone.happening_happy_hours.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Review findReviewsById(long id);
    List<Review> findAllByUserId(long id);
}
