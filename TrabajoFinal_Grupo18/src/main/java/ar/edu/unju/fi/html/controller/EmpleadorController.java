package ar.edu.unju.fi.html.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Curso;
import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.entity.OfertaLaboral;
import ar.edu.unju.fi.html.entity.Solicitud;
import ar.edu.unju.fi.html.service.IEmpleadorService;
import ar.edu.unju.fi.html.service.IOfertaLaboralService;

@Controller
@RequestMapping("/empleador") 
public class EmpleadorController {
	@Autowired
    @Qualifier("EmpleadorServiceImp")
	private IEmpleadorService iEmpleadorService;
	@Autowired
    @Qualifier("OfertaLaboralServiceImp")
	private IOfertaLaboralService iOfertasService;
	
	private static final Log LOGGER = LogFactory.getLog(CiudadanoController.class);
	
	@GetMapping("/nuevo")
	public String getNuevoCiudadano(Model model) {	
		model.addAttribute("empleador", iEmpleadorService.getEmpleador());
		return("registroEmpleador");
	}	
	
	@PostMapping("/postEmpleador")
	public ModelAndView guardarEmpleador(@Validated @ModelAttribute("empleador") Empleador emp, BindingResult bindingResult){
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
	@GetMapping("/misCursos")
	public String getMisCursos(Model model, Authentication aut) {
	  
		model.addAttribute("cursos", iEmpleadorService.getMisCursos(aut.getName()));
		
		return("misCursos");
	}
	
	
	@GetMapping("/perfiles")
	public String getverPerfiles(Model model) {
		model.addAttribute("listaCvs", iEmpleadorService.getListarCvs());
		return("verPerfiles");
	}
	
	
	@GetMapping("/filtrarxProvincia")
	public String getverPerfilesProvincia(@Param("provincia")String provincia, Model model) {
		model.addAttribute("listaCvs", iEmpleadorService.getCvsxProvincia(provincia));
		return("verPerfiles");
	}
	
	@GetMapping("/filtrarxPalabra")
	public String getverPerfilesPalabra(@Param("palabra")String palabra, Model model) {
		model.addAttribute("listaCvs", iEmpleadorService.getCvsxPalabra(palabra));
		return("verPerfiles");
	}
	
	@GetMapping("/crearEmpleo")
	public String getCrearOferta(Model model, Authentication at) {
		
		model.addAttribute("ofertaLaboral",iOfertasService.getOfertaLaboral());
		return ("crearOferta");
	}
	@PostMapping("/guardarEmpleo")
	public ModelAndView guardarEmpleo(@Validated @ModelAttribute("ofertaLaboral") OfertaLaboral ol, BindingResult bindingResult,  Authentication at){
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView modelAndview = new ModelAndView("crearOferta");
			modelAndview.addObject("ofertaLaboral",ol);
			return modelAndview;
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/empleador/misEmpleos");
		ol.setEmpleador(iEmpleadorService.buscarEmpleador(at.getName()));
		
		if(iOfertasService.guardarOferta(ol)) {
		 LOGGER.info("Se guardó una oferta laboral.");
		}
		return modelAndView ;
		}
	
	@GetMapping("/misEmpleos")
	public String getMisEmpleos(Model model, Authentication aut) {
	    
		Empleador empleador = iEmpleadorService.buscarEmpleador(aut.getName());
		model.addAttribute("ofertas",iOfertasService.misOfertasLaborales(empleador.getId()));
		
		return("misEmpleos");
	}
	
	@GetMapping("/solicitudes")
	public String getSolicitudes(Model model, Authentication aut){
		Empleador empleador = iEmpleadorService.buscarEmpleador(aut.getName());
		model.addAttribute("solicitudes", iOfertasService.getSolicitudesEmp(empleador.getId()));
		return ("solicitudes");
	}
	
	@GetMapping("/aceptarSoli/{id}")
	public ModelAndView getAceptarSoli (@PathVariable(value="id")long id){
		
		//busca la solicitud
		Solicitud soli = iOfertasService.getBuscarSolicitud(id);
		//cambiar la solicitud a aceptada y actualizar las vacantes
		soli.setEstado("Aceptado");
		iOfertasService.getActualizarVacantes(soli.getOferta().getId());
		
		if(iOfertasService.getActualizarSolicitud(soli)) {
			LOGGER.info("se acepto la solicitud");
		}
		
		ModelAndView mAv = new ModelAndView("redirect:/empleador/solicitudes");
		
			return mAv;
		}
	@GetMapping("/rechazarSoli/{id}")
	public ModelAndView getRechazarSoli (@PathVariable(value="id")long id){
		
		//busca la solicitud
		Solicitud soli = iOfertasService.getBuscarSolicitud(id);
		//cambiar la solicitud a aceptada y actualizar las vacantes
		soli.setEstado("Rechazado");
		
		if(iOfertasService.getActualizarSolicitud(soli)) {
			LOGGER.info("se acepto la solicitud");
		}
		
		ModelAndView mAv = new ModelAndView("redirect:/empleador/solicitudes");
		
			return mAv;
		}	

	}

