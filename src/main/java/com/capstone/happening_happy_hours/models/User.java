
package com.capstone.happening_happy_hours.models;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "users", uniqueConstraints = {
//        @UniqueConstraint(name = "uc_user_username", columnNames = {"username"}),
//        @UniqueConstraint(name = "uc_user_email", columnNames = {"email"})
//})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 100)
    private String username;

    @Column
    private String phone;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private boolean ownsBusiness;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_businesses",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "business_id", referencedColumnName = "id")})
    private Business business;


    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    public User() {
    }


    public User(String username, String phone, String email, String password, Boolean ownsBusiness) {

        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.ownsBusiness = ownsBusiness;
    }

    public User(long id, String username, String email, String password, Boolean ownsBusiness) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.ownsBusiness = ownsBusiness;
    }

    // copy of constructor
    public User(User copy) {
        this.id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;
        this.ownsBusiness = copy.ownsBusiness;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getOwnsBusiness() {
        return ownsBusiness;
    }

    public void setOwnsBusiness(boolean ownsBusiness) {
        this.ownsBusiness = ownsBusiness;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusinesses(Business business) {
        this.business = business;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public User(long id, String username, String phone, String email, String password, boolean ownsBusiness, Business business, List<Review> reviews) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.ownsBusiness = ownsBusiness;
        this.business = business;
        this.reviews = reviews;
    }
}

