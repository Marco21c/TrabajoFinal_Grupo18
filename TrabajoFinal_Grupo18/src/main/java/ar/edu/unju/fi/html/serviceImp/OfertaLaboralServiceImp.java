package ar.edu.unju.fi.html.serviceImp;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.OfertaLaboral;
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
    ISolicitudDAO solocitudDAOImp;
	
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
		return ofertaDaoImp.findAllByEmpleadorIdAndDisponible(id, true);
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
	public void getNuevaSolicitud(Ciudadano ciudadano,OfertaLaboral oferta){
		
		
	}

	@Override
	public OfertaLaboral modificarEmpleo(OfertaLaboral ofertalaboral) throws Exception{
		// TODO Auto-generated method stub
		OfertaLaboral ofertaGuardar = encontrarOferta(ofertalaboral.getId());
		mapearOferta(ofertalaboral, ofertaGuardar);
		return ofertaDaoImp.save(ofertaGuardar);
	}
	
	public void mapearOferta(OfertaLaboral desde, OfertaLaboral hacia) {
		hacia.setCantVacantes(desde.getCantVacantes());
		hacia.setPuestoReq(hacia.getPuestoReq());
		hacia.setResumenPuesto(hacia.getResumenPuesto());
		hacia.setDispHoraria(desde.getDispHoraria());
		hacia.setPrincTareas(desde.getPrincTareas());
		hacia.setJornada(desde.getJornada());
		hacia.setRequisitos(desde.getRequisitos());
		hacia.setSalario(desde.getSalario());
		hacia.setBeneficios(desde.getBeneficios());
		hacia.setDisponible(desde.isDisponible());
	}

	@Override
	public void eliminarEmpleo(long id) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public OfertaLaboral encontrarOferta(Long id) throws Exception {
		// TODO Auto-generated method stub
		return ofertaDaoImp.findById(id).orElseThrow(()-> new Exception("La oferta no existe"));
		
	}
}

