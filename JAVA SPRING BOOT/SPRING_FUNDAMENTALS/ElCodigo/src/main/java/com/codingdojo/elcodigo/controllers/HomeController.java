package com.codingdojo.elcodigo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String showIndex(){
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String showIndex(@RequestParam("password") String userPassword) {
		if(userPassword.equals("bushido")) {
			return "redirect:/code";
		}else {
			return "redirect:/createError";
		}
	}
	
	@GetMapping("/code")
	public String showCode() {
		return "code.jsp";
	}

	@GetMapping("/createError")
	public String showError(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
}
