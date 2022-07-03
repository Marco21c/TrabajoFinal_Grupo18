package ar.edu.unju.fi.html.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.html.entity.OfertaLaboral;
import ar.edu.unju.fi.html.service.IOfertaLaboralService;

public class OfertaLaboralController {

	@Autowired
	IOfertaLaboralService laboralService;
	
	@Autowired
	private OfertaLaboral ofertalaboral;
	
	@RequestMapping("/ofertas")
	public String getOfertasFrom(Model model) {
		List<OfertaLaboral> ofertas = laboralService.listarOfertas();
		model.addAttribute("ofertas", ofertas);
		return "verOfertas";
	}
	
	@GetMapping("/nuevaOferta")
	public String crear(Model model) {
		model.addAttribute("ofertaLaboral", ofertalaboral);
		return "crearOferta";
	}
	
	@PostMapping("/save")
	public String GuardarOferta(@Valid OfertaLaboral ofertalaboral, Model model) {
		
		laboralService.guardarOferta(ofertalaboral);
		return "redirect:/pagCiudadano";
	}
}
