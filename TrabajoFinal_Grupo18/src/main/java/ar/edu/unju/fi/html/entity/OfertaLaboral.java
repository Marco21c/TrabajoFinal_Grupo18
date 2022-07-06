package ar.edu.unju.fi.html.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ofertasLaborales")
public class OfertaLaboral {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="ID", nullable=false)
private long id;
@Column(name ="CANTIDAD_VACANTES", nullable=false)
@NotNull(message="El campo cantidad de vacantes no debe estar vacio.")
private int cantVacantes;
@Column(name ="PUESTO_REQUERIDO", nullable=false)
@NotEmpty(message="El campo Puesto requerido no debe estar vacio.")
private String puestoReq;
@Column(name ="RESUMEN_PUESTO", length = 200, nullable=false)
@NotEmpty(message="El campo resumen de puesto no debe estar vacio.")
private String resumenPuesto;
@Column(name ="DISPONIBILIDAD_HORARIA", nullable=false)
@NotEmpty(message="El campo disponibilidad horaria no debe estar vacio.")
private String dispHoraria;
@Column(name ="PRINCIPALES_TAREAS", length = 200, nullable=false)
@NotEmpty(message="El campo principales tarea no debe estar vacio.")
private String princTareas;
@Column(name ="JORNADA", nullable=false)
@NotEmpty(message="El campo jornada no debe estar vacio.")
private String jornada;
@Column(name ="REQUISITOS", nullable=false)
@NotEmpty(message="El campo requesitos no debe estar vacio.")
private String requisitos;
@Column(name ="SALARIO", nullable=false)
@NotNull(message="El campo salario no debe estar vacio.")
private long salario;
@Column(name ="BENEFICIOS", length = 150, nullable=false)
@NotEmpty(message="El campo beneficio no debe estar vacio.")
private String beneficios;
@Column(name ="DISPONIBLE", nullable=false)
private boolean disponible;

@ManyToOne(fetch =FetchType.LAZY)
@JoinColumn(name ="DATOSEMP_ID")
private Empleador empleador;

@OneToMany(mappedBy="oferta", cascade = CascadeType.ALL)
private List<Solicitud> solicitud;

public OfertaLaboral() {
	
}
 
public OfertaLaboral(int cantVacantes, String puestoReq, String resumenPuesto, String dispHoraria, String princTareas,
		String jornada, String requisitos, long salario, String beneficios, boolean disponible, Empleador empleador) {
	super();
	this.cantVacantes = cantVacantes;
	this.puestoReq = puestoReq;
	this.resumenPuesto = resumenPuesto;
	this.dispHoraria = dispHoraria;
	this.princTareas = princTareas;
	this.jornada = jornada;
	this.requisitos = requisitos;
	this.salario = salario;
	this.beneficios = beneficios;
	this.disponible = disponible;
	this.empleador = empleador;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public int getCantVacantes() {
	return cantVacantes;
}
public void setCantVacantes(int cantVacantes) {
	this.cantVacantes = cantVacantes;
}
public String getPuestoReq() {
	return puestoReq;
}
public void setPuestoReq(String puestoReq) {
	this.puestoReq = puestoReq;
}
public String getResumenPuesto() {
	return resumenPuesto;
}
public void setResumenPuesto(String resumenPuesto) {
	this.resumenPuesto = resumenPuesto;
}
public String getDispHoraria() {
	return dispHoraria;
}
public void setDispHoraria(String dispHoraria) {
	this.dispHoraria = dispHoraria;
}
public String getPrincTareas() {
	return princTareas;
}
public void setPrincTareas(String princTareas) {
	this.princTareas = princTareas;
}
public String getJornada() {
	return jornada;
}
public void setJornada(String jornada) {
	this.jornada = jornada;
}
public String getRequisitos() {
	return requisitos;
}
public void setRequisitos(String requisitos) {
	this.requisitos = requisitos;
}
public long getSalario() {
	return salario;
}
public void setSalario(long salario) {
	this.salario = salario;
}
public String getBeneficios() {
	return beneficios;
}
public void setBeneficios(String beneficios) {
	this.beneficios = beneficios;
}
public boolean isDisponible() {
	return disponible;
}
public void setDisponible(boolean disponible) {
	this.disponible = disponible;
}

public Empleador getEmpleador() {
	return empleador;
}

public void setEmpleador(Empleador empleador) {
	this.empleador = empleador;
}

public List<Solicitud> getSolicitud() {
	return solicitud;
}

public void setSolicitud(List<Solicitud> solicitud) {
	this.solicitud = solicitud;
}


}
