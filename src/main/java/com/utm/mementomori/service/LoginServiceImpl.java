package com.utm.mementomori.service;

import com.utm.mementomori.dao.LoginDao;
import com.utm.mementomori.models.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao<Accounts> loginDao;

    @Override
    public boolean checkExistence(String email, String password) {
        Accounts account = loginDao.getSingleByEmail(email);
        return account != null && account.getPassword().equals(password);
    }

    @Override
    public Accounts updateAccountPassword(String email, String newPassword) {
        Accounts account = loginDao.getSingleByEmail(email);
        if (account != null) {
            if (passwordValidation(newPassword)) {
                loginDao.updatePassword(account, newPassword);
                System.out.println("Account password updated. Please don't forget it next time!");
            } else System.out.println("New password invalid. Please choose another one.");
        } else System.out.println("Account with such an email does not exist.");
        return account;
    }

    @Override
    public Accounts updateAccountEmail(String email, String password, String newEmail) {
        Accounts account = loginDao.getSingleByEmail(email);
        if (account != null) {
            if (account.getPassword().equals(password)) {
                if (loginDao.getSingleByEmail(newEmail) == null && emailValidation(newEmail)) {
                    loginDao.updateEmail(account, newEmail);
                    System.out.println("Account email updated. Please don't forget it next time!");
                } else System.out.println("New E-mail invalid. Please choose another one.");
            }
            System.out.println("Password incorrect.");
        } else System.out.println("Account with such an email does not exist.");
        return account;
    }

    private boolean emailValidation(String email) {
        /*
        A-Z characters are permitted.
        a-z characters are permitted.
        0-9 digits are permitted.
        Special characters !#$%&'*+-/=?^_`{|}~ are permitted.
        No two consecutive dots or the dot as the initial/final characters in both local/domain part.
        Domain part must have at least one dot and after the final dot it has only letters.
        Top-level domain has at least two up to six letters.
        */
        final String regex = "^[\\\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean passwordValidation(String password) {
        /*
        Must have at least one numeric character.
        Must have at least one lowercase and uppercase character.
        Must be between 6 and 20 characters, both inclusive.
        */
        final String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
