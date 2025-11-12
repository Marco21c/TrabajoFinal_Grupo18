package ar.edu.unju.fi.html.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.html.entity.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario,Long>{
  
}
