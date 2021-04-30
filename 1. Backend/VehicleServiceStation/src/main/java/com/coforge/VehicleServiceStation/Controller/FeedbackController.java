package com.coforge.VehicleServiceStation.Controller;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Feedback;
import com.coforge.VehicleServiceStation.Service.FeedbackService;

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
@RequestMapping(path = "/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @GetMapping()
    public Iterable<Feedback> findAll() {
        return feedbackService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Feedback> findById(@PathVariable int id) {
        return feedbackService.findById(id);
    }

    @PostMapping()
    public Feedback add(@RequestBody Feedback feedback) {
        return feedbackService.add(feedback);
    }

    @PutMapping()
    public Feedback update(@RequestBody Feedback feedback) {
        return feedbackService.update(feedback);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return feedbackService.delete(id);
    }
}
