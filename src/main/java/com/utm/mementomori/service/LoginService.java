package com.utm.mementomori.service;

import com.utm.mementomori.dto.LoginDTO;
import com.utm.mementomori.models.Accounts;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public interface LoginService {
    ModelAndView checkExistence(LoginDTO loginDTO);

    ModelAndView update(LoginDTO loginDTO);

    void save(Accounts account);
}
