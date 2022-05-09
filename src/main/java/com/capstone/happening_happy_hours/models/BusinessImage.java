package com.capstone.happening_happy_hours.models;


import javax.persistence.*;

@Entity
@Table(name= "business_images")
public class BusinessImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String images;

    @ManyToOne
    @JoinColumn(name= "business_id")
    private Business business;

    public BusinessImage(){

    }

    public BusinessImage(long id, String images, Business business) {
        this.id = id;
        this.images = images;
        this.business = business;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
