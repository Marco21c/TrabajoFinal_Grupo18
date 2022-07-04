package ar.edu.unju.fi.html.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ofertasLaborales")
public class OfertaLaboral {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="ID", nullable=false)
private long id;
@Column(name ="CANTIDAD_VACANTES", nullable=false)
private int cantVacantes;
@Column(name ="PUESTO_REQUERIDO", nullable=false)
private String puestoReq;
@Column(name ="RESUMEN_PUESTO", length = 200, nullable=false)
private String resumenPuesto;
@Column(name ="DISPONIBILIDAD_HORARIA", nullable=false)
private String dispHoraria;
@Column(name ="PRINCIPALES_TAREAS", length = 200, nullable=false)
private String princTareas;
@Column(name ="JORNADA", nullable=false)
private String jornada;
@Column(name ="REQUISITOS", nullable=false)
private String requisitos;
@Column(name ="SALARIO", nullable=false)
private long salario;
@Column(name ="BENEFICIOS", length = 150, nullable=false)
private String beneficios;
@Column(name ="DISPONIBLE", nullable=false)
private boolean disponible;

@ManyToOne(fetch =FetchType.LAZY)
@JoinColumn(name ="DATOSEMP_ID")
private Empleador empleador;

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





}
