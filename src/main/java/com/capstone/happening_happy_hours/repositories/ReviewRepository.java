package com.capstone.happening_happy_hours.repositories;

import com.capstone.happening_happy_hours.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {


    Review findReviewsById(long id);

    List<Review> findAllByBusinessId(long id);

    List<Review> findAllByUserId(long id);

    List<Review> getAllByBusinessId(long id);

    List<Review> getAllByUserId(long id);



    @Modifying
    @Transactional
    @Query(value = "INSERT into h3_db.reviews (body, score, business_id, user_id) values (?1,?2,?3,?4);", nativeQuery = true)
    void add(@Param("body") String body, @Param("score") double score, @Param("business_id") long business_id, @Param("user_id") long user_id);

//    @Query(value = "SELECT avg(score) FROM Review group by :id1")
//    List<Double> avg(@Param("id1") Long id1);
}
