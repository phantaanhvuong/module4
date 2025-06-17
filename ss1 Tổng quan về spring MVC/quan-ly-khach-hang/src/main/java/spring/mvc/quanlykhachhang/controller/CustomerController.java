package spring.mvc.quanlykhachhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import spring.mvc.quanlykhachhang.entity.Customer;
import spring.mvc.quanlykhachhang.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList() {
        List<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("customers/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/customers/{id}")
    public ModelAndView viewCustomer(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        return new ModelAndView("view", "customer", customer);
    }
}
