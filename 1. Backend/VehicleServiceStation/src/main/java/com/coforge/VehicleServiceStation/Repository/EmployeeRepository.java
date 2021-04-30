package com.coforge.VehicleServiceStation.Repository;

import com.coforge.VehicleServiceStation.Models.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
