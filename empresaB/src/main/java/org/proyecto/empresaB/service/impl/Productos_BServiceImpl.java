package org.proyecto.empresaB.service.impl;

import java.util.List;
import org.proyecto.empresaB.dao.Producto_BDao;
import org.proyecto.empresaB.model.Producto_B;
import org.proyecto.empresaB.service.Productos_BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("productoService")
public class Productos_BServiceImpl implements Productos_BService{
	@Autowired
	private Producto_BDao producto_BDao;
	
	public List<Producto_B> getProductos_B(){
		List <Producto_B> list=producto_BDao.findAll();
		return list;
		
	}
}