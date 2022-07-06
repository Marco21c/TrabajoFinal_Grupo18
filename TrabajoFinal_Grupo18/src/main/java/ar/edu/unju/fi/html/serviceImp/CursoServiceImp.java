package ar.edu.unju.fi.html.serviceImp;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Curso;
import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.repository.ICursoDAO;
import ar.edu.unju.fi.html.service.ICursoService;

@Service("CursoServiceImp")
public class CursoServiceImp implements ICursoService {

@Autowired
ICursoDAO icursoDAO;


   @Override
   public Curso getCurso() {
	//metodo que crea nuevo curso
	return new Curso();
   }


	@Override
	public boolean getAgregarCurso(Curso curso) {
		// metodo para agregar curso
	
		if(icursoDAO.save(curso)!=null) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<Curso> getListaCursos() {
		// metodo para mostrar la lista de cursos vigente
		
		return icursoDAO.findAllByEstado(true);
	}


	@Override
	public List<Curso> getMisCursos(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		return ciudadano.getCursos();
	}


	@Override
	public Curso buscarCurso(long id) {
		// metodo para buscar curso mediante el ID
		Optional<Curso> curso =  icursoDAO.findById(id); 
		return curso.get();
	}

	@Override
	public boolean verificarCursos(long id,Ciudadano ciudadano) throws Exception{
		 
		Optional<Curso> cursoEncontrado =Optional.ofNullable(ciudadano.getCursos().stream().filter(c -> c.getId() == id).findFirst().orElseThrow(()-> new Exception("Se agrego.")));
		
		if(cursoEncontrado.get()!=null) {
			return true;
		}
		
		return false;
	}
	@Override
	public List<Curso> getMisCursos(long id) {
		
		return icursoDAO.findByEmpleadorIdAndEstado(id, true);
	}
}
