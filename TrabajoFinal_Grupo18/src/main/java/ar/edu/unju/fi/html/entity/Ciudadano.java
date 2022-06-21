package ar.edu.unju.fi.html.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="ciudadanos")
public class Ciudadano {

@Id
@Column(name="DNI_CIU")
@Min(value=1000000, message="EL DNI debe ser mayor o igual a 1.000.000")
private long dni;
@Column(name="N_TRAMITE_CIU")
@Positive(message="Debe ser un numero mayor a 0.")
private long nroTramite;
@Column(name="EMAIL_CIU")
@NotEmpty @Email
private String email;
@Column(name="EST_CIVIL_CIU")
@NotBlank(message="el estado civil no debe estar en blanco")
private String estadoCivil;
@Column(name="PROVINCIA_CIU")
@NotBlank(message="no debe estar vacio la opcion provincia")
private String provincia;
@Positive
@Column(name="TELEFONO_CIU")
private long telefono;
@Past(message="Debe ser una fecha anterior a la actual.")
@DateTimeFormat(pattern= "yyyy-MM-dd")
@Column(name="FECHAN_CIU") @NotNull(message="Debe ingresar una fecha.")
private LocalDate fechaNac;
@Column(name="CONTRASEÑA_CIU")
@Size(min=8, message="la contraseña debe tener minimo de 8 caracteres")
private String contraseña;

@OneToOne(mappedBy="ciudadanoId", cascade= CascadeType.ALL)
private CurriculumVitae cv;


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

public CurriculumVitae getCv() {
	return cv;
}

public void setCv(CurriculumVitae cv) {
	this.cv = cv;
}


}
