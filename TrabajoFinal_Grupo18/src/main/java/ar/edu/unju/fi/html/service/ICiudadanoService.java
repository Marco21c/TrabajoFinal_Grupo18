package ar.edu.unju.fi.html.service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.CurriculumVitae;

public interface ICiudadanoService {
	public Ciudadano getCiudadano();
	public boolean getGuardarCiudadano(Ciudadano ciudadano); 
    public Ciudadano getBuscarCiudadano(String username);
	public void modificarCV(Ciudadano ciu, CurriculumVitae cv);
    
}
