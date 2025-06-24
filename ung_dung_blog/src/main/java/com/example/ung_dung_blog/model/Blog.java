package com.example.ung_dung_blog.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tieuDe;
    private String tomTatNoiDung;
    @Column(columnDefinition = "TEXT")
    private String noiDungChiTiet;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}