package com.utm.mementomori.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "feed")
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Lob
    @Column(name = "post_data")
    private Blob postData;

    @Column(name = "post_name")
    private String postName;

    @ManyToOne
    @JoinColumn(name = "topic", nullable = false)
    private Topics topics;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPostData(Blob postData) {
        this.postData = postData;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public void setTopics(Topics topics) {
        this.topics = topics;
    }

    public Integer getId() {
        return id;
    }

    public Blob getPostData() {
        return postData;
    }

    public String getPostName() {
        return postName;
    }

    public Topics getTopics() {
        return topics;
    }
}
