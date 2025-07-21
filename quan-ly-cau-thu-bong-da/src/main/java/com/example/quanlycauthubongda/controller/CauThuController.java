package com.example.quanlycauthubongda.controller;

import com.example.quanlycauthubongda.entity.CauThu;
import com.example.quanlycauthubongda.entity.ViTri;
import com.example.quanlycauthubongda.service.ICauThuService;
import com.example.quanlycauthubongda.service.IViTriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("cau_thu")
public class CauThuController {
    @Autowired
    private ICauThuService cauThuService;
    @Autowired
    private IViTriService viTriService;
    @ModelAttribute("viTriList")
    public List<ViTri> getAllViTri(){
        return viTriService.findAll();
    }
    @GetMapping("")
    public String showList(@RequestParam(required = false, defaultValue = "0") int page,
                           @RequestParam(required = false, defaultValue = "2") int size,
                           @RequestParam(required = false, defaultValue = "") String ten,
                           Model model){
        Pageable pageable = PageRequest.of(page,size);
        Page<CauThu> cauThuPage = cauThuService.findByTen(ten, pageable);
        model.addAttribute("ten", ten);
        model.addAttribute("cauThuPage", cauThuPage);
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("cauThu", new CauThu());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute CauThu cauThu, RedirectAttributes redirectAttributes){
        cauThuService.addOrUpdate(cauThu);
        redirectAttributes.addFlashAttribute("success","Thêm mới thành công");
        return "redirect:/cau_thu";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("cauThu", cauThuService.findById(id));
        return "create";

    }
    @PostMapping("/delete")
    public String delete(CauThu cauThu, RedirectAttributes redirectAttributes){
        cauThuService.deleteById(cauThu.getId());
        redirectAttributes.addFlashAttribute("success", "Xoá thành công");
        return "redirect:/cau_thu";
    }
}
