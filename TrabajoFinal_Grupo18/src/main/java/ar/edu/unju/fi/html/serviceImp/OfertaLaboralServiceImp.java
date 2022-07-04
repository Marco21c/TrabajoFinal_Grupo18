package ar.edu.unju.fi.html.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.entity.OfertaLaboral;
import ar.edu.unju.fi.html.repository.IEmpleadorDAO;
import ar.edu.unju.fi.html.repository.IOfertaLaboralDAO;
import ar.edu.unju.fi.html.service.IOfertaLaboralService;

@Service("OfertaLaboralServiceImp")
public class OfertaLaboralServiceImp implements IOfertaLaboralService {

	@Autowired
	IOfertaLaboralDAO ofertaDaoImp;
	@Autowired
	IEmpleadorDAO empleadorDAOImp;
	

	
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
}

