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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//Tabla empleadores

@Entity
@Table(name="empleadores")
public class Empleador {
	 // El id del empleador se genera automaticamente   
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
     //se utiliza la notacion column en los atributos para poder nombrar a las diferentes columnas
@Column(name = "ID_EMP")
private Long id;
     
@Column(name = "RAZON_SOCIAL", nullable = true)
      //validaciones para razon social
@NotEmpty(message="El campo razon social no debe estar vacio.")
private String razonSocial;
      
@Column(name = "NOMBRE_COMERCIAL", nullable = true)
      //validaciones para nombre comercial
@NotNull(message="El campo nombre comercial no debe estar vacio.")
@Size(min=3, message="El nombre comercial debe tener al menos 3 caracteres.")
private String nombreComercial;

@Column(name = "INICIO_ACTIVIDAD", nullable = true)
       //validaciones para fecha de inicio de actividad y formato
@DateTimeFormat(pattern= "yyyy-MM-dd")
@NotNull(message="La fecha no debe estar vacia.")
private LocalDate inicioAct;
       
@Column(name = "EMAIL", nullable = true)
       //validaciones para email
@NotEmpty(message="El campo email no debe estar vacio.")
@Email(message="Debe ingresar un email.")
private String email;
      
@Column(name = "TELEFONO", nullable = true)
       //validaciones para telefono
@NotNull(message="El campo telefono no debe estar vacio.")
@Min(value=8, message="El telefono debe tener al menos ocho digitos.")
private long telefono;

@Column(name = "DOMICILIO", length = 100,nullable = true)
       //validaciones para domicilio 
@NotEmpty(message="El campo domicilio no debe estar vacio.")
private String domicilio;
       //validaciones para provincia
@NotBlank(message="no debe estar vacio la opcion provincia")
@Column(name = "PROVINCIA", nullable = true)
private String provincia;
       //validaciones para pagina web
@NotEmpty(message="no debe estar vacio el campo pagina web.")
@Column(name = "PAGINA_WEB", nullable = true)
private String pagWeb;
       //validaciones para descripcion
@Column(name = "DESCRIPCION", length = 200, nullable = true)
@NotEmpty(message="no debe estar vacio el campo descripcion.")
private String descripcion;

         //--- Mapeo ---      

       //relacion uno a muchos con ofertas laborales
@OneToMany(mappedBy ="datosEmp", cascade = CascadeType.ALL)
private List<OfertaLaboral> ofertaLaboral = new ArrayList<OfertaLaboral>();

       //relacion uno a uno con usuario 
@OneToOne(cascade = {CascadeType.ALL})
@JoinColumn(name="ID_USER")
@Valid //Notacion para permitir las validaciones de Usuario
private Usuario usuario;

@OneToMany(mappedBy ="empleador", cascade = CascadeType.ALL)
private List<Curso> cursos;
       
        // --- constructores ---
public Empleador() {

}
public Empleador(String razonSocial, String nombreComercial, LocalDate inicioAct,
		String email, long telefono, String domicilio, String provincia, String pagWeb, String descripcion,Usuario usuario) {
	super();
	
	this.razonSocial = razonSocial;
	this.nombreComercial = nombreComercial;
	this.inicioAct = inicioAct;
	this.email = email;
	this.telefono = telefono;
	this.domicilio = domicilio;
	this.provincia = provincia;
	this.pagWeb = pagWeb;
	this.descripcion = descripcion;
	this.usuario = usuario;
}

          //--- getters and setters ---

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
public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public List<Curso> getCursos() {
	return cursos;
}
public void setCursos(List<Curso> cursos) {
	this.cursos = cursos;
}


}
