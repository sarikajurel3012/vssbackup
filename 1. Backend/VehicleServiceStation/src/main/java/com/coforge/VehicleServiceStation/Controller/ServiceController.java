package com.coforge.VehicleServiceStation.Controller;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Service;
import com.coforge.VehicleServiceStation.Service.ServiceService;

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
@RequestMapping(path = "/service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @GetMapping()
    public Iterable<Service> findAll() {
        var all = serviceService.findAll();
        all.forEach(s->{
            s.getJobcard().getVehicle().getCustomer().setVehicles(null);
            s.getJobcard().getVehicle().getCustomer().setBills(null);
            s.getJobcard().getVehicle().setJobCards(null);
        });
        return all;
    }

    @GetMapping("/{id}")
    public Optional<Service> findById(@PathVariable int id) {
        return serviceService.findById(id);
    }

    @PostMapping()
    public Service add(@RequestBody Service service) {
        return serviceService.add(service);
    }

    @PutMapping()
    public Service update(@RequestBody Service service) {
        return serviceService.update(service);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return serviceService.delete(id);
    }
}
