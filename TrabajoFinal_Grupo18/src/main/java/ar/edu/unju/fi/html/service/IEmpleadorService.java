package ar.edu.unju.fi.html.service;


import java.util.List;

import ar.edu.unju.fi.html.entity.CurriculumVitae;
import ar.edu.unju.fi.html.entity.Curso;

import ar.edu.unju.fi.html.entity.Empleador;

public interface IEmpleadorService {
	public Empleador getEmpleador();

	
	public void guardarEmpleador(Empleador empleador);
	public boolean agregarEmpleador(Empleador empleador);
	public List<Curso> getMisCursos(String username);
	public Empleador buscarEmpleador(String username);
	public List<CurriculumVitae> getListarCvs();
	public List<CurriculumVitae> getCvsxProvincia(String provincia);
	public List<CurriculumVitae> getCvsxPalabra(String palabra);
	
}
