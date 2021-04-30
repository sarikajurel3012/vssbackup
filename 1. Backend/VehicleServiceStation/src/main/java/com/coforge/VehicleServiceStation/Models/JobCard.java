package com.coforge.VehicleServiceStation.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class JobCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@OneToOne
	Service service;

	String issues;
	String remarks;

	@ManyToOne
	Vehicle vehicle;

	@CreationTimestamp
	LocalDate date;

}
