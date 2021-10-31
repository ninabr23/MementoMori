package com.utm.mementomori.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Countries {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "avg_female")
    private Integer avgFemale;

    @Column(name = "avg_male")
    private Integer avgMale;

    @OneToMany(mappedBy = "countries")
    private List<User> users;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvgFemale(Integer avgFemale) {
        this.avgFemale = avgFemale;
    }

    public void setAvgMale(Integer avgMale) {
        this.avgMale = avgMale;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAvgFemale() {
        return avgFemale;
    }

    public Integer getAvgMale() {
        return avgMale;
    }
}
