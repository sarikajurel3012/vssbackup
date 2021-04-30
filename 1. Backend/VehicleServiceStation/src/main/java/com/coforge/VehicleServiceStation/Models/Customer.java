package com.coforge.VehicleServiceStation.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String contact;
	String address;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	List<Vehicle> vehicles;

	@OneToMany(mappedBy = "customer")
	List<Bill> bills;	
	
}
