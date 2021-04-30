package com.coforge.VehicleServiceStation.Controller;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Insurance;
import com.coforge.VehicleServiceStation.Service.InsuranceService;

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
@RequestMapping(path = "/insurance")
public class InsuranceController {
    @Autowired
    InsuranceService insuranceService;

    @GetMapping()
    public Iterable<Insurance> findAll() {
        return insuranceService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Insurance> findById(@PathVariable int id) {
        return insuranceService.findById(id);
    }

    @PostMapping()
    public Insurance add(@RequestBody Insurance insurance) {
        return insuranceService.add(insurance);
    }

    @PutMapping()
    public Insurance update(@RequestBody Insurance insurance) {
        return insuranceService.update(insurance);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return insuranceService.delete(id);
    }
}
