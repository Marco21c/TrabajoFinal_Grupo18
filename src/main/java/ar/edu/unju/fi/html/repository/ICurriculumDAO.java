package ar.edu.unju.fi.html.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.html.entity.CurriculumVitae;

public interface ICurriculumDAO extends JpaRepository<CurriculumVitae,Long>{

	   public List<CurriculumVitae> findAllByCiudadanoProvincia(String provincia);
	   @Query("SELECT c FROM CurriculumVitae c WHERE c.expLaboral LIKE %?1%" + " OR c.educacion LIKE %?1%"
	   + " OR c.idiomas LIKE %?1%" + " OR c.infoComplementaria LIKE %?1%" )
	   public List<CurriculumVitae> findAll(String palabra);
}
