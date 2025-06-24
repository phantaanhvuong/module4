package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.model.Category;
import com.example.ung_dung_blog.service.IBlogService;
import com.example.ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;


    @ModelAttribute("categoryList")
    public  List<Category> getAllCategory(){
        return categoryService.findAll();
    }
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("blogList",blogService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blogs", new Blog());
//        model.addAttribute("categoryList",categoryService.findAll());
        return "/create";
    }
    @GetMapping("/detail/{id}")
    public String detail2(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "view";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog , RedirectAttributes redirectAttributes){
        blogService.addOrUpdate(blog);
        redirectAttributes.addFlashAttribute("mess","add success");

        return "redirect:/blogs";
    }
    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes){
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("success","Delete Blog successfully!");
        return "redirect:/blogs";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
//        model.addAttribute("categoryList",categoryService.findAll());
        return "/update";
    }

}
