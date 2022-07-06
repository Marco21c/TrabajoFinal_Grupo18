package ar.edu.unju.fi.html.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.html.entity.OfertaLaboral;

public interface IOfertaLaboralDAO extends JpaRepository<OfertaLaboral, Long>{

   public List<OfertaLaboral> findAllByEmpleadorId(long empleador);
   
   public List<OfertaLaboral> findAllByEmpleadorProvincia(String provincia);
   
   public List<OfertaLaboral> findAllByFechaCreacion(LocalDate fecha);
}
