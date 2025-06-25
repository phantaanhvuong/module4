package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Category;
import com.example.ung_dung_blog.service.IBlogService;
import com.example.ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "Thêm thể loại thành công!");
        return "redirect:/categories";
    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
//        categoryService.deleteById(id);
//        redirectAttributes.addFlashAttribute("mess", "Xoá thể loại thành công!");
//        return "redirect:/categories";
//    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (!blogService.findByCategory_Id(id).isEmpty()) {
            redirectAttributes.addFlashAttribute("mess", "Không thể xóa vì có blog đang sử dụng thể loại này!");
            return "redirect:/categories";
        }
        categoryService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thể loại thành công");
        return "redirect:/categories";
    }

}
