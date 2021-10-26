package com.utm.mementomori.entity;

import javax.persistence.*;

@Entity
@Table(name="accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID User")
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ID User")
    private User user;

    @Column(name="User name")
    private String name;

    @Column(name="E-mail")
    private String email;

    @Column(name="Password")
    private String password;

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() { return password; }
}