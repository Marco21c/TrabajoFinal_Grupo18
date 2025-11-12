package ar.edu.unju.fi.html.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name="solicitudes")
public class Solicitud {
	// El id de ciudadano se genera automaticamente 
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)  
    //se utiliza la notacion column en los atributos para poder nombrar a las diferentes columnas
@Column(name="ID_SOLI")
private long id;

@Column(name="ESTADO_SOLI")
private String estado;
//relacion uno a uno con ciudadano
@Column(name="FECHA_SOLI")
private LocalDate fecha;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="ID_CV")
private CurriculumVitae cv;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="ID_OFERTA")
private OfertaLaboral oferta;



public LocalDate getFecha() {
	return fecha;
}
public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}
public Solicitud(){
	
}
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public CurriculumVitae getCv() {
	return cv;
}
public void setCv(CurriculumVitae cv) {
	this.cv = cv;
}
public OfertaLaboral getOferta() {
	return oferta;
}


public void setOferta(OfertaLaboral oferta) {
	this.oferta = oferta;
}



}


