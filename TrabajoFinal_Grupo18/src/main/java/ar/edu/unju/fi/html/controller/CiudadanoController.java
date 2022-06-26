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
	
	@PostMapping("/postCiudadano")
	public ModelAndView guardarCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciu, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView modelAndview = new ModelAndView("registroCiudadano");
			modelAndview.addObject("ciudadano", ciu);
			return modelAndview;
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/inicio/login");

		if(iCiudadanoService.getGuardarCiudadano(ciu)) {
			LOGGER.info("Se guardó un nuevo ciudadano.");
		}
		return modelAndView ;
		}
	
	@GetMapping("/inicioCiudadano")
	public String getIniCiudadano(Model model) {
		return("pagCiudadano");
	}
	//LLamada a pagina para ver un currilum vitae
	@GetMapping("/verCurriculum")
	public String getVerCV(Model model,Authentication at) {
		Ciudadano ciu = iCiudadanoService.getBuscarCiudadano(at.getName());
		 model.addAttribute("ciudadano", ciu);
		return("verCV");
	}
	//LLamada a pagina para crear un currilum vitae
	@GetMapping("/crearCurriculum")
	public String getCrearCV(Model model, Authentication at) {
	    
	    Ciudadano ciu = iCiudadanoService.getBuscarCiudadano(at.getName());
	    model.addAttribute("ciudadano", ciu);
	    
		return("crearCv");
	}
	@PostMapping("/modificar")
	public ModelAndView modificarCV(@Validated @ModelAttribute("ciudadano") Ciudadano ciu,  BindingResult bindingResult) {
		/*if(bindingResult.hasErrors()) {
			LOGGER.info("Ocurrio un error en la validacion de "+ ciu);
			ModelAndView mav = new ModelAndView("crearCV");
			mav.addObject("ciudadano", ciu);
		}*/
		 LOGGER.info("Se modifico el cv"); 
		 iCiudadanoService.modificarCV(ciu);
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/verCurriculum");
		
		return mav;
	}
	//LLamada a pagina que muestra las ofertas laborales
	@GetMapping("/verOfertasLaborales")
	public String getverOfertas(Model model) {
		return("verOfertas");
    }
}