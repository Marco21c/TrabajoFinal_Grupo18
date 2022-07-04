package ar.edu.unju.fi.html.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.html.entity.OfertaLaboral;
import ar.edu.unju.fi.html.service.IOfertaLaboralService;

@Controller
public class OfertaLaboralController {

	@Autowired
	@Qualifier("OfertaLaboralServiceImp")
	private IOfertaLaboralService iLaboralService;
	
	@Autowired
	private OfertaLaboral ofertalaboral;
	
	@RequestMapping("/ofertas")
	public String getOfertasFrom(Model model) {
		List<OfertaLaboral> ofertas = iLaboralService.listarOfertas();
		model.addAttribute("ofertas", ofertas);
		return "verOfertas";
	}
	
	@GetMapping("/nuevaOferta")
	public String crear(Model model) {
		model.addAttribute("ofertaLaboral", ofertalaboral);
		return "crearOferta";
	}
	
	@PostMapping("/guardar")
	public String GuardarOferta(@Valid OfertaLaboral ofertalaboral, Model model) {
		
		iLaboralService.guardarOferta(ofertalaboral);
		return "redirect:/pagCiudadano";
	}
}
