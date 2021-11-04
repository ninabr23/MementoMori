package com.utm.mementomori.service;

import com.utm.mementomori.models.Accounts;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    boolean checkExistence(String email, String password);

    Accounts updateAccountPassword(String email, String newPassword);

    Accounts updateAccountEmail(String email, String password, String newEmail);
}
