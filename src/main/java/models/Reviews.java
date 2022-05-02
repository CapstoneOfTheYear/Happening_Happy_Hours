package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;


@Entity
//@Table(name = "reviews" {
//        uniqueConstraints = {
//        @UniqueConstraint(name = "uc_post_user_id", columnNames = {"user_id"}),
//        @UniqueConstraint(name = "uc_post_business_id", columnNames = {"business_id"})
//})
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private long user_id;

    @Column(nullable = false, length = 100)
    private long business_id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @Column (columnDefinition = "DOUBLE", nullable = false)
    private double score;


    public Reviews() {}

    public Reviews(long id, long user_id, long business_id, String body, double score) {
        this.id = id;
        this.user_id = user_id;
        this.business_id = business_id;
        this.body = body;
        this.score = score;

    }


    // getters & setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {return user_id; }
    public void setUser_id(long user_id) { this.user_id = user_id; }

    public long getBusiness_id() { return business_id; }
    public void setBusiness_id(long business_id) { this.business_id = business_id; }

    public String getBody() {
        return this.body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }




}
