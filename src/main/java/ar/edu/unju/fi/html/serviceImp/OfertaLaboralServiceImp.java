package ar.edu.unju.fi.html.serviceImp;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.CurriculumVitae;
import ar.edu.unju.fi.html.entity.OfertaLaboral;
import ar.edu.unju.fi.html.entity.Solicitud;
import ar.edu.unju.fi.html.repository.ICurriculumDAO;
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
	@Autowired
	ICurriculumDAO cvDAOImp;
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
		return ofertaDaoImp.findAllByDisponible(true);
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
		
		return ofertaDaoImp.findAllByEmpleadorProvinciaAndDisponible(Provincia,true);
	}
    @Override
	public List<OfertaLaboral> filtradoxFecha(LocalDate fecha){
    	
    	return ofertaDaoImp.findAllByFechaCreacionAndDisponible(fecha,true);
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
	public void getNuevaSolicitud(CurriculumVitae cv,OfertaLaboral oferta){
		
		Solicitud soli = getSolicitud();
		soli.setCv(cv);
	    soli.setOferta(oferta);
		soli.setEstado("Pendiente");
		soli.setFecha(LocalDate.now());
		solicitudDAOImp.save(soli);
	}
	
	@Override 
	public List<Solicitud> getListaSolicitudesCiu(long id) {
		
		return solicitudDAOImp.findAllByCvId(id);
	}
	
	@Override
	public List<Solicitud> getSolicitudesEmp(long id){
	   
		return solicitudDAOImp.findAllByOfertaEmpleadorIdAndEstado(id,"Pendiente");
	}
	@Override
	public Solicitud getBuscarSolicitud(long id) {
		Optional<Solicitud> soli = solicitudDAOImp.findById(id);
		return soli.get();
	}
	@Override
	public void getActualizarVacantes(long idOferta) {
		Optional<OfertaLaboral> ofertaEncontrada = ofertaDaoImp.findById(idOferta);
		ofertaEncontrada.get().setCantVacantes(ofertaEncontrada.get().getCantVacantes()-1);
		ofertaDaoImp.save(ofertaEncontrada.get());
	}
	@Override
	public boolean getActualizarSolicitud(Solicitud soli) {
		   if(solicitudDAOImp.save(soli)!=null) {
			   return true;
		   }
		
		return false;
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

    @Override
    public CurriculumVitae getBuscarCv(long id) {
    	 
    	Optional<CurriculumVitae> cvEncontrado = cvDAOImp.findById(id);
    	  return cvEncontrado.get();
    }


	@Override
	public void getNuevaSolicitud(Ciudadano ciudadano, OfertaLaboral oferta) {
		// TODO Auto-generated method stub
		
	}

}

