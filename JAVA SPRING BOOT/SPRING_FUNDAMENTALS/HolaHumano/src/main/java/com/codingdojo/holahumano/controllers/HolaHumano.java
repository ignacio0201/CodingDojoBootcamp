package com.codingdojo.holahumano.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaHumano {
	
	@RequestMapping("/")
	public String saludarHumano(
			@RequestParam(value="name", required=false) String yourFirstName,
			@RequestParam(value="lastname", required=false) String yourLastName){
		String messageWelcome = "<h3>Welcome to SpringBoot!</h3>";
		String messageFirstName = String.format("<h1>Hello %s!</h1>", yourFirstName) + messageWelcome;
		String messageFullName = String.format("<h1>Hello %s %s!</h1>", yourFirstName, yourLastName) + messageWelcome;
		
		if(yourFirstName == null && yourLastName == null){
			return "<h1>Hello Human!</h1>" + messageWelcome;
		}
		
		else if(!yourFirstName.isEmpty() && yourLastName == null) {
			return messageFirstName;
		}
		else if(!yourFirstName.isEmpty() && !yourLastName.isEmpty()) {
			return messageFullName;
		}
		else {
			return "<h1>No se encontro la ruta</h1>";
		}		
	}
}