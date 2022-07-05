package ar.edu.unju.fi.html.serviceImp;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.OfertaLaboral;
import ar.edu.unju.fi.html.entity.Solicitud;
import ar.edu.unju.fi.html.repository.IEmpleadorDAO;
import ar.edu.unju.fi.html.repository.IOfertaLaboralDAO;
import ar.edu.unju.fi.html.repository.ISolicitudDAO;
import ar.edu.unju.fi.html.service.IOfertaLaboralService;

@Service("OfertaLaboralServiceImp")
public class OfertaLaboralServiceImp implements IOfertaLaboralService {

	@Autowired
	IOfertaLaboralDAO ofertaDaoImp;
	@Autowired
	IEmpleadorDAO empleadorDAOImp;
	@Autowired
    ISolicitudDAO solicitudDAOImp;
	
	@Override
	public boolean guardarOferta(OfertaLaboral ofertalaboral) {
		if(ofertaDaoImp.save(ofertalaboral)!=null) {
			return true;
		}
		
		return false;
	}

	@Override
      public List<OfertaLaboral> listarOfertas() {
		// TODO Auto-generated method stub
		return ofertaDaoImp.findAll();
	}
    
	
	
	@Override
	public OfertaLaboral getOfertaLaboral() {
		// TODO Auto-generated method stub
		return new OfertaLaboral();
	}

	@Override
	public List<OfertaLaboral> misOfertasLaborales(long id) {
		// TODO Auto-generated method stub
		return ofertaDaoImp.findAllByEmpleadorId(id);
	}
    
	@Override
	public List<OfertaLaboral> filtradoxProvincia(String Provincia){
		
		return ofertaDaoImp.findAllByEmpleadorProvincia(Provincia);
	}

	@Override
	public OfertaLaboral getBuscarEmpleo(long id) {
		// TODO Auto-generated method stub
		Optional<OfertaLaboral> ofertaEncontrada= ofertaDaoImp.findById(id);
		return ofertaEncontrada.get();
	}
	@Override
	public Solicitud getSolicitud() {
		
		return new Solicitud();
	}
	
	@Override
	public void getNuevaSolicitud(Ciudadano ciudadano,OfertaLaboral oferta){
		
		Solicitud soli = getSolicitud();
		soli.setCiudadano(ciudadano);
		soli.setOferta(oferta);
		soli.setEstado("Pendiente");
		
		solicitudDAOImp.save(soli);
	}
}

