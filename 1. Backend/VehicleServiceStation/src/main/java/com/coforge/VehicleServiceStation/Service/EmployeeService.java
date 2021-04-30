package com.coforge.VehicleServiceStation.Service;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Employee;
import com.coforge.VehicleServiceStation.Repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();

    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee add(Employee employee) {
        employee.setId(0);
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    public boolean delete(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;

    }

}
