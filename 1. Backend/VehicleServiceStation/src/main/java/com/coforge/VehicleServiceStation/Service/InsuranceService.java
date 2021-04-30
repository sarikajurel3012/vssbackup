package com.coforge.VehicleServiceStation.Service;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Insurance;
import com.coforge.VehicleServiceStation.Repository.InsuranceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {
    @Autowired
    InsuranceRepository insuranceRepository;

    public Iterable<Insurance> findAll() {
        return insuranceRepository.findAll();

    }

    public Optional<Insurance> findById(int id) {
        return insuranceRepository.findById(id);
    }

    public Insurance add(Insurance insurance) {
        insurance.setId(0);
        return insuranceRepository.save(insurance);
    }

    public Insurance update(Insurance insurance) {
        if (insuranceRepository.existsById(insurance.getId())) {
            return insuranceRepository.save(insurance);
        }
        return null;
    }

    public boolean delete(int id) {
        if (insuranceRepository.existsById(id)) {
            insuranceRepository.deleteById(id);
            return true;
        }
        return false;

    }

}
