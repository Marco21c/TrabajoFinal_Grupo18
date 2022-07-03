package ar.edu.unju.fi.html.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
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
	
	private static final Log LOGGER = LogFactory.getLog(CiudadanoController.class);
	
	@GetMapping("/nuevo")
	public String getNuevoCiudadano(Model model) {	
		model.addAttribute("empleador", iEmpleadorService.getEmpleador());
		return("registroEmpleador");
	}	
	
	@PostMapping("/postEmpleador")
	public ModelAndView guardarEmpleador(@Validated @ModelAttribute("empleador") Empleador emp, BindingResult bindingResult){
		LOGGER.info("postempleador");
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView modelAndview = new ModelAndView("registroEmpleador");
			modelAndview.addObject("empleador", emp);
			return modelAndview;
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/inicio/login");
		if(iEmpleadorService.agregarEmpleador(emp)){
		 LOGGER.info("Se guardó un nuevo empleador.");
		}
		
		return modelAndView ;
		}
	

	@GetMapping("/inicioEmpleador")
	public String getIniEmpleador(Model model) {
		return("pagEmpleador");
	}
	
	@GetMapping("/crearEmpleo")
	public String getCrearOferta(Model model, Authentication at) {
		
		Empleador emp = iEmpleadorService.getBuscarEmpleador(at.getName());
		model.addAttribute("empleador", emp);
		return ("crearOferta");
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
