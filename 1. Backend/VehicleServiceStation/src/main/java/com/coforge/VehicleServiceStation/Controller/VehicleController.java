package com.coforge.VehicleServiceStation.Controller;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Vehicle;
import com.coforge.VehicleServiceStation.Service.VehicleService;

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
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping()
    public Iterable<Vehicle> findAll() {
        var allVehicle = vehicleService.findAll();
        allVehicle.forEach(v -> {
            v.getCustomer().setVehicles(null);
            v.getCustomer().setBills(null);
            v.getJobCards().forEach(jc -> jc.setVehicle(null));
        });
        return allVehicle;
    }

    @GetMapping("/{id}")
    public Optional<Vehicle> findById(@PathVariable int id) {
        return vehicleService.findById(id);
    }

    @PostMapping()
    public Vehicle add(@RequestBody Vehicle vehicle) {
        // return vehicle;
        return vehicleService.add(vehicle);
    }

    @PutMapping()
    public Vehicle update(@RequestBody Vehicle vehicle) {
        return vehicleService.update(vehicle);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return vehicleService.delete(id);
    }
}