package com.coforge.VehicleServiceStation.Controller;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Employee;
import com.coforge.VehicleServiceStation.Service.EmployeeService;

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
@RequestMapping(path = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public Iterable<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping()
    public Employee add(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @PutMapping()
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return employeeService.delete(id);
    }
}
