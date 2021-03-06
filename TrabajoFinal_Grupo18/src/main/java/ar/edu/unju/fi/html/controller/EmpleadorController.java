package ar.edu.unju.fi.html.controller;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.html.entity.Curso;
import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.entity.OfertaLaboral;
import ar.edu.unju.fi.html.entity.Solicitud;
import ar.edu.unju.fi.html.service.ICursoService;
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
	@Autowired
    @Qualifier("CursoServiceImp")
	private ICursoService cursoService;  
	private static final Log LOGGER = LogFactory.getLog(CiudadanoController.class);
	
	//redirecciona a html para registrar un nuevo Empleador
	@GetMapping("/nuevo")
	public String getNuevoCiudadano(Model model) {	
		model.addAttribute("empleador", iEmpleadorService.getEmpleador());
		return("registroEmpleador");
	}	
	
	//se guarda al Empleador registrado
	@PostMapping("/postEmpleador")
	public ModelAndView guardarEmpleador(@Validated @ModelAttribute("empleador") Empleador emp, BindingResult bindingResult){
		//control de validaciones
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validaci??n");
			ModelAndView modelAndview = new ModelAndView("registroEmpleador");
			modelAndview.addObject("empleador", emp);
			return modelAndview;
		}
		try {
			 //si no hay errores se guarda el empleador
		ModelAndView modelAndView = new ModelAndView("redirect:/inicio/login");
		if(iEmpleadorService.agregarEmpleador(emp)){
		 LOGGER.info("Se guard?? un nuevo empleador.");
		}
		return modelAndView ;
		}catch(Exception e) { //controla los errores de clave primaria repetida y otros errores
			ModelAndView modelAndview = new ModelAndView("registroEmpleador");
			return modelAndview ;
		}
		
		}
	
	//llamada pagina empleador una vez realizado el registro o inicio de sesion como empleador
	@GetMapping("/inicioEmpleador")
	public String getIniEmpleador(Model model) {
		return("pagEmpleador");
	}
	
	//llamada a pagina para mostrar los cursos vigente creado por el empleador
	@GetMapping("/misCursos")
	public String getMisCursos(Model model, Authentication aut) {
		Empleador empleador = iEmpleadorService.buscarEmpleador(aut.getName());
		model.addAttribute("cursos", cursoService.getMisCursos(empleador.getId()));
		
		return("misCursos");
	}
	
	//metodo para eliminar curso logicamente 
	@GetMapping("/eliminarCurso/{id}")
	public String eliminarCurso(Model model, @PathVariable(name="id") long id) throws Exception {
		Curso curso = cursoService.buscarCurso(id);
        //seteo del estado a falso 
		curso.setEstado(false);
		cursoService.getAgregarCurso(curso);
		return ("redirect:/empleador/misCursos");
	}

	//llamada a la pagina de perfiles laborales
	@GetMapping("/perfiles")
	public String getverPerfiles(Model model) {
		model.addAttribute("listaCvs", iEmpleadorService.getListarCvs());
		return("verPerfiles");
	}
	
	//filtrar por provincia los perfiles de los ciudadanos
	@GetMapping("/filtrarxProvincia")
	public String getverPerfilesProvincia(@Param("provincia")String provincia, Model model) {
		model.addAttribute("listaCvs", iEmpleadorService.getCvsxProvincia(provincia));
		return("verPerfiles");
	}
	
	//filtrar por palabra clave para la busqueda de perfiles de los ciudadanos
	@GetMapping("/filtrarxPalabra")
	public String getverPerfilesPalabra(@Param("palabra")String palabra, Model model) {
		model.addAttribute("listaCvs", iEmpleadorService.getCvsxPalabra(palabra));
		return("verPerfiles");
	}
	
	//llamada a pagina para crear una oferta laboral
	@GetMapping("/crearEmpleo")
	public String getCrearOferta(Model model, Authentication at) {
		
		model.addAttribute("ofertaLaboral",iOfertasService.getOfertaLaboral());
		return ("crearOferta");
	}
	
	//se guarda registro de nuevo empleo generado por el empleador
	@PostMapping("/guardarEmpleo")
	public ModelAndView guardarEmpleo(@Validated @ModelAttribute("ofertaLaboral") OfertaLaboral ol, BindingResult bindingResult,  Authentication at){
		//control de errores de validacion
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validaci??n");
			ModelAndView modelAndview = new ModelAndView("crearOferta");
			modelAndview.addObject("ofertaLaboral",ol);
			return modelAndview;
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/empleador/misEmpleos");
		//seteo del empleador logueado y de la fecha actual wque representa la fecha de creacion de la oferta
		ol.setEmpleador(iEmpleadorService.buscarEmpleador(at.getName()));
		ol.setFechaCreacion(LocalDate.now());		
		if(iOfertasService.guardarOferta(ol)) {
		 LOGGER.info("Se guard?? una oferta laboral.");
		}
		return modelAndView ;
		}
	
	//opcion de edicion para un empleo
	@GetMapping("/editarEmpleo/{id}")
	public String obtenerFormularioEditarEmpleo(Model model, @PathVariable(name="id") long id) throws Exception {
		// se busca una oferta y se la manda al formulario para la edicion
		OfertaLaboral ofertaEncontrado = iOfertasService.encontrarOferta(id);
		model.addAttribute("editarEmpleo", ofertaEncontrado);
		return ("editarEmpleoForm");
	}
	
	//guarda la edicion del empleo registrado con fecha actual 
	@PostMapping("/editarEmpleo")
	public ModelAndView postEditarEmpleo(@Validated @ModelAttribute("editarEmpleo") OfertaLaboral ofertalaboral, BindingResult result, ModelMap model, Authentication aut) {
	//control de error de validacion
		if(result.hasErrors()) {
		model.addAttribute("editarEmpleo", ofertalaboral);
		ModelAndView modelAndView = new ModelAndView("editarEmpleoForm");
		return modelAndView;
		
	}
	//se busca al empleador y se setea la fecha de creacion y al empleador a la oferta
	Empleador empleador = iEmpleadorService.buscarEmpleador(aut.getName());
	ofertalaboral.setEmpleador(empleador);
	ofertalaboral.setFechaCreacion(LocalDate.now());
	LOGGER.info("Se guard?? ofertalaboral "+ofertalaboral.getId());
	//se guarda la oferta
	if(iOfertasService.guardarOferta(ofertalaboral)) {
		LOGGER.info("Se guard?? ofertalaboral ");
	}
	ModelAndView modelAndView = new ModelAndView("redirect:/empleador/misEmpleos");
	return modelAndView;
	}
	
	//muestra la lista de empleos pertenecientes al empleador 
	@GetMapping("/misEmpleos")
	public String getMisEmpleos(Model model, Authentication aut) {
	    
		Empleador empleador = iEmpleadorService.buscarEmpleador(aut.getName());
		model.addAttribute("ofertas",iOfertasService.misOfertasLaborales(empleador.getId()));
		
		return("misEmpleos");
	}
	
	//metodo asignado al boton eliminar, que borra logicamente la oferta laboral
	@GetMapping("/eliminarEmpleo/{id}")
	public String eliminarEmpleo(Model model, @PathVariable(name="id") Long id) throws Exception {
		OfertaLaboral oferta = iOfertasService.encontrarOferta(id);
		oferta.setDisponible(false);
		iOfertasService.guardarOferta(oferta);
		return ("redirect:/empleador/misEmpleos");
	}

	//llamada a pagina solicitudes para verificar los postulantes a las oferta realizadas
	@GetMapping("/solicitudes")
	public String getSolicitudes(Model model, Authentication aut){
		Empleador empleador = iEmpleadorService.buscarEmpleador(aut.getName());
		model.addAttribute("solicitudes", iOfertasService.getSolicitudesEmp(empleador.getId()));
		return ("solicitudes");
	}
	
	//accion del boton aceptar una solicitud
	@GetMapping("/aceptarSoli/{id}")
	public ModelAndView getAceptarSoli (@PathVariable(value="id")long id){
		
		//busca la solicitud
		Solicitud soli = iOfertasService.getBuscarSolicitud(id);
		//cambiar la solicitud a aceptada y actualizar las vacantes
		soli.setEstado("Aceptado");
		if(soli.getOferta().getCantVacantes()>0) {
		iOfertasService.getActualizarVacantes(soli.getOferta().getId());
		
		if(iOfertasService.getActualizarSolicitud(soli)) {
			LOGGER.info("se acepto la solicitud");
		}
		}
		ModelAndView mAv = new ModelAndView("redirect:/empleador/solicitudes");
		
			return mAv;
		}
	//accion del boton rechazar una solicitud
	@GetMapping("/rechazarSoli/{id}")
	public ModelAndView getRechazarSoli (@PathVariable(value="id")long id){
		
		//busca la solicitud
		Solicitud soli = iOfertasService.getBuscarSolicitud(id);
		//cambiar la solicitud a aceptada y actualizar las vacantes
		soli.setEstado("Rechazado");
		
		if(iOfertasService.getActualizarSolicitud(soli)) {
			LOGGER.info("se rechazo la solicitud");
		}
		
		ModelAndView mAv = new ModelAndView("redirect:/empleador/solicitudes");
		
			return mAv;
		}	
        
	//redirecciona pagina para ver el curriculum del ciudadano postulante al empleo 
	@GetMapping("/verCv")
	public ModelAndView verCv(@RequestParam(name ="id") long id) {
		ModelAndView mAv = new ModelAndView("cvSolicitud");
         
	   	   mAv.addObject("cv", iOfertasService.getBuscarCv(id)); 
		 
		return mAv;
	}
	
	}

