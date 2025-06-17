package com.example.chuyen_doi_tien_te.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeController {
    @GetMapping("/home")
    public String showList() {
        return "index";
    }

    @PostMapping("/home")
    public String convert(Model model, @RequestParam("usd") int usd) {
        int vnd = usd * 26000;
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "index";
    }
}
