package ar.edu.unju.fi.html.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

@OneToOne(cascade = {CascadeType.ALL})
@JoinColumn(name="ID_CIU")
@Valid
private Ciudadano ciudadano;

@OneToOne(cascade = {CascadeType.ALL})
@JoinColumn(name="ID")
@Valid //Notacion para permitir las validaciones 
private OfertaLaboral oferta;

public Solicitud(String estado, @Valid Ciudadano ciudadano, @Valid OfertaLaboral oferta) {
	super();
	this.estado = estado;
	this.ciudadano = ciudadano;
	this.oferta = oferta;
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

public Ciudadano getCiudadano() {
	return ciudadano;
}

public void setCiudadano(Ciudadano ciudadano) {
	this.ciudadano = ciudadano;
}

public OfertaLaboral getOferta() {
	return oferta;
}

public void setOferta(OfertaLaboral oferta) {
	this.oferta = oferta;
}



}


