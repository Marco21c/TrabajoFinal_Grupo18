package ar.edu.unju.fi.html.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	private static final Log LOGGER = LogFactory.getLog(CiudadanoController.class);
	
	@GetMapping("/nuevo")
	public String getNuevoCiudadano(Model model) {	
		model.addAttribute("ciudadano", iCiudadanoService.getCiudadano());
		return("registroCiudadano");
	}	
	
	@GetMapping("/inicio")
	public String getSesionCiudadano(Model model) {	
		return("inicioCiudadano");
	}
	
	@GetMapping("/inicioCiudadano")
	public String getIniCiudadano(Model model) {
		return("pagCiudadano");
	}
	
	@PostMapping("/postCiudadano")
	public ModelAndView guardarCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciu, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView modelAndview = new ModelAndView("registroCiudadano");
			modelAndview.addObject("ciudadano", ciu);
			return modelAndview;
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/ciudadano/inicioCiudadano");

		if(iCiudadanoService.getGuardarCiudadano(ciu)) {
			LOGGER.info("Se guardó un nuevo ciudadano.");
		}

		return modelAndView ;
		}
	
	//LLamada a pagina para ver un currilum vitae
	@GetMapping("/verCurriculum")
	public String getVerCV(Model model) {
		return("verCV");
	}
	//LLamada a pagina para crear un currilum vitae
	@GetMapping("/crearCurriculum")
	public String getCrearCV(Model model) {
		return("crearCv");
	}
	//LLamada a pagina que muestra las ofertas laborales
	@GetMapping("/verOfertasLaborales")
	public String getverOfertas(Model model) {
		return("verOfertas");
    }
}