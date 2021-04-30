package com.coforge.VehicleServiceStation.Service;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.JobCard;
import com.coforge.VehicleServiceStation.Repository.JobCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobCardService {
    @Autowired
    JobCardRepository jobcardRepository;

    public Iterable<JobCard> findAll() {
        return jobcardRepository.findAll();

    }

    public Optional<JobCard> findById(int id) {
        return jobcardRepository.findById(id);
    }

    public JobCard add(JobCard jobcard) {
        jobcard.setId(0);
        return jobcardRepository.save(jobcard);
    }

    public JobCard update(JobCard jobcard) {
        if (jobcardRepository.existsById(jobcard.getId())) {
            return jobcardRepository.save(jobcard);
        }
        return null;
    }

    public boolean delete(int id) {
        if (jobcardRepository.existsById(id)) {
            jobcardRepository.deleteById(id);
            return true;
        }
        return false;

    }

}
