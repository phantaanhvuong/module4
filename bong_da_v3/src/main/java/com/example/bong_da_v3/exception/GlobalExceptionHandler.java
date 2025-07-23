package com.example.bong_da_v3.exception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Bắt lỗi 404 - Không tìm thấy route
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFound(Exception ex, Model model, HttpServletRequest request) {
        model.addAttribute("message", "Không tìm thấy đường dẫn: " + request.getRequestURI());
        return "error";
    }

    // Bắt lỗi chung (bao gồm 500)
    @ExceptionHandler(Exception.class)
    public String handleAllException(Exception ex, Model model, HttpServletRequest request) {
        model.addAttribute("message", "Đã xảy ra lỗi không xác định! Vui lòng thử lại sau.");
        // In log nếu cần debug
        ex.printStackTrace();
        return "error";
    }
}
