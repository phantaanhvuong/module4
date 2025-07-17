package com.example.kiem_tra_ket_thuc_module_4.controller;
import com.example.kiem_tra_ket_thuc_module_4.entity.GiaoDich;
import com.example.kiem_tra_ket_thuc_module_4.entity.KhachHang;
import com.example.kiem_tra_ket_thuc_module_4.service.IGiaoDichService;
import com.example.kiem_tra_ket_thuc_module_4.service.IKhachHangService;
import com.example.kiem_tra_ket_thuc_module_4.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("giao_dich")
public class GiaoDichController {
    @Autowired
    private IKhachHangService khachHangService;
    @Autowired
    private IGiaoDichService giaoDichService;
    @ModelAttribute("categoryList")
    public List<KhachHang> getAllCategory(){
        return khachHangService.findAll();
    }
    @GetMapping("")
    public String showList(@RequestParam(required = false, defaultValue = "0") int page,
                           @RequestParam(required = false, defaultValue = "5") int size,
                           @RequestParam(required = false, defaultValue = "") String tenKhachHang,
                           @RequestParam(required = false, defaultValue = "") String loaiGiaoDich,
                           Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<GiaoDich> giaoDichPage = giaoDichService.searchGiaoDich(tenKhachHang, loaiGiaoDich, pageable);

        model.addAttribute("tenKhachHang", tenKhachHang);
        model.addAttribute("loaiGiaoDich", loaiGiaoDich);
        model.addAttribute("giaoDichPage", giaoDichPage);

        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("giaoDich", new GiaoDich());
//        model.addAttribute("categoryList",categoryService.findAll());
        return "/create";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute GiaoDich giaoDich , BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "/create";
        }
        giaoDichService.add(giaoDich);
        redirectAttributes.addFlashAttribute("success","Thêm dữ liệu thành công");
        return "redirect:/giao_dich";
    }
    @PostMapping("/delete")
    public String delete(GiaoDich giaoDich, RedirectAttributes redirectAttributes){
        giaoDichService.remove(giaoDich.getId());
        redirectAttributes.addFlashAttribute("success","Xoá thành công");
        return "redirect:/giao_dich";
    }
    @GetMapping("/detail/{id}")
    public String detail2(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("giaoDich",giaoDichService.findById(id));
        return "view";
    }
}
