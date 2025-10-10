package com.example.quan_ly_san_pham_thymeleaf.repository;

import com.example.quan_ly_san_pham_thymeleaf.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        if (product.getId() != 0) {
            entityManager.merge(product);
        } else {
            entityManager.persist(product);
        }
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.id =:id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    @Override
    public List<Product> searchByName(String keyword) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where lower(p.name) like lower(concat('%',:keyword,'%'))", Product.class
        );
        query.setParameter("keyword", keyword);
        return query.getResultList();
    }
}
