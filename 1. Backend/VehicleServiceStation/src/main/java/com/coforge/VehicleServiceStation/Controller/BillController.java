package com.coforge.VehicleServiceStation.Controller;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Bill;
import com.coforge.VehicleServiceStation.Service.BillService;

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
@RequestMapping(path = "/bill")
public class BillController {
    @Autowired
    BillService billService;

    @GetMapping()
    public Iterable<Bill> findAll() {
        var all = billService.findAll();
        all.forEach(b -> {
            b.getCustomer().setVehicles(null);
            b.getCustomer().setBills(null);
            b.getService().getJobcard().getVehicle().getCustomer().setVehicles(null);
            b.getService().getJobcard().getVehicle().setCustomer(null);
            b.getService().getJobcard().getVehicle().setJobCards(null);
        });
        return all;
    }

    @GetMapping("/{id}")
    public Optional<Bill> findById(@PathVariable int id) {
        return billService.findById(id);
    }

    @PostMapping()
    public Bill add(@RequestBody Bill bill) {
        return billService.add(bill);
    }

    @PutMapping()
    public Bill update(@RequestBody Bill bill) {
        return billService.update(bill);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return billService.delete(id);
    }
}
