package spring.mvc.quanlykhachhang.service;

import spring.mvc.quanlykhachhang.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
}
