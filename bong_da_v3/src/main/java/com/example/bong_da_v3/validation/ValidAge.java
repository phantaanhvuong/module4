package com.example.bong_da_v3.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAge {
    String message() default "Tuổi phải nằm trong khoảng từ 16 đến 100";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
