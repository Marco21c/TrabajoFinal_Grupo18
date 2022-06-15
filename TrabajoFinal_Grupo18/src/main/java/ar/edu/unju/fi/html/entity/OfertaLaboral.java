package ar.edu.unju.fi.html.entity;

public class OfertaLaboral {

private int id;	
private int cantVacantes;
private String puestoReq;
private String resumenPuesto;
private String dispHoraria;
private String princTareas;
private String jornada;
private String requisitos;
private long salario;
private String beneficios;
private boolean disponible;
private Empleador DatosEmp;

 

 
public OfertaLaboral(int cantVacantes, String puestoReq, String resumenPuesto, String dispHoraria, String princTareas,
		String jornada, String requisitos, long salario, String beneficios, boolean disponible, Empleador datosEmp) {
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
	DatosEmp = datosEmp;
}
public int getId() {
	return id;
}
public void setId(int id) {
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
public Empleador getDatosEmp() {
	return DatosEmp;
}
public void setDatosEmp(Empleador datosEmp) {
	DatosEmp = datosEmp;
}




}

