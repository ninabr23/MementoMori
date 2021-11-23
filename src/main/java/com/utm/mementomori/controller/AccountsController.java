package com.utm.mementomori.controller;

import com.utm.mementomori.dto.LoginDTO;
import com.utm.mementomori.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/login")
public class AccountsController {
    private final LoginService loginService;

    public AccountsController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(path = "/signIn")
    @ResponseBody
    public ModelAndView logIn(@RequestBody LoginDTO loginDTO) {
        return loginService.checkExistence(loginDTO);
    }

    @PutMapping(path = "/update")
    @ResponseBody
    public ModelAndView updatePassword(@RequestBody LoginDTO loginDTO) {
        return loginService.update(loginDTO);
    }
}
