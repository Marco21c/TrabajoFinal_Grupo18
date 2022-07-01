package ar.edu.unju.fi.html.entity;

import java.time.LocalDate;
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
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cursos")
public class Curso {
   
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY) 
	@Column(name="ID_CURS")
   private long id;
   @Column(name="NOMBRE_CURS")
   private String nombre;
   @Column(name="CATEG_CURS")
   private String categoria;
   @DateTimeFormat(pattern= "yyyy-MM-dd")
   @Column(name="FECHAINC_CURS")
   private LocalDate fechaInic;
   
   @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Ciudadano> ciudadanos;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name= "ID_EMP")
   private Empleador empleador;
   
   public Curso() {
	   
   }
   
public Curso(String nombre, String categoria, LocalDate fechaInic,List<Ciudadano> ciudadanos,Empleador empleador) {
	super();
	this.nombre = nombre;
	this.categoria = categoria;
	this.fechaInic = fechaInic;
	this.ciudadanos = ciudadanos;
	this.empleador= empleador;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
public LocalDate getFechaInic() {
	return fechaInic;
}
public void setFechaInic(LocalDate fechaInic) {
	this.fechaInic = fechaInic;
}

public List<Ciudadano> getCiudadanos() {
	return ciudadanos;
}

public void setCiudadanos(List<Ciudadano> ciudadanos) {
	this.ciudadanos = ciudadanos;
}

public Empleador getEmpleador() {
	return empleador;
}

public void setEmpleador(Empleador empleador) {
	this.empleador = empleador;
}
   
   
}
