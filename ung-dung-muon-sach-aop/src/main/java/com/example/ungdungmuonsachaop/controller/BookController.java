package com.example.ungdungmuonsachaop.controller;

import com.example.ungdungmuonsachaop.entity.Book;
import com.example.ungdungmuonsachaop.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String index(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList",bookList);
        return "index";
    }
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("books", bookService.findById(id));
        return "detail";
    }
}
