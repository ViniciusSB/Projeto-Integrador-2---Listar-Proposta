package com.unitins.projetointegrador2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("home")
    public String home() {
        return "home";
    }

}
