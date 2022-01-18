package com.utm.mementomori.dao;

import com.utm.mementomori.models.Countries;
import com.utm.mementomori.models.User;
import com.utm.mementomori.service.LoginService;
import com.utm.mementomori.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.time.LocalDate;

@Repository
public class UserDaoImpl implements UserDao<User>{
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Override
    public User getSingleByEmail(String email) {
        try {
            return entityManager.createQuery("SELECT a FROM User a WHERE a.account.email = :email", User.class).
                    setParameter("email", email).getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
    }

    @Override
    public void updateFirstName(User toUpdate, String firstName) {
        String[] name = toUpdate.getName().split(" ");
        StringBuilder lastName = new StringBuilder();
        for(int i=0; i< name.length; i++){
            lastName.append(name[i]);
            if(i!=name.length-1)
                lastName.append(" ");
        }
        toUpdate.setName(firstName + name[name.length-1]);
        userService.save(toUpdate);
    }

    @Override
    public void updateLastName(User toUpdate, String lastName) {
        String[] name = toUpdate.getName().split(" ");
        toUpdate.setName(name[name.length-2]+lastName);
        userService.save(toUpdate);
    }

    @Override
    public void updateEmail(User toUpdate, String email) {
        toUpdate.getAccount().setEmail(email);
        userService.save(toUpdate);
        loginService.save(toUpdate.getAccount());
    }

    @Override
    public void updatePassword(User toUpdate, String password) {
        toUpdate.getAccount().setPassword(password);
        userService.save(toUpdate);
        loginService.save(toUpdate.getAccount());
    }

    @Override
    public void updateBirthdate(User toUpdate, LocalDate bday) {
        toUpdate.setBirthday(bday);
        userService.save(toUpdate);
    }

    @Override
    public void updateCountry(User toUpdate, String country) {
        Countries countryS = new Countries();
        countryS.setName(country);
        toUpdate.setCountries(countryS);
        userService.save(toUpdate);
    }
}
