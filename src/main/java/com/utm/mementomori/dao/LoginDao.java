package com.utm.mementomori.dao;

import java.util.List;

public interface LoginDao<Accounts> {
    Accounts getSingleByEmail(String email);

    void updatePassword(Accounts toUpdate, String password);
}
