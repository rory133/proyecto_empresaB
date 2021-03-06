package org.proyecto.empresaB.service;

import java.util.List;

import org.proyecto.empresaB.model.Carro_B;
import org.proyecto.empresaB.model.Producto_BSeleccionado;

public interface Carro_BService {

	void save(Carro_B carro_B);
	
	void update(Carro_B carro_B);
	
	void delete(Carro_B carro_B);
	
	Carro_B findByCarro_BIdCarro_b(String Carro_BIdCarro_b);
	
	List<Producto_BSeleccionado> findByTodosCarro_BIdCarro_b(String carro_BIdCarro_b);
	
	List<Carro_B>findByTodosCarro_BIdCliente_b(String carro_BIdCliente_b);
		
	List<Carro_B> findAll ();

}
