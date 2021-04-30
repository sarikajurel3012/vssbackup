package com.coforge.VehicleServiceStation.Controller;

import com.coforge.VehicleServiceStation.Models.User;
import com.coforge.VehicleServiceStation.Service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/vss")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"" .equals(tempEmailId)) {
		  User userobj = registrationService.fetchUserByEmailId(tempEmailId);
		  if(userobj != null) {
			  throw new Exception("user with "+tempEmailId+" is already exist");
		  }
		}
		User userobj = null ;
		userobj = registrationService.saveUser(user);
		return userobj;
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		User userobj =  null;
		if(tempEmailId != null && tempPassword != null) {
		userobj = registrationService.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		if(userobj == null) {
			throw new Exception("Bad credentials");
		}
		return userobj;
	}
}
