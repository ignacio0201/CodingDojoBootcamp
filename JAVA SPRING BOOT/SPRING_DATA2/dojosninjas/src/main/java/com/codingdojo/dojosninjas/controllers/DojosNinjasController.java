package com.codingdojo.dojosninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.services.DojoService;
import com.codingdojo.dojosninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class DojosNinjasController {

	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojosNinjasController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
		}
	
	
	//VISTA PARA REGISTRAR UN DOJO
	@GetMapping("/dojos/new")
	public String vistaRegistrarDojo(@ModelAttribute("nuevoDojo") Dojo nuevoDojo) {
		return "views/index.jsp";
	}
	//REGISTRAR UN DOJO
	@PostMapping("/dojos/new")
	public String registrarDojo(@Valid @ModelAttribute("nuevoDojo") Dojo nuevoDojo, BindingResult result) {
		if(result.hasErrors()) {
			return "views/index.jsp";
		}else {
			dojoService.crearDojo(nuevoDojo);
			return "redirect:/dojos/new";
		}	
	}
	//VISTA PARA REGISTRAR NINJAS EN UN DOJO
	@GetMapping("/ninjas/new")
	public String vistaRegistrarNinjasEnDojo(Model model, @ModelAttribute("nuevoNinja") Ninja nuevoNinja) {
		model.addAttribute("listaDojos", dojoService.mostrarTodosLosDojos());
		return "views/new_ninja.jsp";
	}
	//REGISTRAR NINJAS EN UN DOJO
	@PostMapping("/ninjas/new")
	public String registrarNinjasEnDojo(@Valid @ModelAttribute("nuevoNinja") Ninja nuevoNinja, BindingResult result) {
		if(result.hasErrors()) {
			return "views/new_ninja.jsp";
		}else {
			ninjaService.crearNinja(nuevoNinja);
			return "redirect:/ninjas/new";
		}
	}
	//MOSTRAR INFO DEL DOJO (LISTA DE NINJAS)
	@GetMapping("/dojos/{idDojo}")
	public String mostrarNinjasPorDojo(Model model, @PathVariable("idDojo") Long idDojo) {
		Dojo dojo = dojoService.buscarDojoPorId(idDojo);
		model.addAttribute("dojo", dojo);
		return "views/dojo_page.jsp";
	}
	
}