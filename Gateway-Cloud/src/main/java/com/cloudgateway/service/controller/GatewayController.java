package com.cloudgateway.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;


@RestController
public class GatewayController {
	
	@GetMapping("/authfallback")
	private LinkedHashMap<String, Object> authFallback(){
		
		LinkedHashMap<String, Object> obj = new LinkedHashMap<String, Object>();
		obj.put("message", "The auth service one is down please try again later!!!!!!!!");
		return obj;
	}
	
	@GetMapping("/fallback1")
	private LinkedHashMap<String, Object> microservice1Fallback(){
		
		LinkedHashMap<String, Object> obj = new LinkedHashMap<String, Object>();
		obj.put("message", "The service one is down please try again later!!!!!!!!");
		return obj;
	}
	
	@GetMapping("/fallback2")
	private LinkedHashMap<String, Object> microservice2Fallback(){
		
		LinkedHashMap<String, Object> obj = new LinkedHashMap<String, Object>();
		obj.put("message", "The service two is down please try again later!!!!!!!!");
		return obj;
	}

}
