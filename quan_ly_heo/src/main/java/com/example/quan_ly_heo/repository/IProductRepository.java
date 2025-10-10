package com.example.quan_ly_heo.repository;

import com.example.quan_ly_heo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p where "+
    "((p.name = '' or p.name like concat('%',:name,'%'))"+
        "or (p.productCode = '' or p.productCode like concat('%',:name,'%')))"+
    "and (p.type.name = '' or p.type.name like concat('%',:nameType,'%') )")
    Page<Product> search(@Param("name") String name,
                         @Param("nameType")String nameType,
                         Pageable pageable);
}
