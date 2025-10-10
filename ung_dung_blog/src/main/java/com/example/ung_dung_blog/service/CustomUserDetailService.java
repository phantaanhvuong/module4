//package com.example.ung_dung_blog.service;
//
//import com.example.ung_dung_blog.model.AppUser;
//import com.example.ung_dung_blog.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.stream.Collectors;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AppUser u = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        var auths = u.getRoles().stream()
//                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName()))
//                .collect(Collectors.toSet());
//        return new org.springframework.security.core.userdetails.User(
//                u.getUsername(), u.getPassword(), u.isEnabled(),
//                true, true, true, auths);
//    }
//}
