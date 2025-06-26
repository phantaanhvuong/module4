package com.example.ungdungnghenhac.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaiHatRepuestDto implements Validator {
    private Integer id;
    private String tenBaiHat;
    private String ngheSi;
    private String theLoai;
    @Override
    public boolean supports(Class<?> clazz) {
        return BaiHatRepuestDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BaiHatRepuestDto dto = (BaiHatRepuestDto) target;

        // Validate tenBaiHat
        if (dto.getTenBaiHat() == null || dto.getTenBaiHat().trim().isEmpty()) {
            errors.rejectValue("tenBaiHat", "tenBaiHat.empty", "Không được để trống");
        } else {
            if (dto.getTenBaiHat().length() > 800) {
                errors.rejectValue("tenBaiHat", "tenBaiHat.tooLong", "Không được vượt quá 800 ký tự");
            }
            if (!dto.getTenBaiHat().matches("^[\\p{L}\\p{N}\\s]+$")) {
                errors.rejectValue("tenBaiHat", "tenBaiHat.invalid", "Không được chứa ký tự đặc biệt");
            }
        }

        // Validate ngheSi
        if (dto.getNgheSi() == null || dto.getNgheSi().trim().isEmpty()) {
            errors.rejectValue("ngheSi", "ngheSi.empty", "Không được để trống");
        } else {
            if (dto.getNgheSi().length() > 300) {
                errors.rejectValue("ngheSi", "ngheSi.tooLong", "Không được vượt quá 300 ký tự");
            }
            if (!dto.getNgheSi().matches("^[\\p{L}\\p{N}\\s]+$")) {
                errors.rejectValue("ngheSi", "ngheSi.invalid", "Không được chứa ký tự đặc biệt");
            }
        }

        // Validate theLoai
        if (dto.getTheLoai() == null || dto.getTheLoai().trim().isEmpty()) {
            errors.rejectValue("theLoai", "theLoai.empty", "Không được để trống");
        } else {
            if (dto.getTheLoai().length() > 1000) {
                errors.rejectValue("theLoai", "theLoai.tooLong", "Không được vượt quá 1000 ký tự");
            }
            if (!dto.getTheLoai().matches("^[\\p{L}\\p{N}\\s,]+$")) {
                errors.rejectValue("theLoai", "theLoai.invalid", "Không được chứa ký tự đặc biệt ngoài dấu phẩy");
            }
        }

    }
}
