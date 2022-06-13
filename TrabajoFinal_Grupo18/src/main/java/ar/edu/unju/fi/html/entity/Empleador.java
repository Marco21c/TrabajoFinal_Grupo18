package ar.edu.unju.fi.html.entity;

import java.time.LocalDate;

public class Empleador {
private String cuit;
private String contraseña;
private String razonSocial;
private String nombreComercial;
private LocalDate inicioAct;
private String email;
private long telefono;
private String domicilio;
private String provincia;
private String pagWeb;
private String descripcion;

public Empleador() {

}
public Empleador(String cuit, String contraseña, String razonSocial, String nombreComercial, LocalDate inicioAct,
		String email, long telefono, String domicilio, String provincia, String pagWeb, String descripcion) {
	super();
	this.cuit = cuit;
	this.contraseña = contraseña;
	this.razonSocial = razonSocial;
	this.nombreComercial = nombreComercial;
	this.inicioAct = inicioAct;
	this.email = email;
	this.telefono = telefono;
	this.domicilio = domicilio;
	this.provincia = provincia;
	this.pagWeb = pagWeb;
	this.descripcion = descripcion;
}

public String getCuit() {
	return cuit;
}

public void setCuit(String cuit) {
	this.cuit = cuit;
}

public String getContraseña() {
	return contraseña;
}

public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}

public String getRazonSocial() {
	return razonSocial;
}

public void setRazonSocial(String razonSocial) {
	this.razonSocial = razonSocial;
}

public String getNombreComercial() {
	return nombreComercial;
}

public void setNombreComercial(String nombreComercial) {
	this.nombreComercial = nombreComercial;
}

public LocalDate getInicioAct() {
	return inicioAct;
}

public void setInicioAct(LocalDate inicioAct) {
	this.inicioAct = inicioAct;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public long getTelefono() {
	return telefono;
}

public void setTelefono(long telefono) {
	this.telefono = telefono;
}

public String getDomicilio() {
	return domicilio;
}

public void setDomicilio(String domicilio) {
	this.domicilio = domicilio;
}

public String getProvincia() {
	return provincia;
}

public void setProvincia(String provincia) {
	this.provincia = provincia;
}

public String getPagWeb() {
	return pagWeb;
}

public void setPagWeb(String pagWeb) {
	this.pagWeb = pagWeb;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


}
