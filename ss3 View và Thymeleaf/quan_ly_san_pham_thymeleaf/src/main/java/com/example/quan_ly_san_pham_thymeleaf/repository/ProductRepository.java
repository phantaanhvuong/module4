package com.example.quan_ly_san_pham_thymeleaf.repository;

import com.example.quan_ly_san_pham_thymeleaf.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    private static final List<Product> products = new ArrayList<>();
    private static int currentId = 1;

    static {
        products.add(new Product(1,"Iphone1","Mỹ",123456));
        products.add(new Product(2,"Iphone2","Anh",331123));
        products.add(new Product(3,"Iphone3","Pháp",321132));
        products.add(new Product(4,"Iphone4","Việt Nam",6446));
        products.add(new Product(5,"Iphone5","Lào",78678557));
        products.add(new Product(6,"Iphone6","Thái lan",97957));
    }


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        product.setId(currentId++);
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()==id){
                products.set(i,product);
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()== id){
                products.remove(i);
                return;
            }
        }
    }
}
