package ar.edu.unju.fi.html.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="usuarios")
public class Usuario {

@Id
@Column(name="ID_USER")
private long username;

@Column(name="CONTRA_USER")
private String contraseña;

@Column(name="TIPO_USER")
private String tipo;

@OneToOne(mappedBy = "usuario" , fetch = FetchType.LAZY)
private Ciudadano ciudadano;

@OneToOne(mappedBy = "usuario" , fetch = FetchType.LAZY)
private Empleador empleador;


public Usuario() {
	
}
public Usuario(long username, String contraseña, String tipo) {
	super();
	this.username = username;
	this.contraseña = contraseña;
	this.tipo = tipo;
}
public long getUsername() {
	return username;
}
public void setUsername(long username) {
	this.username = username;
}
public String getContraseña() {
	return contraseña;
}
public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public Ciudadano getCiudadano() {
	return ciudadano;
}
public void setCiudadano(Ciudadano ciudadano) {
	this.ciudadano = ciudadano;
}
public Empleador getEmpleador() {
	return empleador;
}
public void setEmpleador(Empleador empleador) {
	this.empleador = empleador;
}


}
