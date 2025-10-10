//package com.example.ung_dung_blog.controller;
//
//import com.example.ung_dung_blog.model.AppRole;
//import com.example.ung_dung_blog.model.AppUser;
//import com.example.ung_dung_blog.repository.RoleRepository;
//import com.example.ung_dung_blog.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//public class
//AuthController {
//    @Autowired
//    private UserRepository userRepo;
//    @Autowired
//    private RoleRepository roleRepo;
//    @Autowired
//    private PasswordEncoder encoder;
//
//    @GetMapping("/register")
//    public String showRegister(Model model) {
//        model.addAttribute("userForm", new AppUser());
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String register(@ModelAttribute("userForm") AppUser u, RedirectAttributes ra) {
//        u.setPassword(encoder.encode(u.getPassword()));
//        u.setEnabled(true);
//        AppRole roleUser = roleRepo.findByName("USER")
//                .orElseGet(() -> roleRepo.save(new AppRole(null, "USER")));
//        u.getRoles().add(roleUser);
//        userRepo.save(u);
//        ra.addFlashAttribute("msg", "Đăng ký thành công. Mời đăng nhập.");
//        return "redirect:/login";
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//}
