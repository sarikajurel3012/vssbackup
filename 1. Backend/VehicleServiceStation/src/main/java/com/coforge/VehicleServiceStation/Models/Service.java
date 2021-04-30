package com.coforge.VehicleServiceStation.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@OneToOne
	JobCard jobcard;
	String type;
	String addParts;

	@OneToOne
	Employee employee;

	@OneToOne
	Feedback feedback;

	LocalDate date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
