package com.capstone.happening_happy_hours.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "businesses", uniqueConstraints = {
        @UniqueConstraint(name = "uc_user_name", columnNames = {"name"}),

})
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String location;

    @Column(nullable = false, length = 100)
    private String state;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 100)
    private String postal_code;

    @Column(nullable = false, length = 100)
    private String hours;

    @ManyToMany(mappedBy = "businesses")
    private List<User> users;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<BusinessImage> businessImages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<BusinessAttribute> businessAttributes;

    public Business() {
    }


    public Business(String name, String location, String state, String city, String postal_code, String hours) {

        this.name = name;
        this.location = location;
        this.state = state;
        this.city = city;
        this.postal_code = postal_code;
        this.hours = hours;
    }

    public Business(long id, String name, String location, String state, String city, String postal_code, String hours) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.state = state;
        this.city = city;
        this.postal_code = postal_code;
        this.hours = hours;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

}