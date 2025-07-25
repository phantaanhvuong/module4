package com.example.tu_dien.config;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;


@WebFilter(value = "*")
public class FilterUTF8 extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException, IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        chain.doFilter(req, res);
    }
}
