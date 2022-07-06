package ar.edu.unju.fi.html.serviceImp;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.CurriculumVitae;
import ar.edu.unju.fi.html.entity.Curso;
import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.repository.ICiudadanoDAO;
import ar.edu.unju.fi.html.repository.ICurriculumDAO;
import ar.edu.unju.fi.html.repository.ICursoDAO;
import ar.edu.unju.fi.html.repository.IEmpleadorDAO;
import ar.edu.unju.fi.html.service.IEmpleadorService;

@Service("EmpleadorServiceImp")
public class EmpleadorServicelmp implements IEmpleadorService {
	
	@Autowired
	ICurriculumDAO iCvDAO;
	@Autowired
	IEmpleadorDAO iEmpleadorDAO;
	
	@Autowired
	ICiudadanoDAO iCiudadanoDAO;
	
	@Override
	public Empleador getEmpleador() {
		// TODO Auto-generated method stub
		return new Empleador();
	}

	

	public boolean agregarEmpleador(Empleador empleador) {
		// metodo que agrega registra nuevo empleador
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
	public Empleador buscarEmpleador(String username) {
		// metodo que busca empleador por su nombre
		
		return iEmpleadorDAO.findByUsuarioUsername(Long.parseLong(username));
	}

	@Override
	public List<CurriculumVitae> getListarCvs() {
		// metodo que trae una lista de curriculum vitae
		return iCvDAO.findAll();
	}
    
	@Override
	public List<CurriculumVitae> getCvsxProvincia(String provincia){
		//busqueda de postulante por provincia
		return iCvDAO.findAllByCiudadanoProvincia(provincia);
	}
	@Override
	public List<CurriculumVitae> getCvsxPalabra(String palabra){
		//busqueda de postulante por palabra clave
		return iCvDAO.findAll(palabra);
	}
	
}
