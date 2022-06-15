package ar.edu.unju.fi.html.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ciudadano")
public class CiudadanoController {

	@GetMapping("/nuevo")
	public String getNuevoCiudadano(Model model) {	
		return("registro_ciudadano");
	}	
}
