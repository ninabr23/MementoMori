package com.utm.mementomori.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="feed")
public class Feed {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Lob
    @Column(name="PostData")
    private Blob PostData;

    @Column(name="PostName")
    private String PostName;

    @ManyToOne
    @JoinColumn(name = "topic", nullable = false)
    private Topics topics;

    public void setId(Integer id) { this.id = id; }
    public void setPostData(Blob postData) { PostData = postData; }
    public void setPostName(String postName) { PostName = postName; }
    public void setTopics(Topics topics) { this.topics = topics; }

    public Integer getId() { return id; }
    public Blob getPostData() { return PostData; }
    public String getPostName() { return PostName; }
    public Topics getTopics() { return topics; }
}
