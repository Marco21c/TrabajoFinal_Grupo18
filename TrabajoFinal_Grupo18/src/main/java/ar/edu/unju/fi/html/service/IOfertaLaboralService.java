package ar.edu.unju.fi.html.service;

import java.util.List;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.entity.OfertaLaboral;

public interface IOfertaLaboralService {
	
	public OfertaLaboral getOfertaLaboral();
	public boolean guardarOferta(OfertaLaboral ofertalaboral);	
	public List<OfertaLaboral> listarOfertas();
	public List<OfertaLaboral> misOfertasLaborales(long id);
	public List<OfertaLaboral> filtradoxProvincia(String Provincia);
	public OfertaLaboral getBuscarEmpleo(long id);
	public void getNuevaSolicitud(Ciudadano ciudadano, OfertaLaboral oferta);
	}
