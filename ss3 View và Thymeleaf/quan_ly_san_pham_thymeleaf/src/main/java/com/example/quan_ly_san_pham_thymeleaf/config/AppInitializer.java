package com.example.quan_ly_san_pham_thymeleaf.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // hoặc dùng cho persistence (JPA, Security...), không phải WebMvc
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfiguration.class}; // <-- sửa lại ở đây
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}


