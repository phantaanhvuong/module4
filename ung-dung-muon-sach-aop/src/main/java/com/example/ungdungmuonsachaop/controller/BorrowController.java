package com.example.ungdungmuonsachaop.controller;

import com.example.ungdungmuonsachaop.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping("/borrow/{id}")
    public String borrow(@PathVariable Long id, Model model) {
        String code = borrowService.borrowBook(id);
        model.addAttribute("code", code);
        return "borrow_success";
    }

    @GetMapping("/return")
    public String showReturnForm() {
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String code) {
        borrowService.returnBook(code);
        return "redirect:/books";
    }

}
