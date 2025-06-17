package com.example.tu_dien.controller;

import com.example.tu_dien.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/views")
    public String showList() {
        return "index";
    }

    @PostMapping("/views")
    public String result(Model model, @RequestParam("tiengviet") String tiengviet) {
        String tienganh = dictionaryService.findByKey(tiengviet);
        if (tienganh == null) {
            String loi = "Không có từ này trong từ điển";
            model.addAttribute("loi", loi);
        }
        model.addAttribute("tiengviet", tiengviet);
        model.addAttribute("tienganh", tienganh);
        return "index";
    }
}
