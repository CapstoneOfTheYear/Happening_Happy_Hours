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

}
