package ar.edu.unju.fi.html.service;

import java.util.List;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Curso;

public interface ICursoService {
   public Curso getCurso();
   public boolean getAgregarCurso(Curso curso);
   public List<Curso> getListaCursos();
   public List<Curso> getMisCursos(Ciudadano ciudadano);
   public Curso buscarCurso(long id);
   public boolean verificarCursos(long id, Ciudadano ciudadano) throws Exception;
   public List<Curso> getMisCursos(long id);
}
