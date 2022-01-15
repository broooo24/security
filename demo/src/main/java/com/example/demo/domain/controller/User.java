package com.example.demo.domain.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class User {
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/contentmanager")
    public String content(){
        return "contentmanager";
    }

    @GetMapping("/loggedIn")
    public String loggedIn(){
        return "logged-in";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }
}
