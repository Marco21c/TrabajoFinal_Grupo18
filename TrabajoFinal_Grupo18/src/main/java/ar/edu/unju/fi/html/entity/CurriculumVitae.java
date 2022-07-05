package ar.edu.unju.fi.html.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

       //Tabla curriculums

@Entity
@Table(name="curriculums")
public class CurriculumVitae {
	   // El id del cv se genera automaticamente 
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
@Column(name="ID_CV")
private long id;
       //validaciones para contacto
@NotEmpty(message="el campo contacto no debe estar vacio.")
@Size(min=8,message="Debe ingresar un correo o telefono.")
@Column(name="CONTACTO_CV")
private String contacto;
       //validaciones para experiencia laboral.
@NotEmpty(message="el campo experiencia laboral no debe estar vacio.")
@Size(min=4,message="Debe ingresar un minimo de 4 caracteres.")
@Column(name="EXP_LABO_CV")
private String expLaboral;
       //validaciones para educacion.
@NotEmpty(message="el campo educacion no debe estar vacio.")
@Column(name="EDUCACION_CV")
private String educacion;
       //validaciones para idiomas.
@NotEmpty(message="el campo idiomas no debe estar vacio.")
@Size(min=6,message="Debe ingresar un minimo de 6 caracteres.")
@Column(name="IDIOMAS_CV")
private String idiomas;
       //validacion para conocimientos informaticos
@NotNull(message="Debe elegir una de las opciones.")
@Column(name="CONOCIM_INFO_CV")
private String conocimientoInfo;
       //validaciones para info complementaria
@Size(min=10, message="Debe ingresar un minimo de 10 caracteres.")
@NotEmpty(message="Este campo no debe estar vacio.")
@Column(name="INFO_COMPLE_CV")
private String infoComplementaria;
       //validaciones para el nombre y apellido
@NotNull(message="Debe ingresar su nombre y apellido.")
@Size(min=7, message="Debe ingresar su nombre y apellido completo.")
@Column(name="NOMBRE_CV")
private String nombre;
      
        //relacion uno a uno con ciudadano. 
@OneToOne(mappedBy = "cv" , fetch = FetchType.LAZY)
private Ciudadano ciudadano;
 
@OneToMany(mappedBy="cv", cascade = CascadeType.ALL)
private List<Solicitud> solicitud;

        // --- constructores --- 

public CurriculumVitae() {
	
}

public CurriculumVitae(String contacto, String expLaboral, String educacion, String idiomas, String conocimientoInfo,
		String infoComplementaria, Ciudadano ciudadanoId,String nombre) {
	super();
	this.contacto = contacto;
	this.expLaboral = expLaboral;
	this.educacion = educacion;
	this.idiomas = idiomas;
	this.conocimientoInfo = conocimientoInfo;
	this.infoComplementaria = infoComplementaria;
	this.nombre = nombre;
}

        //--- getters and setters ---
 
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getContacto() {
	return contacto;
}
public void setContacto(String contacto) {
	this.contacto = contacto;
}
public String getExpLaboral() {
	return expLaboral;
}
public void setExpLaboral(String expLaboral) {
	this.expLaboral = expLaboral;
}
public String getEducacion() {
	return educacion;
}
public void setEducacion(String educacion) {
	this.educacion = educacion;
}
public String getIdiomas() {
	return idiomas;
}
public void setIdiomas(String idiomas) {
	this.idiomas = idiomas;
}
public String getConocimientoInfo() {
	return conocimientoInfo;
}
public void setConocimientoInfo(String conocimientoInfo) {
	this.conocimientoInfo = conocimientoInfo;
}
public String getInfoComplementaria() {
	return infoComplementaria;
}
public void setInfoComplementaria(String infoComplementaria) {
	this.infoComplementaria = infoComplementaria;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}


public Ciudadano getCiudadano() {
	return ciudadano;
}

public void setCiudadano(Ciudadano ciudadano) {
	this.ciudadano = ciudadano;
}

public List<Solicitud> getSolicitud() {
	return solicitud;
}

public void setSolicitud(List<Solicitud> solicitud) {
	this.solicitud = solicitud;
}


}
