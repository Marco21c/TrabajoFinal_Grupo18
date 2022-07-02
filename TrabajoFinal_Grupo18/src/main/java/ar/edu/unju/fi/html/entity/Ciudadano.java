package ar.edu.unju.fi.html.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

//Tabla ciudadanos

@Entity
@Table(name="ciudadanos")
public class Ciudadano {
	// El id de ciudadano se genera automaticamente 
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)  
    //se utiliza la notacion column en los atributos para poder nombrar a las diferentes columnas
@Column(name="ID_CIU")
private long id;

@Column(name="N_TRAMITE_CIU")
    //validaciones para numero de Tramite
@NotNull(message="El campo numero de Tramite no debe estar vacio.")
@Positive(message="Debe ingresar un numero mayor a 0.")
private long nroTramite;

@Column(name="EMAIL_CIU")
    //validaciones para email
@NotEmpty(message="El campo email no debe estar vacio.") 
@Email(message="Debe ingresar un email.")
private String email;

@Column(name="EST_CIVIL_CIU")
    //validaciones para estado civil
@NotBlank(message="el estado civil no debe estar en blanco")
private String estadoCivil;

@Column(name="PROVINCIA_CIU")
    //validaciones para provincia
@NotBlank(message="no debe estar vacio la opcion provincia")
private String provincia;

@Column(name="TELEFONO_CIU")
    //validaciones para telefono
@Min(value=8, message="El telefono debe tener al menos ocho digitos.")
@NotNull(message="el campo telefono no debe estar vacio.")
private long telefono;
    //validaciones para fecha de nacimiento y formato
@Past(message="Debe ser una fecha anterior a la actual.")
@DateTimeFormat(pattern= "yyyy-MM-dd")
@Column(name="FECHAN_CIU") @NotNull(message="Debe ingresar una fecha.")
private LocalDate fechaNac;

    //relacion uno a uno con un cv
@OneToOne(cascade = {CascadeType.ALL})
@JoinColumn(name="ID_CV")
private CurriculumVitae cv;

    //relacion uno a uno con un usuario 
@OneToOne(cascade = {CascadeType.ALL})
@JoinColumn(name="ID_USER")
@Valid //Notacion para permitir las validaciones de Usuario
private Usuario usuario;
    //relacion muchos a muchos con ciudadanos
@ManyToMany(mappedBy= "ciudadanos")
private List<Curso> cursos;
       
     // --- constructores ---
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

     //--- getters and setters ---

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

 //metodo de calcular la edad 
  public int calcularEdad(LocalDate fecha_nac) {
	  Period transcurrido = Period.between(fecha_nac,  LocalDate.now());
	  int edad = transcurrido.getYears(); 
	return edad;
  }

}
