package ar.edu.unju.fi.html.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="empleadores")
public class Empleador {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID")
private Long id;
@Column(name = "CUIT", nullable = true)
private String cuit;
@Column(name = "CONTRASEÑA", length = 8, nullable = true)
private String contraseña;
@Column(name = "RAZON_SOCIAL", nullable = true)
private String razonSocial;
@Column(name = "NOMBRE_COMERCIAL", nullable = true)
private String nombreComercial;
@Column(name = "INICIO_ACTIVIDAD", nullable = true)
@DateTimeFormat(pattern = "dd/MM/yyyy")
private LocalDate inicioAct;
@Column(name = "EMAIL", nullable = true)
private String email;
@Column(name = "TELEFONO", nullable = true)
private long telefono;
@Column(name = "DOMICILIO", length = 100,nullable = true)
private String domicilio;
@Column(name = "PROVINCIA", nullable = true)
private String provincia;
@Column(name = "PAGINA_WEB", nullable = true)
private String pagWeb;
@Column(name = "DESCRIPCION", length = 200, nullable = true)
private String descripcion;

@OneToMany(mappedBy ="datosEmp", cascade = CascadeType.ALL)
private List<OfertaLaboral> ofertaLaboral = new ArrayList<OfertaLaboral>();

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
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public List<OfertaLaboral> getOfertaLaboral() {
	return ofertaLaboral;
}
public void setOfertaLaboral(List<OfertaLaboral> ofertaLaboral) {
	this.ofertaLaboral = ofertaLaboral;
}



}
