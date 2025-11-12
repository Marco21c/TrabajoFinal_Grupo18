package ar.edu.unju.fi.html.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Tabla usuarios

@Entity
@Table(name="usuarios")
public class Usuario {
	//Se usa username como clave primaria de esta tabla  
@Id
    //se utiliza la notacion column en los atributos para poder nombrar a las diferentes columnas
@Column(name="ID_USER")
    //validaciones para username
@NotNull(message="No debe estar vacio este campo.")
@Min(value=7,message="Debe ingresar un username con 7 digitos o mas.")
private long username;

@Column(name="CONTRA_USER")
     //validaciones para contraseña
@NotBlank(message="Debe ingresar una contraseña.")
@Size(min=8,message="La contraseña debe tener al menos 8 caracteres.")
private String contraseña;
     //Al atributo tipo se lo utiliza para la autenticacion 
@Column(name="TIPO_USER")
private String tipo;
     //relacion uno a uno con ciudadano
@OneToOne(mappedBy = "usuario" , fetch = FetchType.LAZY)
private Ciudadano ciudadano;
     //relacion uno a uno con empleador
@OneToOne(mappedBy = "usuario" , fetch = FetchType.LAZY)
private Empleador empleador;
    
     // --- constructores ---
public Usuario() {
	
}

public Usuario(long username, String contraseña, String tipo) {
	super();
	this.username = username;
	this.contraseña = contraseña;
	this.tipo = tipo;
}
    // --- getters and setters ---
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
