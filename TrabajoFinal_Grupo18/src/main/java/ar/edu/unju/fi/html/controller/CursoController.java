package ar.edu.unju.fi.html.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/curso")
public class CursoController {	
	
	//LLamada a pagina para inscribirse a un curso
		@GetMapping("/inscripCurso")
		public String getInscripCurso(Model model) {
			return("inscripCurso");
		}
}
