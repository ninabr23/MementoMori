package com.utm.mementomori.entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name="topic")
    private String topic;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topics> topics = new ArrayList<>();

    public void setId(Integer id) { this.id = id; }
    public void setPostData(Blob postData) { PostData = postData; }
    public void setPostName(String postName) { PostName = postName; }
    public void setTopic(String topic) { this.topic = topic; }

    public Integer getId() { return id; }
    public Blob getPostData() { return PostData; }
    public String getPostName() { return PostName; }
    public String getTopic() { return topic; }
}
