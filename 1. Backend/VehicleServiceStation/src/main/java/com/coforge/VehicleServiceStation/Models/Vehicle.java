package com.coforge.VehicleServiceStation.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(unique = true)
	String regNo;

	String model;
	@Column(unique = true)
	int engineNo;
	@Column(unique = true)
	int chasisNo;

	@ManyToOne
	Customer customer;

	@OneToMany(mappedBy = "vehicle")
	List<JobCard> jobCards;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}