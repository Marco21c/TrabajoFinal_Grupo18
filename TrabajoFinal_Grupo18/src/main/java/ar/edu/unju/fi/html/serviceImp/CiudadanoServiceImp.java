package ar.edu.unju.fi.html.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.repository.ICiudadanoDAO;
import ar.edu.unju.fi.html.service.ICiudadanoService;

@Service("CiudadanoServiceImp")
public class CiudadanoServiceImp implements ICiudadanoService {

	@Autowired
	ICiudadanoDAO ciudadanoDAOImp;
	
	@Override
	public Ciudadano getCiudadano(){
		// TODO Auto-generated method stub
		return new Ciudadano();
	}

	@Override
	public boolean getGuardarCiudadano(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		if(ciudadanoDAOImp.save(ciudadano)!=null) {
			return true;
		}
		return false;
	}
	
}
