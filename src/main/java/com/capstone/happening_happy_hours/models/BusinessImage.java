package com.capstone.happening_happy_hours.models;


import javax.persistence.*;

@Entity
@Table(name= "business_images")
public class BusinessImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String image_url;

    @ManyToOne
    @JoinColumn(name= "business_id")
    private Business business;

    public BusinessImage(){

    }

    public BusinessImage(long id, String image_url, Business business) {
        this.id = id;
        this.image_url = image_url;
        this.business = business;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
