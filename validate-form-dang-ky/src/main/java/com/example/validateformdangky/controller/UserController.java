package com.example.validateformdangky.controller;

import com.example.validateformdangky.model.User;
import com.example.validateformdangky.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "/index";
    }

    @PostMapping("/validateUser")
    public String checkValidation(@Validated @ModelAttribute("user") User user,
                                  BindingResult bindingResult,
                                  Model model){
        if(bindingResult.hasErrors()){
            return "/index";
        }
        userService.save(user);
        model.addAttribute("user",user);
        return "/result";
    }
}
