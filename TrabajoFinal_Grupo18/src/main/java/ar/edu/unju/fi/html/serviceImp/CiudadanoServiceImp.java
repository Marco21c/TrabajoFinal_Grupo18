package ar.edu.unju.fi.html.serviceImp;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.service.ICiudadanoService;

@Service("CiudadanoServiceImp")
public class CiudadanoServiceImp implements ICiudadanoService {

	@Override
	public Ciudadano getCiudadano() {
		// TODO Auto-generated method stub
		return new Ciudadano();
	}
	
}
