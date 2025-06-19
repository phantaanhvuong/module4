package com.example.hom_thu_dien_tu.controller;

import com.example.hom_thu_dien_tu.model.MailSettings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MailSettingsController {
    @GetMapping("/settings")
    public String showForm(Model model){
        MailSettings mailSettings = new MailSettings();
        mailSettings.setLanguage("English");
        mailSettings.setPageSize(25);
        mailSettings.setSpamsFilter(false);
        mailSettings.setSignature("Thor/ King, Asgard");

        model.addAttribute("mailSettings",mailSettings);
        model.addAttribute("languages", List.of("English","Vietnamese","Japanese","chinese"));
        model.addAttribute("pageSizes", List.of(5,10,15,25,50,100));
        return "form";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("mailSettings")MailSettings mailSettings,Model model){
        model.addAttribute("mailSettings" ,mailSettings);
        return "result";
    }
}
