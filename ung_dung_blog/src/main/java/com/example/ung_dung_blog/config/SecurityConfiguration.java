//package com.example.ung_dung_blog.config;
//
//import com.example.ung_dung_blog.service.CustomUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    @Autowired
//    private CustomUserDetailService uds;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // Bảo mật cao
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/blogs", true)
//                        .failureHandler((req, res, ex) -> {
//                            ex.printStackTrace(); // LOG nguyên nhân
//                            res.sendRedirect("/login?error");
//                        })
//                )
//
//
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/", "/blogs", "/blogs/", "/blogs/**", "/blogs/detail/**", "/register", "/login", "/css/**", "/js/**").permitAll()
//                        .requestMatchers("/blogs/create", "/blogs/save", "/blogs/delete", "/blogs/*/edit").authenticated()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/blogs", true)
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/blogs")
//                );
//
//        return http.build();
//    }
//
//
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        builder.userDetailsService(uds).passwordEncoder(passwordEncoder());
//        return builder.build();
//    }
//}
