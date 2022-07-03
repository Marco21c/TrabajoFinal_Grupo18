package ar.edu.unju.fi.html.service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.CurriculumVitae;
import ar.edu.unju.fi.html.entity.Curso;

public interface ICiudadanoService {
	public Ciudadano getCiudadano();
	public boolean getGuardarCiudadano(Ciudadano ciudadano); 
    public Ciudadano getBuscarCiudadano(String username);    
    public void getAgregarCurso(Ciudadano ciudadano,Curso curso);
}
