package com.capstone.happening_happy_hours.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "businesses")

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
    private String starting_hour;

    @Column(nullable = false, length = 10)
    private String ending_hour;

    @Column(columnDefinition = "boolean default false")
    private boolean dogsAllowed;

    @Column(columnDefinition = "boolean default false")
    private boolean pool;

    @Column(columnDefinition = "boolean default false")
    private boolean darts;

    @Column(columnDefinition = "boolean default false")
    private boolean liveMusic;

    @Column(columnDefinition = "boolean default false")
    private boolean karaoke;

    @Column(columnDefinition = "boolean default false")
    private boolean cornHole;

    @Column(columnDefinition = "boolean default false")
    private boolean servesFood;

    @Column()
    private String otherGames;

    @ManyToMany(mappedBy = "businesses")
    private List<User> users;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<BusinessImage> businessImages;

    // Rob created
    public Business(long id, String name, String location, String state, String city, String postal_code, String starting_hour, String ending_hour) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.state = state;
        this.city = city;
        this.postal_code = postal_code;
        this.starting_hour = starting_hour;
        this.ending_hour = ending_hour;
    }

    public Business(){}

    public Business(long id, String name, String location, String state, String city, String postal_code, String starting_hour, String ending_hour, boolean dogsAllowed, boolean pool, boolean darts, boolean liveMusic, boolean karaoke, boolean cornHole, boolean servesFood, String otherGames) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.state = state;
        this.city = city;
        this.postal_code = postal_code;
        this.starting_hour = starting_hour;
        this.ending_hour = ending_hour;
        this.dogsAllowed = dogsAllowed;
        this.pool = pool;
        this.darts = darts;
        this.liveMusic = liveMusic;
        this.karaoke = karaoke;
        this.cornHole = cornHole;
        this.servesFood = servesFood;
        this.otherGames = otherGames;
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

    public String getStarting_hour() {
        return starting_hour;
    }

    public void setStarting_hour(String starting_hour) {
        this.starting_hour = starting_hour;
    }

    public String getEnding_hour() {
        return ending_hour;
    }

    public void setEnding_hour(String ending_hour) {
        this.ending_hour = ending_hour;
    }

    public boolean isDogsAllowed() {
        return dogsAllowed;
    }

    public void setDogsAllowed(boolean dogsAllowed) {
        this.dogsAllowed = dogsAllowed;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isDarts() {
        return darts;
    }

    public void setDarts(boolean darts) {
        this.darts = darts;
    }

    public boolean isLiveMusic() {
        return liveMusic;
    }

    public void setLiveMusic(boolean liveMusic) {
        this.liveMusic = liveMusic;
    }

    public boolean isKaraoke() {
        return karaoke;
    }

    public void setKaraoke(boolean karaoke) {
        this.karaoke = karaoke;
    }

    public boolean isCornHole() {
        return cornHole;
    }

    public void setCornHole(boolean cornHole) {
        this.cornHole = cornHole;
    }

    public boolean isServesFood() {
        return servesFood;
    }

    public void setServesFood(boolean servesFood) {
        this.servesFood = servesFood;
    }

    public String getOtherGames() {
        return otherGames;
    }

    public void setOtherGames(String otherGames) {
        this.otherGames = otherGames;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<BusinessImage> getBusinessImages() {
        return businessImages;
    }

    public void setBusinessImages(List<BusinessImage> businessImages) {
        this.businessImages = businessImages;
    }
}
