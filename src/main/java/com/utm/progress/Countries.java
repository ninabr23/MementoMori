package com.utm.progress;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="countries statistics")
public class Countries {
    @Id
    @Column(name="ID country")
    private String id;

    @Column(name="Name")
    private String name;

    @Column(name="Average Age Female")
    private Integer avgFemale;

    @Column(name="Average Age Male")
    private Integer avgMale;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAvgFemale(Integer avgFemale) { this.avgFemale = avgFemale; }
    public void setAvgMale(Integer avgMale) { this.avgMale = avgMale; }

    public String getId() { return id; }
    public String getName() { return name; }
    public Integer getAvgFemale() { return avgFemale; }
    public Integer getAvgMale() { return avgMale; }
}
