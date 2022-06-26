package ar.edu.unju.fi.html.service;


import ar.edu.unju.fi.html.entity.Empleador;

public interface IEmpleadorService {
	public Empleador getEmpleador();

	
	public void guardarEmpleador(Empleador empleador);

	public boolean agregarEmpleador(Empleador empleador);

}
