package ar.edu.unju.fi.html.entity;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Ciudadano {
@Min(value=1000000, message="EL DNI debe ser mayor o igual a 1.000.000")
private long dni;
@Positive
private long nroTramite;
@NotEmpty @Email
private String email;
@NotBlank(message="el estado civil no debe estar en blanco")
private String estadoCivil;
@NotBlank(message="no debe estar vacio la opcion provincia")
private String provincia;
@Positive
private long telefono;
@Past
private LocalDate fechaNac;
@Size(min=8, message="la contraseña debe tener minimo de 8 caracteres")
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
