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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Curso;
import ar.edu.unju.fi.html.service.ICiudadanoService;
import ar.edu.unju.fi.html.service.ICursoService;
import ar.edu.unju.fi.html.service.IEmpleadorService;

@Controller
@RequestMapping("/curso")
public class CursoController {	
	      
	@Autowired
    @Qualifier("CursoServiceImp")
	private ICursoService cursoService;   
	@Autowired
    @Qualifier("EmpleadorServiceImp")
	private IEmpleadorService empleadorService;
	@Autowired
    @Qualifier("CiudadanoServiceImp")
	private ICiudadanoService iCiudadanoService;
	
	private static final Log LOGGER = LogFactory.getLog(CiudadanoController.class);
	
	   @GetMapping("/nuevo")
	   public String getCurso(Model model) {
		   
		   model.addAttribute("curso",cursoService.getCurso());
		 
		   return("nuevoCurso");
	   }
	   @PostMapping("/guardarCurso")
	   public ModelAndView getGuardarCurso(@Validated @ModelAttribute("curso") Curso curso , BindingResult bindingResult, Authentication aut ) {
		   if(bindingResult.hasErrors()) {
			   LOGGER.error("No se cumplen las validaciones.");
			   ModelAndView mav =  new ModelAndView("nuevoCurso");
			   mav.addObject("curso", curso);
		   }
		   ModelAndView mav =  new ModelAndView("redirect:/empleador/misCursos");
		   curso.setEmpleador(empleadorService.buscarEmpleador(aut.getName()));
		   if(cursoService.getAgregarCurso(curso)) {
			   LOGGER.info("Se agrego nuevo curso.");
		   }
		   
		   return mav;
	   }
	   
	   
	//LLamada a pagina para inscribirse a un curso
		@GetMapping("/listaCursos")
		public String getInscripCurso(Model model) {
			model.addAttribute("cursos", cursoService.getListaCursos());
			return("inscripCurso");
		}
		
		@GetMapping("/inscripCurso/{id}")
		public ModelAndView getInscribirseaCurso (@PathVariable(value="id")long id,Authentication aut) throws Exception {
			
			//busca el curso con esa id
			Curso curs = cursoService.buscarCurso(id);
			//busca al ciudadano logueado
			Ciudadano ciudadano = iCiudadanoService.getBuscarCiudadano(aut.getName());
			
			ModelAndView mAv = new ModelAndView("redirect:/curso/cursosInscripciones");
			//verificar que el ciudadano se inscriba una sola vez a un curso
		    try {
			if(cursoService.verificarCursos(id,ciudadano)) { 
		    	LOGGER.info("El usuario ya esta inscripto a ese curso");}
		    }
		    catch(Exception e){
		    iCiudadanoService.getAgregarCurso(ciudadano , curs);
		    }
			return mAv;
		}
		
		@GetMapping("/cursosInscripciones")
		public String getMisCurso(Model model,Authentication aut) {
	        
			Ciudadano ciu = iCiudadanoService.getBuscarCiudadano(aut.getName());
			model.addAttribute("listaCursos",cursoService.getMisCursos(ciu));
			
			return("cursosInscripciones");
		}
		
}
