package com.utm.mementomori.controller;

import com.utm.mementomori.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/logindemo")
public class AccountsController {
    private final LoginService loginService;

    @Autowired
    public AccountsController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping(path = "/check")
    public @ResponseBody
    String logIn(Model model, @RequestParam String email, @RequestParam String password) {
        model.addAttribute("response", loginService.checkExistence(email, password));
        return "checked";
    }

    //update email
    @PostMapping(path = "/update1")
    public @ResponseBody
    String updateEmail(Model model, @RequestParam String email, @RequestParam String password
            , @RequestParam String newEmail) {
        model.addAttribute("update1", loginService.updateAccountEmail(email, password, newEmail));
        return "updated1";
    }

    //update password
    @PostMapping(path = "/update2")
    public @ResponseBody
    String updatePassword(Model model, @RequestParam String email
            , @RequestParam String newPassword) {
        model.addAttribute("update2", loginService.updateAccountPassword(email, newPassword));
        return "updated2";
    }
}
