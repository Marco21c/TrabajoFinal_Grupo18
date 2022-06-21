package ar.edu.unju.fi.html.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.service.IEmpleadorService;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
	@Autowired
    @Qualifier("EmpleadorServiceImp")
	private IEmpleadorService iEmpleadorService;
	
	@GetMapping("/nuevo")
	public String getNuevoCiudadano(Model model) {	
		model.addAttribute("empleador", iEmpleadorService.getEmpleador());
		return("registroEmpleador");
	}	
	
	@GetMapping("/inicio")
	public String getSesionEmpleador(Model model) {	
		return("inicioEmpleador");
	}
	
	@GetMapping("/inicioEmpleador")
	public String getIniEmpleador(Model model) {
		return("pagEmpleador");
	}
	
	@PostMapping("/postEmpleador")
	public ModelAndView guardarEmpleador(@Validated @ModelAttribute("empleador") Empleador emp, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/empleador/inicioEmpleador");
		
		return modelAndView ;
		}
	
	@GetMapping("/perfiles")
	public String getverPerfiles(Model model) {
		return("verPerfiles");
	}
	@GetMapping("/misEmpleos")
	public String getmisEmpleos(Model model) {
		return("misEmpleos");
	}
}
