package com.example.ungdungmuonsachaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookChangeLogger {
    @After("execution(* com.example.ungdungmuonsachaop.service.BorrowService.*(..))")
    public void logChange(JoinPoint joinPoint) {
        System.out.println("[LOG] sách đã thay đổi qua: " + joinPoint.getSignature().getName());
    }

}
