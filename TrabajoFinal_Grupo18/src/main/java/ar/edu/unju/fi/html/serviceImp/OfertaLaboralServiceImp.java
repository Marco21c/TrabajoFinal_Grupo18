package ar.edu.unju.fi.html.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.OfertaLaboral;
import ar.edu.unju.fi.html.repository.IOfertaLaboralDAO;
import ar.edu.unju.fi.html.service.IOfertaLaboralService;

@Service
public class OfertaLaboralServiceImp implements IOfertaLaboralService {

	@Autowired
	IOfertaLaboralDAO ofertaDaoImp;
	
	@Override
	public void guardarOferta(OfertaLaboral ofertalaboral) {
		ofertaDaoImp.save(ofertalaboral);
		
	}

	@Override
	public List<OfertaLaboral> listarOfertas() {
		// TODO Auto-generated method stub
		return ofertaDaoImp.listarOfertas();
	}

}
