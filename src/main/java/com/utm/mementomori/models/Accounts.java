package com.utm.mementomori.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Accounts() {
    }

    public Accounts(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts account = (Accounts) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(email, account.email) &&
                Objects.equals(password, account.password);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { return password; }
}