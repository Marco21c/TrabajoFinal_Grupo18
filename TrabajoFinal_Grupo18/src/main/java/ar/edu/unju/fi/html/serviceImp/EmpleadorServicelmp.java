package ar.edu.unju.fi.html.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Curso;
import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.repository.ICursoDAO;
import ar.edu.unju.fi.html.repository.IEmpleadorDAO;
import ar.edu.unju.fi.html.service.IEmpleadorService;

@Service("EmpleadorServiceImp")
public class EmpleadorServicelmp implements IEmpleadorService {

	@Autowired
	IEmpleadorDAO iEmpleadorDAO;
	@Autowired
	ICursoDAO iCursoDAO;
	
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
		if(iEmpleadorDAO.save(empleador)!=null) {
		 return true;	
		}
		return false;
	}

	@Override
	public List<Curso> getMisCursos(String username) {
		Empleador empleador = buscarEmpleador(username);
		
		return iCursoDAO.findByEmpleadorId(empleador.getId());
	}

	@Override
	public Empleador buscarEmpleador(String username) {
		// TODO Auto-generated method stub
		
		return iEmpleadorDAO.findByUsuarioUsername(Long.parseLong(username));
	}
    
}
