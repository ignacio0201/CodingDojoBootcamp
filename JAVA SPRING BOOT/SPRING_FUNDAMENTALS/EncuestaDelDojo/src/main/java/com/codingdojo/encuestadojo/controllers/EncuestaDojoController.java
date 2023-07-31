package com.codingdojo.encuestadojo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class EncuestaDojoController {
	
	@GetMapping("/")
	public String showIndex() {
		return "index.jsp";
	}
	
	@PostMapping("/result")
	public String showIndex(Model model,
			@RequestParam("name") String name,
			@RequestParam("dojoLocation") String dojoLocation,
			@RequestParam("favoriteLanguage") String favoriteLanguage,
			@RequestParam(value="comment", required=false) String comment){
		model.addAttribute("name", name);
		model.addAttribute("dojoLocation", dojoLocation);
		model.addAttribute("favoriteLanguage", favoriteLanguage);
		model.addAttribute("comment", comment);
		return "result.jsp";
	}
	
	
	
	
}
