package com.coforge.VehicleServiceStation.Service;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Vehicle;
import com.coforge.VehicleServiceStation.Repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public Iterable<Vehicle> findAll() {
        return vehicleRepository.findAll();

    }

    public Optional<Vehicle> findById(int id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle add(Vehicle vehicle) {
        vehicle.setId(0);
        return vehicleRepository.save(vehicle);
    }

    public Vehicle update(Vehicle vehicle) {
        if (vehicleRepository.existsById(vehicle.getId())) {
            return vehicleRepository.save(vehicle);
        }
        return null;
    }

    public boolean delete(int id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return true;
        }
        return false;

    }

}
