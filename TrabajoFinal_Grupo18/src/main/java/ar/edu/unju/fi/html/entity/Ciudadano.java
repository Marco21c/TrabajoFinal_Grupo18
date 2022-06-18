package ar.edu.unju.fi.html.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
@Component
public class Ciudadano {
private long dni;
private long nroTramite;
private String email;
private String estadoCivil;
private String provincia;
private long telefono;
private LocalDate fechaNac;
private String contraseña;


public Ciudadano() {
	
}

public Ciudadano(long dni, long nroTramite, String email, String estadoCivil, String provincia, long telefono,
		LocalDate fechaNac, String contraseña) {
	super();
	this.dni = dni;
	this.nroTramite = nroTramite;
	this.email = email;
	this.estadoCivil = estadoCivil;
	this.provincia = provincia;
	this.telefono = telefono;
	this.fechaNac = fechaNac;
	this.contraseña = contraseña;
}
public long getDni() {
	return dni;
}
public void setDni(long dni) {
	this.dni = dni;
}
public long getNroTramite() {
	return nroTramite;
}
public void setNroTramite(long nroTramite) {
	this.nroTramite = nroTramite;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getEstadoCivil() {
	return estadoCivil;
}
public void setEstadoCivil(String estadoCivil) {
	this.estadoCivil = estadoCivil;
}
public String getProvincia() {
	return provincia;
}
public void setProvincia(String provincia) {
	this.provincia = provincia;
}
public long getTelefono() {
	return telefono;
}
public void setTelefono(long telefono) {
	this.telefono = telefono;
}
public LocalDate getFechaNac() {
	return fechaNac;
}
public void setFechaNac(LocalDate fechaNac) {
	this.fechaNac = fechaNac;
}
public String getContraseña() {
	return contraseña;
}
public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}


}
