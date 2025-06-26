package com.example.validateformdangky.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotEmpty(message = "không được để trống")
    @Size(min = 5,max = 45,message = "độ dài tối thiểu là 5 và tối đa 45 ký tự")
    private String firstName;

    @NotEmpty(message = "không được để trống")
    @Size(min = 5,max = 45,message = "độ dài tối thiểu là 5 và tối đa 45 ký tự")
    private String lastName;

    @Pattern(regexp = "^0[0-9]{9,10}$",message = "sai định dạng số điện thoại")
    private String phoneNumber;

    @Min(value = 18,message = "tuổi phải lớn hơn hoặc bằng 18")
    private int age;

    @NotEmpty(message = "email không được để trống")
    @Email(message = "sai định dạng email")
    private String email;

}
