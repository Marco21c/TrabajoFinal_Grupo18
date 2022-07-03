package ar.edu.unju.fi.html.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.html.entity.OfertaLaboral;

public interface IOfertaLaboralDAO extends JpaRepository<OfertaLaboral, Long>{

	
	@Query("from OfertaLaboral e orden by e.cantidad_vacantes")
	public List<OfertaLaboral> listarOfertas();
}
