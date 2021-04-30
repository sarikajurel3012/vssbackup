package com.coforge.VehicleServiceStation.Service;

import java.util.Optional;

import com.coforge.VehicleServiceStation.Models.Bill;
import com.coforge.VehicleServiceStation.Repository.BillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    public Iterable<Bill> findAll() {
        return billRepository.findAll();

    }

    public Optional<Bill> findById(int id) {
        return billRepository.findById(id);
    }

    public Bill add(Bill bill) {
        bill.setId(0);
        return billRepository.save(bill);
    }

    public Bill update(Bill bill) {
        if (billRepository.existsById(bill.getId())) {
            return billRepository.save(bill);
        }
        return null;
    }

    public boolean delete(int id) {
        if (billRepository.existsById(id)) {
            billRepository.deleteById(id);
            return true;
        }
        return false;

    }

}