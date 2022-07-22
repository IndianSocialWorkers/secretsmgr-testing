package com.testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SecretMgrTestingController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping
	public ResponseEntity<Object> fetchAllSecrets(){
		String mysecret = environment.getProperty("mysecret");
		if(mysecret==null) 
			mysecret="none";
		
		return new ResponseEntity<>("My secret fetched value : "+mysecret, HttpStatus.OK);
	}
}
