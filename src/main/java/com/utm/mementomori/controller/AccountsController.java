package com.utm.mementomori.controller;

import com.utm.mementomori.dto.LoginDTO;
import com.utm.mementomori.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("loginPage")
public class AccountsController {
    private final LoginService loginService;

    public AccountsController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(path = "/sign-in")
    @ResponseBody
    public ResponseEntity<String> logIn(@RequestBody LoginDTO loginDTO, Model model) {
        return loginService.checkExistence(loginDTO);
    }

    @PutMapping(path = "/update")
    @ResponseBody
    public ResponseEntity<String> updatePassword(@RequestBody LoginDTO loginDTO) {
        return loginService.update(loginDTO);
    }
}
