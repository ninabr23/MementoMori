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

    private ModelAndView mv = new ModelAndView("index");

    @PostMapping(path = "/signIn")
    @ResponseBody
    public void logIn(@RequestBody LoginDTO loginDTO) {
        mv = loginService.checkExistence(loginDTO);
    }

    @GetMapping(path = "/{email}")
    public ModelAndView showView(@PathVariable String email) {
        return mv;
    }

    @PutMapping(path = "/update")
    @ResponseBody
    public ModelAndView updatePassword(@RequestBody LoginDTO loginDTO) {
        return loginService.update(loginDTO);
    }
}
