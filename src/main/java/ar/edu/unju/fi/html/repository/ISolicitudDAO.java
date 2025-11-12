package ar.edu.unju.fi.html.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.html.entity.Solicitud;

public interface ISolicitudDAO extends JpaRepository<Solicitud,Long> {
 
        public List<Solicitud> findAllByCvId(long id);
        
        public List<Solicitud> findAllByOfertaEmpleadorIdAndEstado(long id,String estado);
}
