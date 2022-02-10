package com.example.demo.controller;

import com.example.demo.domain.security.H2UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Model model) {
        ArrayList<String > authorities = new ArrayList<>();
        authorities.add("alig");
        authorities.add("maki");
        authorities.add("béla");
        H2UserDetails principal = (H2UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        System.out.println(principal.getUsername());
        model.addAttribute("userSession",principal);
        model.addAttribute("authorities",authorities);

        return "main";
    }

}
