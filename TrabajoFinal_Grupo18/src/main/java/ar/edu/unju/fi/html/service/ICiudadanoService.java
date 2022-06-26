package ar.edu.unju.fi.html.service;

import ar.edu.unju.fi.html.entity.Ciudadano;

public interface ICiudadanoService {
	public Ciudadano getCiudadano();
	public boolean getGuardarCiudadano(Ciudadano ciudadano); 
    public Ciudadano getBuscarCiudadano(String username);
    public void modificarCV(Ciudadano cv);
    
}
