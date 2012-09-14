package org.proyecto.empresaB.dao;

import java.util.List;

import org.proyecto.empresaB.model.Carro_B;
import org.proyecto.empresaB.model.Producto_BSeleccionado;

public interface Producto_BSeleccionadoDao {
	void save(Producto_BSeleccionado producto_BSeleccionado);
	
	void update(Producto_BSeleccionado producto_BSeleccionado);
	
	void delete(Producto_BSeleccionado producto_BSeleccionado);
	
	Producto_BSeleccionado findByProducto_BSeleccionadoIdProducto_b(String Producto_BSeleccionadoIdProducto_b);
	
	Producto_BSeleccionado findByProducto_BSeleccionado_nombre(String producto_BSeleccionado_nombre);
	
	List<Producto_BSeleccionado> findAll ();

}
