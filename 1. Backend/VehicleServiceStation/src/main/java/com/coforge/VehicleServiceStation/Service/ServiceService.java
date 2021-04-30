package com.coforge.VehicleServiceStation.Service;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Service;
import com.coforge.VehicleServiceStation.Repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    public Iterable<Service> findAll() {
        return serviceRepository.findAll();

    }

    public Optional<Service> findById(int id) {
        return serviceRepository.findById(id);
    }

    public Service add(Service service) {
        service.setId(0);
        return serviceRepository.save(service);
    }

    public Service update(Service service) {
        if (serviceRepository.existsById(service.getId())) {
            return serviceRepository.save(service);
        }
        return null;
    }

    public boolean delete(int id) {
        if (serviceRepository.existsById(id)) {
            serviceRepository.deleteById(id);
            return true;
        }
        return false;

    }

}
