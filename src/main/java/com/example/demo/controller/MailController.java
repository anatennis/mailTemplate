package com.example.demo.controller;

import com.example.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {
    @Autowired
    MailService mailService;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @PostMapping("/")
    public String sendMail(Model model, String email) {
        if (mailService.sendMail(email)) {
            model.addAttribute("sended", "Email was sent");
        } else {
            model.addAttribute("sended", "Error");
        }

        return "hello";
    }

    @GetMapping("/register")
    public String reg() {
        return "register";
    }

}
