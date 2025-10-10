package com.example.quan_ly_heo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "không được để trống")
    private String productCode;

    @Size(min = 5,max = 100,message = "tên ít nhất 5 ký tự và tối đa 100 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "Tên không được chứa các ký tự đặt biệt")
    private String name;

    @NotEmpty(message = "không được để trống")
    @Column(name = "description")
    private String describe;

    private double price;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

}
