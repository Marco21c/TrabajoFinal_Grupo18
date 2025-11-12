package ar.edu.unju.fi.html.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.html.entity.Curso;

public interface ICursoDAO extends JpaRepository<Curso,Long>{
    
	
	public List<Curso> findByEmpleadorIdAndEstado(long empleador,boolean estado);
	public List<Curso> findAllByEstado(boolean estado);

	
}
