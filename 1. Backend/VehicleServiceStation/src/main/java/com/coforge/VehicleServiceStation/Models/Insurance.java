package com.coforge.VehicleServiceStation.Models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Entity
public class Insurance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	LocalDate date;
	int duration;
	double amount;
	String nominee;
	
	@OneToOne
	Vehicle vehicle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
