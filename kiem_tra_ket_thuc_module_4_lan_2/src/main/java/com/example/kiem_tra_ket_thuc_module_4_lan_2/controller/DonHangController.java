package com.example.kiem_tra_ket_thuc_module_4_lan_2.controller;
import com.example.kiem_tra_ket_thuc_module_4_lan_2.entity.DonHang;
import com.example.kiem_tra_ket_thuc_module_4_lan_2.entity.LoaiSanPham;
import com.example.kiem_tra_ket_thuc_module_4_lan_2.service.IDonHangService;
import com.example.kiem_tra_ket_thuc_module_4_lan_2.service.ILoaiSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("don_hang")
public class DonHangController {
    @Autowired
    private IDonHangService donHangService;
    @Autowired
    private ILoaiSpService loaiSpService;
    @ModelAttribute("typeList")
    private List<LoaiSanPham> getAllType(){
        return loaiSpService.findAll();
    }

    @GetMapping("")
    public String showList(@RequestParam(required = false,defaultValue = "0")int page,
                           @RequestParam(required = false,defaultValue = "5")int size,
                           Model model){
        Sort sort = Sort.by(Sort.Direction.ASC,"maDonHang");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<DonHang> donHangPage = donHangService.findAll(pageable);

        model.addAttribute("donHangPage",donHangPage);
        return "index";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model){
        Optional<DonHang> donHang = donHangService.findById(id);
        if (donHang.isPresent()){
            model.addAttribute("donHang", donHang.get());
            return "update";
        }else {
            redirectAttributes.addFlashAttribute("success","không tìm thấy đối tượng cần sửa");
            return "redirect:/don_hang";
        }
    }
    @PostMapping("/{id}/edit")
    public String processEdit(@Validated @ModelAttribute DonHang donHang , BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Model model, @PathVariable Long id) {
        if(bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
            return "update";
        }
        if(donHangService.findById(id).isEmpty()) {
            model.addAttribute("errors", "Không tìm thấy đối tuọng cần sửa");
            return "update";
        }
        donHangService.edit(donHang,id);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");
        return "redirect:/don_hang";

    }

}
