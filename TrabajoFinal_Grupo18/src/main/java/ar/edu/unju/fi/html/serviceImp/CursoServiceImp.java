package ar.edu.unju.fi.html.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Curso;
import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.repository.ICursoDAO;
import ar.edu.unju.fi.html.repository.IEmpleadorDAO;
import ar.edu.unju.fi.html.service.ICursoService;

@Service("CursoServiceImp")
public class CursoServiceImp implements ICursoService {

@Autowired
ICursoDAO icursoDAO;


   @Override
   public Curso getCurso() {
	// TODO Auto-generated method stub
	return new Curso();
   }


	@Override
	public boolean getAgregarCurso(Curso curso) {
		// TODO Auto-generated method stub
	
		if(icursoDAO.save(curso)!=null) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<Curso> getListaCursos() {
		// TODO Auto-generated method stub
		
		return icursoDAO.findAll();
	}

	
}
