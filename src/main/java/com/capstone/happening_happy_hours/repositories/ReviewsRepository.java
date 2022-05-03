package com.capstone.happening_happy_hours.repositories;

import com.capstone.happening_happy_hours.models.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

    Reviews findReviewsById(long id);
}
