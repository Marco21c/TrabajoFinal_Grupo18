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
   
	  
   @Column(name="NOMBRE_CURS")
   private String nombre;
       
    
   @Column(name="CATEG_CURS")
   private String categoria;
   
 
   @Column(name="FECHAINC_CURS")
   @Future(message="Debe ser fecha posterior.")
   @DateTimeFormat(pattern= "yyyy-MM-dd")
   private LocalDate fechaInic;
   

   
   @Column(name="DICTADOR_CURS")
   private String dictador;
   
   @Column(name= "ESTADO_CURS")
   private boolean estado;
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

public boolean isEstado() {
	return estado;
}

public void setEstado(boolean estado) {
	this.estado = estado;
}
   
   
}
