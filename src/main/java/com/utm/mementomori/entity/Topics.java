package com.utm.mementomori.entity;

import com.utm.mementomori.entity.Feed;

import javax.persistence.*;

@Entity
@Table(name="topics")
public class Topics {
    @Id
    @Column(name="Abbreviation")
    private String abbreviation;

    @ManyToOne(fetch = FetchType.LAZY)
    private Feed feed;

    @Column(name="Theme")
    private String theme;

    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }
    public void setTheme(String theme) { this.theme = theme; }

    public String getAbbreviation() { return abbreviation; }
    public String getTheme() { return theme; }
}
