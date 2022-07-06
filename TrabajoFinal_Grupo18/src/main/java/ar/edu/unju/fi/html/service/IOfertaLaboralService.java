package ar.edu.unju.fi.html.service;

import java.util.List;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.CurriculumVitae;
import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.entity.OfertaLaboral;
import ar.edu.unju.fi.html.entity.Solicitud;

public interface IOfertaLaboralService {
	
	public OfertaLaboral getOfertaLaboral();
	public boolean guardarOferta(OfertaLaboral ofertalaboral);
	public OfertaLaboral modificarEmpleo(OfertaLaboral ofertalaboral) throws Exception;
	public void eliminarEmpleo(long id);
	public List<OfertaLaboral> listarOfertas();
	public List<OfertaLaboral> misOfertasLaborales(long id);
	public List<OfertaLaboral> filtradoxProvincia(String Provincia);
	public OfertaLaboral getBuscarEmpleo(long id);

	public void getNuevaSolicitud(Ciudadano ciudadano, OfertaLaboral oferta);
	public OfertaLaboral encontrarOferta(Long id) throws Exception;
	public Solicitud getSolicitud();
	public List<Solicitud> getListaSolicitudesCiu(long id);
	public void getNuevaSolicitud(CurriculumVitae cv, OfertaLaboral oferta);
	public List<Solicitud> getSolicitudesEmp(long id);
	public Solicitud getBuscarSolicitud(long id);
	public void getActualizarVacantes(long idOferta);
	public boolean getActualizarSolicitud(Solicitud soli);
	public CurriculumVitae getBuscarCv(long id);

	}
