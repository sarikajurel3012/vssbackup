package com.coforge.VehicleServiceStation.Service;

import com.coforge.VehicleServiceStation.Models.User;
import com.coforge.VehicleServiceStation.Repository.RegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	public User saveUser(User user) {
		return registrationRepository.save(user);
	}
	
	public User fetchUserByEmailId(String email) {
	 return registrationRepository.findByEmailId(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String email, String password) {
		 return registrationRepository.findByEmailIdAndPassword(email, password);
		}

}
