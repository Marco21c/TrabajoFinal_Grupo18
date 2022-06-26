package ar.edu.unju.fi.html.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.html.entity.Ciudadano;

public interface ICiudadanoDAO extends JpaRepository<Ciudadano,Long> {
   
	   public Ciudadano findByUsuarioUsername(long username);
}
