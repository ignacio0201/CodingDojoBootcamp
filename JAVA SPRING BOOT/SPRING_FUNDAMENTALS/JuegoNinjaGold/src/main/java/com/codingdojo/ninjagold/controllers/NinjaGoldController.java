package com.codingdojo.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaGoldController {
	
	ArrayList<String> datesArray = new ArrayList<String>();
	public String message;
	
	@RequestMapping("/Gold")
	public String showIndex(HttpSession session, Model model) {
		model.addAttribute("datesArray", datesArray);
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		return "index.jsp";
	}
	
	//Farm: Genera entre 10 y 20 gold aleatoriamente
	@RequestMapping(value="/Farm", method=RequestMethod.POST)
	public String farmGold(HttpSession session) {
		Integer goldRandom = (int) (Math.random() * 10)+10;
		Integer yourGold = (Integer) session.getAttribute("gold");
		session.setAttribute("gold", yourGold + goldRandom);
		
		message = "You entered a farm and earned "+goldRandom+" gold. "+ "("+ (formatDate(LocalDateTime.now())) + ")";
		datesArray.add(message);
		return "redirect:/Gold";
	}
	
	//Cave: Genera entre 5 y 10 gold aleatoriamente
	@RequestMapping(value="/Cave", method=RequestMethod.POST)
	public String caveGold(HttpSession session) {
		Random random = new Random();
		Integer goldRandom = random.nextInt(6) + 5;
		Integer yourGold = (Integer) session.getAttribute("gold");
		session.setAttribute("gold", yourGold + goldRandom);
		
		message = "You entered a cave and earned "+goldRandom+" gold. "+ "("+ (formatDate(LocalDateTime.now())) + ")";
		datesArray.add(message);
		return "redirect:/Gold";
	}
	
	//House: Genera entre 2 y 5 gold aleatoriamente
	@RequestMapping(value="/House", method=RequestMethod.POST)
	public String houseGold(HttpSession session) {
		Random random = new Random();
		Integer goldRandom = random.nextInt(4) + 2;
		Integer yourGold = (Integer) session.getAttribute("gold");
		session.setAttribute("gold", yourGold + goldRandom);
		
		message = "You entered a house and earned "+goldRandom+" gold. "+ "("+ (formatDate(LocalDateTime.now())) + ")";
		datesArray.add(message);
		return "redirect:/Gold";
	}
	
	//Casino: Genera entre -50 y 50 gold aleatoriamente
	@RequestMapping(value="/Casino", method=RequestMethod.POST)
	public String houseCasino(HttpSession session) {
		Random random = new Random();
		Integer goldRandom = random.nextInt(101)-50;
		Integer yourGold = (Integer) session.getAttribute("gold");
		session.setAttribute("gold", yourGold + goldRandom);
		
		if(goldRandom >= 0) {
			message = "You entered a casino and earned "+goldRandom+" gold. "+ "("+ (formatDate(LocalDateTime.now())) + ")";
			datesArray.add(message);
		}else {
			message = "You entered a casino and lost "+goldRandom+" gold. Ouch "+ "("+ (formatDate(LocalDateTime.now())) + ")";
			datesArray.add(message);
		}
		return "redirect:/Gold";
	}
	
	//Resetea el gold
	@RequestMapping(value="/Reset", method=RequestMethod.POST)
	public String resetGold(HttpSession session) {
		session.invalidate();
		datesArray.clear();
		return "redirect:/Gold";
	}
	
	//Fecha
	private String formatDate(LocalDateTime dateTime) {
		String month = dateTime.getMonth().name().substring(0, 1).toUpperCase()
	                + dateTime.getMonth().name().substring(1).toLowerCase();
	    int day = dateTime.getDayOfMonth();
	    String year = String.valueOf(dateTime.getYear());
	    String time = dateTime.format(DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH));
	    return month + " " + day + " " + year + " " + time;
	}
}