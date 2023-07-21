package com.codingdojo.mostrarlafecha.controllers;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//MOSTRAR EL HOME
	@RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
	
	//MOSTRAR LA FECHA
	@RequestMapping("/date")
    public String showDate(Model model) {
		java.util.Date date = new java.util.Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, 'the' d 'of' MMMM, yyyy", Locale.ENGLISH);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("currentDate", formattedDate);
        return "date.jsp";
    }
	
	//MOSTRAR LA HORA
	@RequestMapping("/time")
    public String showTime(Model model) {
		LocalTime currentTime = LocalTime.now();
		
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
	    String formattedTime = currentTime.format(timeFormat);
		
	    model.addAttribute("currentTime", formattedTime);
        return "time.jsp";
    }
}
