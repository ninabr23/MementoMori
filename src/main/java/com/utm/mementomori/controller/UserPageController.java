package com.utm.mementomori.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/userPage")
public class UserPageController {

    @GetMapping(path = "/userPage/{email}")
    public ModelAndView userEmail(@PathVariable String email) {
        ModelAndView mv = new ModelAndView("userPage");
        mv.addObject("user", email);
        return mv;
    }
}
