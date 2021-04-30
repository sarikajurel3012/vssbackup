package com.coforge.VehicleServiceStation.Service;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Feedback;
import com.coforge.VehicleServiceStation.Repository.FeedbackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    public Iterable<Feedback> findAll() {
        return feedbackRepository.findAll();

    }

    public Optional<Feedback> findById(int id) {
        return feedbackRepository.findById(id);
    }

    public Feedback add(Feedback feedback) {
        feedback.setId(0);
        return feedbackRepository.save(feedback);
    }

    public Feedback update(Feedback feedback) {
        if (feedbackRepository.existsById(feedback.getId())) {
            return feedbackRepository.save(feedback);
        }
        return null;
    }

    public boolean delete(int id) {
        if (feedbackRepository.existsById(id)) {
            feedbackRepository.deleteById(id);
            return true;
        }
        return false;

    }

}
