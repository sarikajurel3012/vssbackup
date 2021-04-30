package com.coforge.VehicleServiceStation.Controller;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.JobCard;
import com.coforge.VehicleServiceStation.Service.JobCardService;

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
@RequestMapping(path = "/jobcard")
public class JobCardController {
    @Autowired
    JobCardService jobcardService;

    @GetMapping()
    public Iterable<JobCard> findAll() {
        var all = jobcardService.findAll();
        all.forEach(jc -> {
            jc.getVehicle().setJobCards(null);
            jc.getVehicle().getCustomer().setVehicles(null);
            jc.getVehicle().getCustomer().setBills(null);
        });
        return all;
    }

    @GetMapping("/{id}")
    public Optional<JobCard> findById(@PathVariable int id) {
        return jobcardService.findById(id);
    }

    @PostMapping()
    public JobCard add(@RequestBody JobCard jobcard) {
        return jobcardService.add(jobcard);
    }

    @PutMapping()
    public JobCard update(@RequestBody JobCard jobcard) {
        return jobcardService.update(jobcard);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return jobcardService.delete(id);
    }
}
