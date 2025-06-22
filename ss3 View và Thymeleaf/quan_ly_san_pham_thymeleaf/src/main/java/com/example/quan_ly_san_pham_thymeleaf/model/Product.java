package com.example.quan_ly_san_pham_thymeleaf.model;

public class Product {
    private int id;
    private String name;
    private String noiSanXuat;
    private double gia;

    public Product() {
    }

    public Product(int id, String name, String noiSanXuat, double gia) {
        this.id = id;
        this.name = name;
        this.noiSanXuat = noiSanXuat;
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoiSanXuat() {
        return noiSanXuat;
    }

    public void setNoiSanXuat(String noiSanXuat) {
        this.noiSanXuat = noiSanXuat;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
