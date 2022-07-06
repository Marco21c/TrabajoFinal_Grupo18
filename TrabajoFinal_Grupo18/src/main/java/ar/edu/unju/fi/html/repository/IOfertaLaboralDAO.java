package ar.edu.unju.fi.html.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.html.entity.OfertaLaboral;

public interface IOfertaLaboralDAO extends JpaRepository<OfertaLaboral, Long>{

   public List<OfertaLaboral> findAllByEmpleadorId(long empleador);
   public List<OfertaLaboral> findAllByDisponible(boolean disponible);
   public List<OfertaLaboral> findAllByEmpleadorIdAndDisponible( long empleador, boolean disponible);
   
   public List<OfertaLaboral> findAllByEmpleadorProvinciaAndDisponible(String provincia,boolean disponible);
   
   public List<OfertaLaboral> findAllByFechaCreacionAndDisponible(LocalDate fecha,boolean disponible);
}
