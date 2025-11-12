package ar.edu.unju.fi.html.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.html.entity.Empleador;


public interface IEmpleadorDAO extends JpaRepository<Empleador,Long> {
	public Empleador findByUsuarioUsername(long username);

	}
