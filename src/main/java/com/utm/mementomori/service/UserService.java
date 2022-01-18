package com.utm.mementomori.service;

import com.utm.mementomori.dto.UserDTO;
import com.utm.mementomori.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public interface UserService {
    ModelAndView validate(UserDTO userDTO);

    boolean validateBoolean(UserDTO userDTO);

    ModelAndView update(UserDTO userDTO);

    void save(User user);
}
