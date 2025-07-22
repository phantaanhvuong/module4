package com.example.quanlycauthubongdav2.controller;

import com.example.quanlycauthubongdav2.entity.Location;
import com.example.quanlycauthubongdav2.entity.Player;
import com.example.quanlycauthubongdav2.service.ILocationService;
import com.example.quanlycauthubongdav2.service.IPlayerService;
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
import java.util.Optional;

@Controller
@RequestMapping("players")
public class PlayerController {
    @Autowired
    private ILocationService locationService;
    @Autowired
    private IPlayerService playerService;
    @ModelAttribute("locationList")
    private List<Location> getAllLocation(){
        return locationService.findAll();
    }
    @GetMapping("")
    public String showList(@RequestParam(required = false, defaultValue = "0") int page,
                           @RequestParam(required = false, defaultValue = "5") int size,
                           @RequestParam(required = false, defaultValue = "") String name,
                           Model model){
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Player> playerPage = playerService.findByName(name, pageable);
        model.addAttribute("name", name);
        model.addAttribute("playerPage",playerPage);
        return "index";

    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("player" , new Player());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Player player, RedirectAttributes redirectAttributes){
        playerService.addOrUpdate(player);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");
        return "redirect:/players";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model ){
        Optional<Player> player = playerService.findById(id);
        if (player.isPresent()) {
            model.addAttribute("player", player.get());
            return "update";
        } else {
            redirectAttributes.addFlashAttribute("mess", "Không tìm thấy đối tượng cần sửa");
            return "redirect:/players";
        }
    }
    @PostMapping("/delete")
    public String delete(Player player, RedirectAttributes redirectAttributes){
        playerService.deleteById(player.getId());
        redirectAttributes.addFlashAttribute("success", " Xoá Thành công");
        return "redirect:/players";

    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(name ="id")Long id , Model model){
        Optional<Player> player = playerService.findById(id);
        model.addAttribute("player", player);
        return "view";
    }
}
