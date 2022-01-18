package com.utm.mementomori.dao;

import java.time.LocalDate;

public interface UserDao<User> {
    User getSingleByEmail(String email);

    void updateFirstName(User toUpdate, String firstName);

    void updateLastName(User toUpdate, String lastName);

    void updateEmail(User toUpdate, String email);

    void updatePassword(User toUpdate, String password);

    void updateBirthdate(User toUpdate, LocalDate bday);

    void updateCountry(User toUpdate, String country);
}
