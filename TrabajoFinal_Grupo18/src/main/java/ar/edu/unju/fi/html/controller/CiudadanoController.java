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

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.service.ICiudadanoService;


@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {
	
	@Autowired
    @Qualifier("CiudadanoServiceImp")
	private ICiudadanoService iCiudadanoService;
	
	@GetMapping("/nuevo")
	public String getNuevoCiudadano(Model model) {	
		model.addAttribute("ciudadano", iCiudadanoService.getCiudadano());
		return("registro_ciudadano");
	}	
	
	@GetMapping("/inicio")
	public String getSesionCiudadano(Model model) {	
		return("inicio_ciudadano");
	}
	
	@GetMapping("/inicioCiudadano")
	public String getIniCiudadano(Model model) {
		return("pagCiudadano");
	}
	
	@PostMapping("/postCiudadano")
	public ModelAndView saveAlumno(@Validated @ModelAttribute("ciudadano") Ciudadano ciu, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			/*LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView modelAndview = new ModelAndView("nueva_beca");
			modelAndview.addObject("beca", bec);
			return modelAndview;*/
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/ciudadano/inicioCiudadano");
		/*if(becaService.agregarBeca(bec)) {
			LOGGER.info("Se guardó un objeto beca en la lista de becas");
		}*/
		/*modelAndView.addObject("becas",becaService.getListaBecas());*/
		return modelAndView ;
		}
		
	
}
