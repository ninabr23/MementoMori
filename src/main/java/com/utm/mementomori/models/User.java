package com.utm.mementomori.models;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Accounts account;

    @ManyToOne
    @JoinColumn(name = "country")
    private Countries countries;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "smoking")
    private boolean smoking;

    @Column(name = "drinking")
    private boolean drinking;

    @Column(name = "healthy_food")
    private boolean healthyFood;

    @Column(name = "sport")
    private boolean sport;

    @Column(name = "diseases")
    private String disease;

    @Lob
    @Column(name = "picture")
    private Blob picture;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public void setDrinking(boolean drinking) {
        this.drinking = drinking;
    }

    public void setHealthyFood(boolean healthyFood) {
        this.healthyFood = healthyFood;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public String getName() { return name; }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Countries getCountries() {
        return countries;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public boolean isDrinking() {
        return drinking;
    }

    public boolean isHealthyFood() {
        return healthyFood;
    }

    public boolean isSport() {
        return sport;
    }

    public String getDisease() {
        return disease;
    }

    public Blob getPicture() {
        return picture;
    }
}
