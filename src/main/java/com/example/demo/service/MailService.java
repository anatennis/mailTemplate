package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Service
public class MailService {
    @Autowired
    MailSender mailSender;

    @Autowired
    TemplateEngine templateEngine;

    public boolean sendMail(String email) {

        User user = new User("SuperGeek", true, 1200);
        Context ctx = new Context();
        ctx.setVariable("name", user);
        ctx.setVariable("orderDate", new Date());
        ctx.setVariable("items", Arrays.asList(new Item("Ноутбук", 2, 50_000),
                new Item("Мышь", 1, 1_000),
                new Item("Клавиатура", 2, 2_000),
                new Item("Флешка", 3, 800)
                ));
        ctx.setVariable("sameitems", Arrays.asList(new Item("НоутбукNew", 2, 50_000),
                new Item("МышьNew", 1, 1_000)));
        ctx.setVariable("user", user);
        String htmlMessage = templateEngine.process("email", ctx);

        mailSender.send(email, "Example mail from shop", htmlMessage);
        return true;
    }
}
