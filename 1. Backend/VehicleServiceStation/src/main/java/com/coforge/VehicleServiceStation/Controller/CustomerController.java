package com.coforge.VehicleServiceStation.Controller;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Customer;
import com.coforge.VehicleServiceStation.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping()
    public Iterable<Customer> findAll() {
        var allCustomers = customerService.findAll();
        allCustomers.forEach(x -> {
            x.getVehicles().forEach(v -> {
                v.setCustomer(null);
                v.setJobCards(null);
            });
            x.getBills().forEach(b -> {
                b.setCustomer(null);
                b.getService().getJobcard().getVehicle().setCustomer(null);
                b.getService().getJobcard().getVehicle().setJobCards(null);
            });
        });
        return allCustomers;
    }

    @GetMapping("/{id}")
    public Optional<Customer> findById(@PathVariable int id) {
        var customer = customerService.findById(id);
        if (customer.isPresent()) {
            customer.get().getVehicles().forEach(cv -> cv.setCustomer(null));
        }
        return customer;
    }

    @PostMapping()
    public Customer add(@RequestBody Customer customer) {
        return customerService.add(customer);
    }

    @PutMapping()
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return customerService.delete(id);
    }
}
