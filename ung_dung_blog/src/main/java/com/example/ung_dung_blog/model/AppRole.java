package com.example.ung_dung_blog.model;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class AppRole {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    public AppRole(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AppRole() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
