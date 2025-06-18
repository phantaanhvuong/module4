package com.example.may_tinh_co_ban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MayTinhController {
    @GetMapping("/may_tinh")
    public String mayTinh(){
        return "index";
    }
    @PostMapping("/tinh_toan")
    public String tinhToan(@RequestParam double so1,
                           @RequestParam double so2,
                           @RequestParam String chon,
                           Model model){
        double ketQua = 0;
        String message = "";
        switch (chon){
            case "+":
                ketQua = so1 + so2;
                break;
            case "-":
                ketQua = so1 - so2;
                break;
            case "*":
                ketQua = so1 * so2;
                break;
            case "/":
                if (so2 != 0){
                    ketQua = so1 / so2;
                }else {
                    message = "khong the chia cho 0";
                }
                break;
            default:
                message = "phep tinh khong hop le";
        }
        model.addAttribute("so1",so1);
        model.addAttribute("so2",so2);
        model.addAttribute("chon",chon);
        model.addAttribute("ketQua",message.isEmpty()?ketQua:message);
        return "index";
    }
}
