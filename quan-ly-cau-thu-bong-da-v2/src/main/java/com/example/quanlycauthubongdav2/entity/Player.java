package com.example.quanlycauthubongdav2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String playerCode;


    @NotEmpty(message = "Không được để trống")
    @Size(min = 5,max = 100,message = "tên ít nhất 5 ký tự và tối đa 100 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "Tên không được chứa các ký tự đặt biệt")
    private String name;


    private LocalDate birthday;

    @Pattern(regexp = "^[1-9]*$", message = "Kinh nghiệm phải là số nguyên dương")
    private String experience;
    private String image;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
