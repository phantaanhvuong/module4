package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepository implements IProductRepository{
    private static final List<Product> products = new ArrayList<>();
    static {
        products.add(1,new Product(1,"Iphone1","Mỹ",123456));
        products.add(2,new Product(2,"Iphone2","Anh",331123));
        products.add(3,new Product(3,"Iphone3","Pháp",321132));
        products.add(4,new Product(4,"Iphone4","Việt Nam",6446));
        products.add(5,new Product(5,"Iphone5","Lào",78678557));
        products.add(6,new Product(6,"Iphone6","Thái lan",97957));
    }




    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
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
                products.set(id,product);
            }
        }
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
