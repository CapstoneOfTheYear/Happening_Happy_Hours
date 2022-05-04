package com.capstone.happening_happy_hours.models;


import javax.persistence.*;

@Entity
@Table(name= "business_attributes")
public class BusinessAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private boolean dogsAllowed;

    @Column(nullable = false)
    private boolean pool;

    @Column(nullable = false)
    private boolean darts;

    @Column(nullable = false)
    private boolean liveMusic;

    @Column(nullable = false)
    private boolean karaoke;

    @Column(nullable = false)
    private boolean cornhole;

    @Column(nullable = false)
    private boolean servesFood;

    @Column(nullable = false)
    private String otherGames;

    public BusinessAttribute(){

    }

    public BusinessAttribute(long id, boolean dogsAllowed, boolean pool, boolean darts, boolean liveMusic, boolean karaoke, boolean cornhole, boolean servesFood, String otherGames) {
        this.id = id;
        this.dogsAllowed = dogsAllowed;
        this.pool = pool;
        this.darts = darts;
        this.liveMusic = liveMusic;
        this.karaoke = karaoke;
        this.cornhole = cornhole;
        this.servesFood = servesFood;
        this.otherGames = otherGames;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isCornhole() {
        return cornhole;
    }

    public void setCornhole(boolean cornhole) {
        this.cornhole = cornhole;
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
}


