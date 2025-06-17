package spring.mvc.quanlykhachhang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.mvc.quanlykhachhang.entity.Customer;
import spring.mvc.quanlykhachhang.repository.CustomerRepository;
import spring.mvc.quanlykhachhang.repository.ICustomerRepository;

import java.util.List;
@Service
public class CustomerService implements  ICustomerService{
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }
}
