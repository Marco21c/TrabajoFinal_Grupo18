package ar.edu.unju.fi.html.entity;

import java.time.LocalDate;
import java.util.List;
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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
       //Tabla cursos
@Entity
@Table(name="cursos")
public class Curso {
	   // El id de los cursos se generan automaticamente   
   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY) 
   @Column(name="ID_CURS")
   private long id;
   
	   //validaciones para el nombre del curso
   @NotEmpty(message="El campo nombre del curso no debe estar vacio.")	
   @Size(min=4,message="El nombre debe tener al menos 4 caracteres.")
   @Column(name="NOMBRE_CURS")
   private String nombre;
       
       //validaciones para la categoria
   @NotEmpty(message="El campo categoria no debe estar vacio.")	
   @Column(name="CATEG_CURS")
   private String categoria;
   
       //formato y validacion para la fecha de inicio
   @Column(name="FECHAINC_CURS") @NotNull(message="Debe elegir una fecha para el inicio del curso.")
   @Future(message="Debe ser una fecha posterior a la actual.")
   @DateTimeFormat(pattern= "yyyy-MM-dd")
   private LocalDate fechaInic;
   
       //validaciones para el dictador
   @NotNull(message="Debe ingresar el nombre de su empresa.")
   @Column(name="DICTADOR_CURS")
   private String dictador;
   
       //--- Mapeos --- 
   
       //relacion muchos a muchos con ciudadanos
   @ManyToMany(mappedBy ="cursos")
   private List<Ciudadano> ciudadanos;
       //relacion muchos a uno con empleador 
   @ManyToOne(fetch = FetchType.LAZY)
       //se crea una columna para la clave foranea id de empleador
   @JoinColumn(name= "ID_EMP")
   private Empleador empleador;
   
      // --- constructores ---
   public Curso() {
	   
   }
   
public Curso(String nombre, String categoria, LocalDate fechaInic,List<Ciudadano> ciudadanos,Empleador empleador,String dictador) {
	super();
	this.nombre = nombre;
	this.categoria = categoria;
	this.fechaInic = fechaInic;
	this.ciudadanos = ciudadanos;
	this.empleador= empleador;
	this.dictador = dictador;
}

      //--- getters and setters ---

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

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getDictador() {
	return dictador;
}

public void setDictador(String dictador) {
	this.dictador = dictador;
}
   
   
}
