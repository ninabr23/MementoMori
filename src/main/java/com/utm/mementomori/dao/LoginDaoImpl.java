package com.utm.mementomori.dao;

import com.utm.mementomori.models.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Repository
public class LoginDaoImpl implements LoginDao<Accounts> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Accounts getSingleByEmail(String email) {
        try {
            return entityManager.createQuery("SELECT a FROM Accounts a WHERE a.email = :email", Accounts.class).
                    setParameter("email", email).getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
    }

    @Override
    public void updatePassword(Accounts toUpdate, String password) {
        toUpdate.setPassword(password);
    }

    @Override
    public void updateEmail(Accounts toUpdate, String email) {
        toUpdate.setEmail(email);
    }
}
