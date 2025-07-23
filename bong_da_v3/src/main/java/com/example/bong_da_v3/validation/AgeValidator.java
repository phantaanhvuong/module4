package com.example.bong_da_v3.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<ValidAge, LocalDate> {
    @Override
    public boolean isValid(LocalDate birthday, ConstraintValidatorContext constraintValidatorContext) {
        if (birthday == null){
            return false;
        }
        int age = Period.between(birthday,LocalDate.now()).getYears();
        return age >= 16 && age <= 100;
    }
}
