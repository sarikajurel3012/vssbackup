package com.coforge.VehicleServiceStation.Service;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Customer;
import com.coforge.VehicleServiceStation.Repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();

    }

    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    public Customer add(Customer customer) {
        customer.setId(0);
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer) {
        if (customerRepository.existsById(customer.getId())) {
            return customerRepository.save(customer);
        }
        return null;
    }

    public boolean delete(int id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;

    }

}
