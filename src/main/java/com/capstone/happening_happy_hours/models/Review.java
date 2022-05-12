package com.capstone.happening_happy_hours.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;



import javax.persistence.*;


@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


//    @Column(nullable = false, length = 100)
//    private long user_id;

    @ManyToOne
    private User user;


    @ManyToOne
    private Business business;


    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @Column (columnDefinition = "DOUBLE", nullable = false)
    private double score;


    public Review() {}

    public Review(long id, User user, Business business, String body, double score) {
        this.id = id;
        this.user = user;
        this.business = business;
        this.body = body;
        this.score = score;
    }

//    public Reviews(long id, long user_id, User user, long business_id, String body, double score) {
//        this.id = id;
//        this.user_id = user_id;
//        this.user = user;
//        this.business_id = business_id;
//        this.body = body;
//        this.score = score;
//
//
//    }


    // getters & setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id;}


//    public long getUser_id() {return user_id; }
//    public void setUser_id(long user_id) { this.user_id = user_id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Business getBusiness() { return business; }
    public void setBusiness_id(long business_id) { this.business = business; }

    public String getBody() {
        return this.body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }




}
