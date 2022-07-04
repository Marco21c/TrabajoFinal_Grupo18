package ar.edu.unju.fi.html.service;

import ar.edu.unju.fi.html.entity.Empleador;

public interface IEmpleadorService {
	public Empleador getEmpleador();
	public boolean agregarEmpleador(Empleador empleador);
	public Empleador getBuscarEmpleador(String username);
	public void modificarOferta(Empleador oferta);

}
