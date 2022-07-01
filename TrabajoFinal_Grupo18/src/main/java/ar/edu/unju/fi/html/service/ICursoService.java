package ar.edu.unju.fi.html.service;

import java.util.List;

import ar.edu.unju.fi.html.entity.Curso;

public interface ICursoService {
   public Curso getCurso();
   public boolean getAgregarCurso(Curso curso);
   public List<Curso> getListaCursos();
}
