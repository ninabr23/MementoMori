package com.utm.mementomori.service;

import com.utm.mementomori.dto.LoginDTO;
import com.utm.mementomori.models.Accounts;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    ResponseEntity<String> checkExistence(LoginDTO loginDTO);

    ResponseEntity<String> update(LoginDTO loginDTO);

    void save(Accounts account);
}
