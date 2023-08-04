package com.codingdojo.licenciamanejo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.licenciamanejo.models.License;
import com.codingdojo.licenciamanejo.models.Person;
import com.codingdojo.licenciamanejo.services.LicenseService;
import com.codingdojo.licenciamanejo.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class LicenciaManejoController {

	// INTECCIÓN DEPENDENCIAS
	private final PersonService personService;
	private final LicenseService licenseService;

	public LicenciaManejoController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}

	// Show view New Person
	@GetMapping("/persons/new")
	public String showNewPerson(@ModelAttribute("newPerson") Person newPerson) {
		return "index.jsp";
	}

	// Create a New Person
	@PostMapping("/persons/new")
	public String createPerson(@Valid @ModelAttribute("newPerson") Person newPerson, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			personService.createPerson(newPerson);
			return "redirect:/licenses/new";
		}
	}

	// Show view New License
	@GetMapping("/licenses/new")
	public String showNewLicense(Model model, @ModelAttribute("newLicense") License newLicense) {
		List<Person> listPersons = personService.findAllPersons();
		model.addAttribute("listPersons", listPersons);
		return "newlicense.jsp";
	}

	// Create a New License
	@PostMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute("newLicense") License newLicense, BindingResult result) {
		if (result.hasErrors()) {
			return "newlicense.jsp";
		} else {
			String licenseNumber = "00000" + newLicense.getPerson().getId();
			newLicense.setNumber(licenseNumber);
			licenseService.createLicense(newLicense);
//			return "redirect:/persons/{personId}";
			return "redirect:/licenses/new";
		}
	}

	// Show view Profile Page
	@GetMapping("/persons/{id}")
	public String showProfilePage(@PathVariable("id") Long id, Model model) {
		Optional<Person> personOptional = personService.findPersonById(id);
		Person person = personOptional.orElse(null);
		model.addAttribute("person", person);

		return "profilepage.jsp";
	}

}
