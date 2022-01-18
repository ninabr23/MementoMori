package com.utm.mementomori.controller;

import com.utm.mementomori.dto.UserDTO;
import com.utm.mementomori.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/userPage")
public class UserPageController {
    private final UserService userService;

    public UserPageController(UserService userService) {
        this.userService = userService;
    }

    private ModelAndView mv = new ModelAndView("userPage");

    @PutMapping(path = "/update")
    @ResponseBody
    public ModelAndView update(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }

}
