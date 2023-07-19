package com.codingdojo.enrutamiento.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

	@RequestMapping("/{var1}")
	public String dojo(
			@PathVariable ("var1") String ingresevar1aqui) {
		if(ingresevar1aqui.equals("dojo")) {
			return "¡El Dojo es increíble!";
		}else if (ingresevar1aqui.equals("burbank-dojo")) {
            return "El Dojo Burbank está localizado al sur de California";
        } else if (ingresevar1aqui.equals("san-jose")) {
            return "El Dojo SJ es el cuartel general";
        } else {
            return "No se encontro la ruta";
        }
	}
}