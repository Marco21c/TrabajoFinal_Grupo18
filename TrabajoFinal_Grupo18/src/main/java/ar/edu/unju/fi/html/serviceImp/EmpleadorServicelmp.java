package ar.edu.unju.fi.html.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.repository.IEmpleadorDAO;
import ar.edu.unju.fi.html.service.IEmpleadorService;

@Service("EmpleadorServiceImp")
public class EmpleadorServicelmp implements IEmpleadorService {
	
	@Autowired
	IEmpleadorDAO empleadorDAOImp;
	@Override
	public Empleador getEmpleador() {
		// TODO Auto-generated method stub
		return new Empleador();
	}

	@Override
	public boolean agregarEmpleador(Empleador empleador) {
		// TODO Auto-generated method stub
		String contra = empleador.getUsuario().getContraseña();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		empleador.getUsuario().setContraseña(bCryptPasswordEncoder.encode(contra));
		
		empleador.getUsuario().setTipo("Empleador");
		if(empleadorDAOImp.save(empleador)!=null) {
			return true;	
		}
		return false;
	}

	@Override
	public Empleador getBuscarEmpleador(String username) {
		// TODO Auto-generated method stub
		return empleadorDAOImp.findByUsuarioUsername(Long.parseLong(username));
	}

	@Override
	public void modificarOferta(Empleador oferta) {
		// TODO Auto-generated method stub
		empleadorDAOImp.save(oferta);
	}


    

}
