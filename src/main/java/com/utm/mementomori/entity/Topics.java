package com.utm.mementomori.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topics {
    @Id
    @Column(name = "abbreviation")
    private String abbreviation;

    @OneToMany(mappedBy = "topics")
    private List<Feed> feeds;

    @Column(name = "theme")
    private String theme;

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getTheme() {
        return theme;
    }
}
