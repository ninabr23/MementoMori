package com.utm.mementomori.dao;


public interface LoginDao<Accounts> {
    Accounts getSingleByEmail(String email);

    void updatePassword(Accounts toUpdate, String password);
}
