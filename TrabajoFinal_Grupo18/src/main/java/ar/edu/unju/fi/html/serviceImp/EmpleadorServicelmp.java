package ar.edu.unju.fi.html.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
>>>>>>> branch 'master' of https://github.com/Marco21c/TrabajoFinal_Grupo18.git
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.repository.IEmpleadorDAO;
import ar.edu.unju.fi.html.service.IEmpleadorService;

@Service("EmpleadorServiceImp")
public class EmpleadorServicelmp implements IEmpleadorService {
	
	@Autowired
	IEmpleadorDAO empleadorDaoImp;

	@Autowired
	IEmpleadorDAO iEmpleadorDAO;
	@Override
	public Empleador getEmpleador() {
		// TODO Auto-generated method stub
		return new Empleador();
	}

	@Override
<<<<<<< HEAD
	public void guardarEmpleador(Empleador empleador) {
		empleadorDaoImp.save(empleador);
		
	}

=======
	public boolean agregarEmpleador(Empleador empleador) {
		// TODO Auto-generated method stub
		String contra = empleador.getUsuario().getContraseña();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		empleador.getUsuario().setContraseña(bCryptPasswordEncoder.encode(contra));
		
		empleador.getUsuario().setTipo("Empleador");
		if(iEmpleadorDAO.save(empleador)!=null) {
		 return true;	
		}
		return false;
	}
    
>>>>>>> branch 'master' of https://github.com/Marco21c/TrabajoFinal_Grupo18.git
}
