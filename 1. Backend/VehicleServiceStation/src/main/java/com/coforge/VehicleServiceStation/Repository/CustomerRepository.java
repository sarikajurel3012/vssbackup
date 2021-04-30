package com.coforge.VehicleServiceStation.Repository;

import com.coforge.VehicleServiceStation.Models.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
