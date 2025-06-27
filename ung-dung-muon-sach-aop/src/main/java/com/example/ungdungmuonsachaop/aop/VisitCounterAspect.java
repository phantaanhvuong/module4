package com.example.ungdungmuonsachaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
@Aspect
@Component
public class VisitCounterAspect {
    private AtomicInteger count = new AtomicInteger(0);

    @Before("execution(* com.example.ungdungmuonsachaop.controller..*.*(..))")
    public void countVisit() {
        int current = count.incrementAndGet();
        System.out.println("[VISIT] Số lượng khách truy cập: " + current);
    }

}
