package com.example.demo_spring_boot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean gender;

    @OneToOne
    @JoinColumn(name = "username", unique = true)
    private Jame jame;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassCG classCG;

}
