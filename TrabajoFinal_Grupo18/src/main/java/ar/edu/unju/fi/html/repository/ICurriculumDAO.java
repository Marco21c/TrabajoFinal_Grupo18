package ar.edu.unju.fi.html.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.html.entity.CurriculumVitae;

public interface ICurriculumDAO extends JpaRepository<CurriculumVitae,Long>{

}
