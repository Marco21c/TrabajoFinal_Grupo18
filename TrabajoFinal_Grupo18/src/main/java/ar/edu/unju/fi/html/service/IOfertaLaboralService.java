package ar.edu.unju.fi.html.service;

import java.util.List;

import ar.edu.unju.fi.html.entity.OfertaLaboral;

public interface IOfertaLaboralService {
	
	public OfertaLaboral getOfertaLaboral();
	public void guardarOferta(OfertaLaboral ofertalaboral);	
	public List<OfertaLaboral> listarOfertas();
}
