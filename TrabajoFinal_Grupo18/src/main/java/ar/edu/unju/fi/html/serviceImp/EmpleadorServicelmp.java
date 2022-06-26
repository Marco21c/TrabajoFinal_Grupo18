package ar.edu.unju.fi.html.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.repository.IEmpleadorDAO;
import ar.edu.unju.fi.html.service.IEmpleadorService;

@Service("EmpleadorServiceImp")
public class EmpleadorServicelmp implements IEmpleadorService {
	
	@Autowired
	IEmpleadorDAO empleadorDaoImp;

	@Override
	public Empleador getEmpleador() {
		// TODO Auto-generated method stub
		return new Empleador();
	}

	@Override
	public void guardarEmpleador(Empleador empleador) {
		empleadorDaoImp.save(empleador);
		
	}

}
