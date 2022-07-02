package ar.edu.unju.fi.html.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.CurriculumVitae;
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
		String contra = ciudadano.getUsuario().getContraseña();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		ciudadano.getUsuario().setContraseña(bCryptPasswordEncoder.encode(contra));
		
		ciudadano.getUsuario().setTipo("Ciudadano");
		if(ciudadanoDAOImp.save(ciudadano)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public Ciudadano getBuscarCiudadano(String username) {
		// TODO Auto-generated method stub
		return  ciudadanoDAOImp.findByUsuarioUsername(Long.parseLong(username));
	}

	@Override
	public void modificarCV(Ciudadano ciu,CurriculumVitae cv) {
		// TODO Auto-generated method stub
		 ciu.setCv(cv);
	}

}
