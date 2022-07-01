package ar.edu.unju.fi.html.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ciudadanos")
public class Ciudadano {

@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)  
@Column(name="ID_CIU")
private long id;
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

//relacion con un cv
@OneToOne(cascade = {CascadeType.ALL})
@JoinColumn(name="ID_CV")
private CurriculumVitae cv;

//relacion con un usuario 
@OneToOne(cascade = {CascadeType.ALL})
@JoinColumn(name="ID_USER")
private Usuario usuario;

@ManyToMany(mappedBy= "ciudadanos")
private List<Curso> cursos;

public Ciudadano() {
	
}



public Ciudadano(long nroTramite,String email,
		String estadoCivil,
		String provincia,long telefono,
		LocalDate fechaNac,
		CurriculumVitae cv, Usuario usuario,List<Curso> cursos) {
	super();
	this.nroTramite = nroTramite;
	this.email = email;
	this.estadoCivil = estadoCivil;
	this.provincia = provincia;
	this.telefono = telefono;
	this.fechaNac = fechaNac;
	this.cv = cv;
	this.usuario = usuario;
	this.cursos = cursos;
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

public CurriculumVitae getCv() {
	return cv;
}

public void setCv(CurriculumVitae cv) {
	this.cv = cv;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}


public List<Curso> getCursos() {
	return cursos;
}


public void setCursos(List<Curso> cursos) {
	this.cursos = cursos;
}


}
