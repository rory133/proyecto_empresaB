package org.proyecto.empresaB.dao.impl;

import java.util.List;


import org.proyecto.empresaB.dao.Producto_BSeleccionadoDao;
import org.proyecto.empresaB.model.Producto_BSeleccionado;
import org.proyecto.empresaB.util.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("Producto_BSeleccionadoDao")
public class Producto_BSeleccionadoDaoImpl extends CustomHibernateDaoSupport implements Producto_BSeleccionadoDao{
	public void save(Producto_BSeleccionado producto_BSeleccionado) {
		getHibernateTemplate().save(producto_BSeleccionado);
	
	}



	public void update(Producto_BSeleccionado producto_BSeleccionado) {
		getHibernateTemplate().update(producto_BSeleccionado);
		
	}

	public void delete(Producto_BSeleccionado producto_BSeleccionado) {
		getHibernateTemplate().delete(producto_BSeleccionado);
		
	}
	@SuppressWarnings("unchecked")
	public Producto_BSeleccionado findByProducto_BSeleccionadoIdProducto_b(String producto_BSeleccionadoIdProducto_b) {
		
		List<Producto_BSeleccionado> list = getHibernateTemplate().find(
                     "from Producto_BSeleccionado where IDPRODUCTOB = ?",Integer.parseInt(producto_BSeleccionadoIdProducto_b));
		return (Producto_BSeleccionado)list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Producto_BSeleccionado findByProducto_BSeleccionado_nombre(String producto_BSeleccionado_nombre) {
		List <Producto_BSeleccionado> list = getHibernateTemplate().find(
                "from Producto_BSeleccionado where NOMBRE_PRODUCTOB = ?",producto_BSeleccionado_nombre);
		return (Producto_BSeleccionado)list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Producto_BSeleccionado> findAll (){
		List <Producto_BSeleccionado> list = getHibernateTemplate().find("from Producto_BSeleccionado");
		return list;
	}

}

