package com.capstone.happening_happy_hours.repositories;

import com.capstone.happening_happy_hours.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Review findReviewsById(long id);

    List<Review> findAllByBusinessId(long id);

    List<Review> findAllByUserId(long id);

    List<Review> getAllByBusinessId(long id);

//    @Query(value = "SELECT avg(score) FROM Review group by :id1")
//    List<Double> avg(@Param("id1") Long id1);
}
