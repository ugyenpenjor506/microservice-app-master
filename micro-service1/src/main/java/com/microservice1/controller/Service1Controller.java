package com.microservice1.controller;

import javax.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microservice1")
public class Service1Controller {
	
	
	@GetMapping("/hello")
	@RolesAllowed({"developer","manager"})
	public String helloController() {
		return "Hello World both developer and manager!!!!!!!!";
	}
	
	@GetMapping("/dev1")
	@RolesAllowed("developer")
	public String DevloperController() { 
		return "welome to Developer world!!!!!!!!!";
	}
	
	@GetMapping("/man1")
	@RolesAllowed("manager")
	public String managerController() {
		return "welcome to Manager world!!!!!!!!!!!!";
	}
}
