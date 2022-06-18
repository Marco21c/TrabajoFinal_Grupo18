package ar.edu.unju.fi.html.serviceImp;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.service.IEmpleadorService;

@Service("EmpleadorServiceImp")
public class EmpleadorServicelmp implements IEmpleadorService {

	@Override
	public Empleador getEmpleador() {
		// TODO Auto-generated method stub
		return new Empleador();
	}

}
