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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.CurriculumVitae;
import ar.edu.unju.fi.html.entity.OfertaLaboral;
import ar.edu.unju.fi.html.service.ICiudadanoService;
import ar.edu.unju.fi.html.service.IOfertaLaboralService;


@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {
	
	@Autowired
    @Qualifier("CiudadanoServiceImp")
	private ICiudadanoService iCiudadanoService;
	@Autowired
    @Qualifier("OfertaLaboralServiceImp")
	private IOfertaLaboralService iOfertasService;
	private static final Log LOGGER = LogFactory.getLog(CiudadanoController.class);
	
	//redirecciona a html para registrar un nuevo ciudadano
	@GetMapping("/nuevo")
	public String getNuevoCiudadano(Model model) {
		//se utiliza un servicio para crear un nuevo Ciudadano
		model.addAttribute("ciudadano", iCiudadanoService.getCiudadano());
		return("registroCiudadano");
	}	
	//se guarda al ciudadano registrado
	@PostMapping("/postCiudadano")
	public ModelAndView guardarCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciu, BindingResult bindingResult){
		//Control de error de validaciones
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView modelAndview = new ModelAndView("registroCiudadano");
			modelAndview.addObject("ciudadano", ciu);
			return modelAndview;
		}
        try {
		//control para validar que solo se registren usuarios mayores de edad
		if(ciu.calcularEdad(ciu.getFechaNac()) < 18) {
			ModelAndView modelAndView = new ModelAndView("registroCiudadano");
			modelAndView.addObject("ciudadano", ciu);
			LOGGER.info("Ciudadano menor de edad");
			return modelAndView ;
		}
		else {
		ModelAndView modelAndView = new ModelAndView("redirect:/inicio/login");
		if(iCiudadanoService.getGuardarCiudadano(ciu)) {
			LOGGER.info("Se guardó un nuevo ciudadano.");

		}
		return modelAndView;
		}
		//en caso de error por clave primaria repetida u otro se redirecciona nuevamente al registro 
        }catch(Exception e) {
    		ModelAndView modelAndView = new ModelAndView("redirect:/ciudadano/nuevo");
            modelAndView.addObject("error", e.getMessage());
            return modelAndView;
        }
			
		}
	
	//llamada a pagina inicio ciudadano una vez registrado e inicio sesion
	@GetMapping("/inicioCiudadano")
	public String getIniCiudadano(Model model) {
		return("pagCiudadano");
	}
	//LLamada a pagina para ver un currilum vitae
	@GetMapping("/verCurriculum")
	public String getVerCV(Model model,Authentication at) {
		//se busca al ciudadano autenticado
		Ciudadano ciu = iCiudadanoService.getBuscarCiudadano(at.getName());
	    //control por si el cv es nulo lo redirecciona a crear un cv
		if(ciu.getCv()!=null) {
		model.addAttribute("cv", ciu.getCv());
		return("verCV");
		}
	   else {
		   return ("redirect:/ciudadano/crearCurriculum");
	   }
	}
	//LLamada a pagina para crear un curriculum vitae
	@GetMapping("/crearCurriculum")
	public String getCrearCV(Model model,Authentication at) {		
	    model.addAttribute("curriculum", new CurriculumVitae());
		return("crearCv");
	}
	
	//llamada a pagina para modificar curriculum vitae
	@PostMapping("/modificar")
	public ModelAndView modificarCV(@Validated @ModelAttribute("curriculum") CurriculumVitae cv,  BindingResult bindingResult, Authentication at) {
		//control de error de validaciones
		if(bindingResult.hasErrors()) {
			LOGGER.info("Ocurrio un error en la validacion de "+ cv);
			ModelAndView mav = new ModelAndView("crearCV");
			mav.addObject("curriculum", cv);
			return mav;
		}
		//se busca y modifica el cv de un ciudadano, luego redirecciona a ver cv
		 Ciudadano ciu = iCiudadanoService.getBuscarCiudadano(at.getName());
		 ciu.setCv(cv);
		 iCiudadanoService.getGuardarCiudadano(ciu);
		 LOGGER.info("Se modifico el cv"); 
		 ModelAndView mav = new ModelAndView("redirect:/ciudadano/verCurriculum"); 
		return mav;
	}
	
	//LLamada a pagina que muestra las ofertas laborales al Ciudadano
	@GetMapping("/verOfertasLaborales")
	public String getverOfertas(Model model) {
		model.addAttribute("ofertas", iOfertasService.listarOfertas());
		return("verOfertas");
    }
	
	//filtrar por provincia a las ofertas laborales 
	@GetMapping("/filtrarxProvincia")
	public String getverPerfilesProvincia(@Param("provincia")String provincia, Model model) {
		model.addAttribute("ofertas", iOfertasService.filtradoxProvincia(provincia));
		return("verOfertas");
	}
	
	//filtrar por fecha a las oferta laborales
	@GetMapping("/filtrarxFecha")
	public String getverxFecha(@Param("fecha")String fecha, Model model) {
		
		LocalDate fechaParsiada = LocalDate.parse(fecha);
		model.addAttribute("ofertas",iOfertasService.filtradoxFecha(fechaParsiada));
		return("verOfertas");
	}
	//LLamada a pagina que muestra el empleo seleccionado
		@GetMapping("/empleo")
		public ModelAndView verCv(@RequestParam(name ="id") long id) {
			ModelAndView mAv = new ModelAndView("ofertaparaCiudadano");
		   	   mAv.addObject("oferta",iOfertasService.getBuscarEmpleo(id)); 
			 
			return mAv;
		}
	
	//funcion del boton postularse donde se crea una nueva solicitud pendiente sobre el empleo  
	@GetMapping("/postularse/{id}")
	public ModelAndView getPostularse (@PathVariable(value="id")long id,Authentication aut) throws Exception {
		
		//busca una oferta con esa id
		OfertaLaboral oferta = iOfertasService.getBuscarEmpleo(id);
		//busca al ciudadano logueado
		Ciudadano ciudadano = iCiudadanoService.getBuscarCiudadano(aut.getName());
		//Control para saber si existe el cv, la oferta debe estar disponible y debe aver vacantes
		if(ciudadano.getCv()!=null && oferta.isDisponible() && oferta.getCantVacantes()>0) {
		ModelAndView mAv = new ModelAndView("redirect:/ciudadano/misPostulaciones");
		//crear una solicitud del Ciudadano para la oferta
		iOfertasService.getNuevaSolicitud(ciudadano.getCv(), oferta);
		 return mAv;
		 }
		else {
			ModelAndView mAv = new ModelAndView("redirect:/ciudadano/verOfertasLaborales");
			return mAv;
		}
		

	}
	
	//LLamada a pagina que muestra las postulaciones del ciudadano
	@GetMapping("/misPostulaciones")
	public String getPostulaciones(Model model,Authentication aut) {	
		
		Ciudadano ciudadano = iCiudadanoService.getBuscarCiudadano(aut.getName());
		//si el cv aun no se creo lo redirecciona a crear uno
		if(ciudadano.getCv()!=null) {
		model.addAttribute("listaSolicitudes", iOfertasService.getListaSolicitudesCiu(ciudadano.getCv().getId()));
		return("estadoEmpleos");
		}
		else {
			return ("redirect:/ciudadano/crearCurriculum");
		}
	}
	
}	


