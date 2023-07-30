package com.codingdojo.languages.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

import jakarta.validation.Valid;

@Controller
public class LanguageController {
	
	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	//Show view all languages and create index ok
	@GetMapping("/languages")
	public String index(Model model, @Valid @ModelAttribute("newLanguage") Language newLanguage, BindingResult result) {
		List<Language> allLanguages = languageService.allLanguages();
		model.addAttribute("allLanguages", allLanguages);
		return "/languages/index.jsp";
	}
	
	//Show view edit ok
	@GetMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
	    Language language = languageService.findLanguage(id);
	    model.addAttribute("language", language);
	    return "/languages/edit.jsp";
	}
	
	//Create a new language ok
	@PostMapping("/languages")
	public String createLanguage(Model model, @Valid @ModelAttribute("newLanguage") Language newLanguage, BindingResult result) {
		if (result.hasErrors()) {
			List<Language> allLanguages = languageService.allLanguages();
			model.addAttribute("allLanguages", allLanguages);
			return "/languages/index.jsp";
		} else {
			languageService.createLanguage(newLanguage);
			return "redirect:/languages";
		}
	}
	
	//Show a language specific
	@GetMapping("/languages/{id}")
	public String findLanguageById(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
			model.addAttribute("language", language);
			return "/languages/language_info.jsp";
	}
	
	//Update language ok
	@PutMapping("/languages/{id}")
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
		
	//Delete language ok
	@DeleteMapping("/languages/{id}")
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
		
}
