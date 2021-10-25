package com.utm.progress;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;

@Entity
@Table(name="user's personal data")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID User")
    private Integer id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Accounts accounts;

    @ManyToOne(fetch = FetchType.LAZY)
    private Countries countries;

    @Column(name="Gender")
    private String gender;

    @Column(name="Birthday")
    private LocalDate birthday;

    @Column(name="Country")
    private String country;

    @Column(name="Smoking")
    private boolean smoking;

    @Column(name="Drinking alcohol")
    private boolean drinking;

    @Column(name="Healthy food")
    private boolean healthyFood;

    @Column(name="Sport")
    private boolean sport;

    @Column(name="Chronic diseases")
    private String disease;

    @Lob
    @Column(name="User's picture")
    private Blob picture;

    public void setId(Integer id) { this.id = id; }
    public void setGender(String gender) { this.gender = gender; }
    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }
    public void setCountry(String country) { this.country = country; }
    public void setSmoking(boolean smoking) { this.smoking = smoking; }
    public void setDrinking(boolean drinking) { this.drinking = drinking; }
    public void setHealthyFood(boolean healthyFood) { this.healthyFood = healthyFood; }
    public void setSport(boolean sport) { this.sport = sport; }
    public void setDisease(String disease) { this.disease = disease; }
    public void setPicture(Blob picture) { this.picture = picture; }

    public Integer getId() { return id; }
    public String getGender() { return gender; }
    public LocalDate getBirthday() { return birthday; }
    public String getCountry() { return country; }
    public boolean isSmoking() { return smoking; }
    public boolean isDrinking() { return drinking; }
    public boolean isHealthyFood() { return healthyFood; }
    public boolean isSport() { return sport; }
    public String getDisease() { return disease; }
    public Blob getPicture() { return picture; }
}
