package spring.mvc.quanlykhachhang.repository;

import org.springframework.stereotype.Repository;
import spring.mvc.quanlykhachhang.entity.Customer;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository{
    private static final List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Nguyen Van A", "a@gmail.com", "Ha Noi"));
        customers.add(new Customer(2, "Tran Thi B", "b@gmail.com", "Hue"));
        customers.add(new Customer(3, "Le Van C", "c@gmail.com", "Da Nang"));
    }
    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId()== id){
                return customer;
            }
        }
        return null;
    }
}
