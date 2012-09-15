package org.proyecto.empresaB.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.proyecto.empresaB.bo.Producto_BBo;
import org.proyecto.empresaB.dao.Producto_BDao;
import org.proyecto.empresaB.model.Producto_B;
import org.proyecto.empresaB.service.Productos_BService;
import org.proyecto.empresaB.util.CustomHibernateDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



/*@Service("productoService")*/

/*public class Productos_BServiceImpl implements Productos_BService{*/
@Service
public class Productos_BServiceImpl implements Productos_BService{
	@Autowired
	private Producto_BBo producto_BBo;
	
	public List<Producto_B> getProductos_B(){
		System.out.println("en get producos_B de Productos_BServiceImpl ");
		List <Producto_B> list=producto_BBo.findAll();
		return list;
		
	}
}