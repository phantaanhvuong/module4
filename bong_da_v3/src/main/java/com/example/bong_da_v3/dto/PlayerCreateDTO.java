package com.example.bong_da_v3.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PlayerCreateDTO {
    private String playerCode;
    private String name;
    private LocalDate birthday;
    private Long locationId;
    private String status;
}
