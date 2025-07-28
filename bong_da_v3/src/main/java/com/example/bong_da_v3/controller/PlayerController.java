package com.example.bong_da_v3.controller;

import com.example.bong_da_v3.entity.Location;
import com.example.bong_da_v3.entity.Player;
import com.example.bong_da_v3.service.ILocationService;
import com.example.bong_da_v3.service.IPlayerService;
import com.example.bong_da_v3.service.PlayerService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                           @RequestParam(required = false, defaultValue = "") String nameLocation,
                           Model model){
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Player> playerPage = playerService.search(name,nameLocation,pageable);
        model.addAttribute("name", name);
        model.addAttribute("nameLocation" ,nameLocation);
        model.addAttribute("playerPage",playerPage);
        return "index";

    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("player" , new Player());
        return "create";
    }
    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("player") Player player, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (player.getStatus() == null || player.getStatus().isBlank()) {
            player.setStatus("Dự bị");
        }
        if(bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
            return "create";
        }
        playerService.add(player);
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
            redirectAttributes.addFlashAttribute("errors", "Không tìm thấy đối tượng cần sửa");
            return "redirect:/players";
        }
    }
    @PostMapping("/{id}/edit")
    public String processEdit(@Validated @ModelAttribute Player player , BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Model model, @PathVariable Long id) {
        if(bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
            return "update";
        }
        if(playerService.findById(id).isEmpty()) {
            model.addAttribute("errors", "Không tìm thấy đối tuọng cần sửa");
            return "update";
        }
        playerService.edit(player, id);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");
        return "redirect:/players";

    }

    @PostMapping("/delete")
    public String delete(Player player, RedirectAttributes redirectAttributes){
        Optional<Player> player1 = playerService.findById(player.getId());
        if (player1.isPresent()) {
            playerService.deleteById(player.getId());
            redirectAttributes.addFlashAttribute("success", " Xoá Thành công");
        } else {
            redirectAttributes.addFlashAttribute("errors", "Không tìm thấy đối tượng cần xoá");
        }
        return "redirect:/players";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(name ="id")Long id ,RedirectAttributes redirectAttributes, Model model){
        Optional<Player> player = playerService.findById(id);
        if (player.isPresent()){
            model.addAttribute("player", player);
            return "view";
        }else {
            redirectAttributes.addFlashAttribute("errors", "Không tìm thấy đối tượng cần sửa");
            return "redirect:/players";
        }
    }

    @PostMapping("/{id}/toggle-status")
    public String toggleStatus(@PathVariable Long id , RedirectAttributes redirectAttributes,Model model) {
        Optional<Player> player = playerService.findById(id);
        if (player.isEmpty()) {
            redirectAttributes.addFlashAttribute("errors", "Không tìm thấy cầu thủ");
            return "redirect:/players";
        }
        Player player2 = player.get();
        String oldStatus = player2.getStatus();
        if ("Dự bị".equals(oldStatus)) {
            long count = playerService.countByStatus("Đã đăng ký");
            if (count >= 11) {
                model.addAttribute("message", "Không được quá 11 người đăng ký trong 1 đội bóng");
                return "error";
            }
            player2.setStatus("Đã đăng ký");
        } else {
            player2.setStatus("Dự bị");
        }
        playerService.save(player2);
        System.out.println("[ghi log]Trạng thái cầu thủ "+ player2.getName()+":"+ oldStatus+"-->" +player2.getStatus());
        long countRegister = playerService.countByStatus("Đã đăng ký");
        System.out.println("[ghi log]Tổng số cầu thủ đã đăng ký: "+countRegister);
        redirectAttributes.addFlashAttribute("success","Cập nhật trạng thái thành công");
        return "redirect:/players";
    }
    @PostMapping("/favorite/{id}")
    public String addToFavorite(@PathVariable Long id,
                                HttpSession session,
                                HttpServletResponse response,
                                RedirectAttributes redirectAttributes) {
        // Lấy danh sách yêu thích từ session
        List<Long> favoriteList = (List<Long>) session.getAttribute("favorites");
        if (favoriteList == null) {
            favoriteList = new ArrayList<>();
        }

        // Thêm nếu chưa có cầu thủ nào được yêu thích
        if (favoriteList.contains(id)) {
            redirectAttributes.addFlashAttribute("warning", "Bạn đã yêu thích cầu thủ này rồi!");
        }else {
            favoriteList.add(id);
            session.setAttribute("favorites", favoriteList);
            // chuyeenr cái list thành chuổi
            String rawCookieValue = favoriteList.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(","));
            String encodedCookieValue = URLEncoder.encode(rawCookieValue, StandardCharsets.UTF_8);


            // tạo cookie
            Cookie cookie = new Cookie("favorites", encodedCookieValue);
            cookie.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
            cookie.setPath("/");
            response.addCookie(cookie);

            redirectAttributes.addFlashAttribute("success", "Đã thêm vào yêu thích!");
        }
        return "redirect:/players/detail/" + id;
    }

    @GetMapping("/favorites")
    public String showFavorites(HttpSession session,
                                @CookieValue(name = "favorites", defaultValue = "") String favoritesCookie,
                                Model model) {

        // tiếp tuch lấy danh sách yêu thích từ session
        List<Long> favoriteList = (List<Long>) session.getAttribute("favorites");

        // nếu session không có, thì lấy từ cookie
        if (favoriteList == null && !favoritesCookie.isEmpty()) {
            favoriteList = new ArrayList<>();

            try {
                String decodedCookie = URLDecoder.decode(favoritesCookie, StandardCharsets.UTF_8);
                String[] idStrings = decodedCookie.split(",");
                for (String idStr : idStrings) {
                    try {
                        Long id = Long.parseLong(idStr);
                        favoriteList.add(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Không thể chuyển '" + idStr + "' thành số.");
                    }
                }
                session.setAttribute("favorites", favoriteList);
            } catch (Exception e) {
                System.out.println("Lỗi khi decode cookie: " + e.getMessage());
            }
        }

        // từ list id lấy list player

        List<Player> favoritePlayers = new ArrayList<>();
        if (favoriteList != null) {
            for (Long playerId : favoriteList) {
                playerService.findById(playerId).ifPresent(favoritePlayers::add);
            }
        }

        model.addAttribute("favoritePlayers", favoritePlayers);
        return "favorite-list";
    }
    @PostMapping("/favorite/remove/{id}")
    public String removeFromFavorite(@PathVariable Long id,
                                     HttpSession session,
                                     HttpServletResponse response,
                                     RedirectAttributes redirectAttributes) {

        List<Long> favoriteList = (List<Long>) session.getAttribute("favorites");

        if (favoriteList != null && favoriteList.contains(id)) {
            favoriteList.remove(id);
            session.setAttribute("favorites", favoriteList);

            // Cập nhật lại cookie sau khi xoá
            String updatedCookie = favoriteList.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(","));
            String encodedCookie = URLEncoder.encode(updatedCookie, StandardCharsets.UTF_8);

            Cookie cookie = new Cookie("favorites", encodedCookie);
            cookie.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
            cookie.setPath("/");
            response.addCookie(cookie);

            redirectAttributes.addFlashAttribute("success", "Đã xoá khỏi yêu thích!");
        } else {
            redirectAttributes.addFlashAttribute("errors", "Cầu thủ không tồn tại trong danh sách yêu thích!");
        }

        return "redirect:/players/favorites";
    }



}
