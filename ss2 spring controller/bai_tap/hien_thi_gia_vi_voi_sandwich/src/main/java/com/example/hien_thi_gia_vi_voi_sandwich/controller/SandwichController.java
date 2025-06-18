package com.example.hien_thi_gia_vi_voi_sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/sandwich")
    public String showForm(){
        return "form";
    }
    @PostMapping("/save")
    public String save(@RequestParam("giaVi")String[] giaVi, Model model){
        model.addAttribute("giaVi", giaVi);
        return "result";
    }
}
