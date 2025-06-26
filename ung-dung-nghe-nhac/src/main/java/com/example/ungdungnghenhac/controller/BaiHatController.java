package com.example.ungdungnghenhac.controller;

import com.example.ungdungnghenhac.dto.BaiHatRepuestDto;
import com.example.ungdungnghenhac.model.BaiHat;
import com.example.ungdungnghenhac.service.IBaiHatService;
import org.springframework.beans.BeanUtils;
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

@Controller
@RequestMapping("bai_hat")
public class BaiHatController {
    @Autowired
    private IBaiHatService baiHatService;

    @GetMapping("")
    public String index(Model model){
        List<BaiHat> baiHats = baiHatService.findAll();
        model.addAttribute("baiHats",baiHats);
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("baiHatRequestDto", new BaiHatRepuestDto());
        return "create";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("baiHatRequestDto") BaiHatRepuestDto baiHatRepuestDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,Model model){
        BaiHat baiHat = new BaiHat();
        new BaiHatRepuestDto().validate(baiHatRepuestDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("baiHatRequestDto", baiHatRepuestDto);
            return "create";
        }
        BeanUtils.copyProperties(baiHatRepuestDto,baiHat);
        baiHatService.addOrUpdate(baiHat);
        redirectAttributes.addFlashAttribute("mess","thêm mới thành công");
        return "redirect:/bai_hat";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model){
        BaiHat baiHat = baiHatService.findById(id);
        BaiHatRepuestDto baiHatRepuestDto = new BaiHatRepuestDto();
        BeanUtils.copyProperties(baiHat,baiHatRepuestDto);
        model.addAttribute("baiHatRequestDto",baiHatRepuestDto);
        return "update";
    }
//    @PostMapping("/update")
//    public String update(@ModelAttribute("baiHat") BaiHat baiHat,
//                         RedirectAttributes redirectAttributes) {
//        baiHatService.addOrUpdate(baiHat);
//        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
//        return "redirect:/bai_hat";
//    }
}
