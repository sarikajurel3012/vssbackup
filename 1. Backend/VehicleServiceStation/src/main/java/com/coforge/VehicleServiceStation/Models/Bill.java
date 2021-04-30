package com.coforge.VehicleServiceStation.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	double labourCharges;

	double serviceCharges;

	// @OneToOne
	// Insurance insurance;

	@ManyToOne 
	Customer customer;

	@OneToOne
	Service service;

	LocalDate date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
