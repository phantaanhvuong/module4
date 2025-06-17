package spring.mvc.quanlykhachhang.repository;

import spring.mvc.quanlykhachhang.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findById(int id);
}
