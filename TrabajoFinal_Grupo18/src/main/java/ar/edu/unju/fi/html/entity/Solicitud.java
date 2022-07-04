package ar.edu.unju.fi.html.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@OneToOne(mappedBy = "solicitud",fetch = FetchType.LAZY)
private Ciudadano ciudadano;
//relacion uno a uno con ciudadano
@OneToOne(mappedBy = "solicitud",fetch = FetchType.LAZY)
private OfertaLaboral oferta;

}
