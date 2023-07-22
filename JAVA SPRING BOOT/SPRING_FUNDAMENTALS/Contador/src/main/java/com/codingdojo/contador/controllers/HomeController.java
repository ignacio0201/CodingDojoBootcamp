package com.codingdojo.contador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showIndex(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer count = (Integer) session.getAttribute("count");
		count++;
		session.setAttribute("count", count);
		return "index.jsp";
	}
	
	@RequestMapping("/increasecounterx2")
	public String showCounter(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer count = (Integer) session.getAttribute("count");
		count += 2;
		session.setAttribute("count", count);
		return "increasecounterx2.jsp";
	}
	
	@RequestMapping("/counter")
	public String showCounter() {
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String resetCounter(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count = 0;
		session.setAttribute("count", count);
		return "counter.jsp";
	}
}
