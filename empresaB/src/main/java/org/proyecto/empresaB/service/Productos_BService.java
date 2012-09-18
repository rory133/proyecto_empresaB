package org.proyecto.empresaB.service;

import java.util.List;
import org.proyecto.empresaB.model.Producto_B;
import org.springframework.stereotype.Service;


public interface Productos_BService {
	
	public List<Producto_B> getProductos_B();
	public void save(Producto_B producto_B);

}
