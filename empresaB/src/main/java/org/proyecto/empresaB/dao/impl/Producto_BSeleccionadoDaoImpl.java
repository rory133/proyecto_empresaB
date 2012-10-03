package org.proyecto.empresaB.dao.impl;

import java.util.Iterator;
import java.util.List;


import org.proyecto.empresaB.dao.Producto_BSeleccionadoDao;
import org.proyecto.empresaB.model.Producto_BSeleccionado;
import org.proyecto.empresaB.util.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("Producto_BSeleccionadoDao")
public class Producto_BSeleccionadoDaoImpl extends CustomHibernateDaoSupport implements Producto_BSeleccionadoDao{
	public void save(Producto_BSeleccionado producto_BSeleccionado) {
		
		System.out.println("productoBseleccionado a guardar en save: "+ producto_BSeleccionado.getIdproductob());
		System.out.println("productoBseleccionado id productob a guardar en save : "+ producto_BSeleccionado.getIdproductob());
		System.out.println("CANTIDAD productoBseleccionado id productob a guardar en save : "+ producto_BSeleccionado.getCantidad());
		getHibernateTemplate().save(producto_BSeleccionado);
		//getHibernateTemplate().merge(producto_BSeleccionado);
		//getHibernateTemplate().saveOrUpdate(producto_BSeleccionado);
	
	}



	public void update(Producto_BSeleccionado producto_BSeleccionado) {
		
		System.out.println("productoBseleccionado a guardar en update: "+ producto_BSeleccionado.getIdproductob());
		System.out.println("productoBseleccionado id productob a guardar en update: "+ producto_BSeleccionado.getIdproductob());
		System.out.println("CANTIDAD productoBseleccionado id productob a guardar en update : "+ producto_BSeleccionado.getCantidad());
		//getHibernateTemplate().update(producto_BSeleccionado);
		getHibernateTemplate().merge(producto_BSeleccionado);
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
	
/*	@SuppressWarnings("unchecked")
	public Producto_BSeleccionado findByProducto_BSeleccionadoIdProducto_b_y_carro_b(String Producto_BSeleccionadoIdProducto_b, String carro_b){
		System.out.println("carro_b en find: "+carro_b);
		System.out.println("productoseleccionado en find: "+Producto_BSeleccionadoIdProducto_b);
		List <Producto_BSeleccionado> list = getHibernateTemplate().find(
        	"from Producto_BSeleccionado where IDCARRO_B = ?", Integer.parseInt(carro_b));
		if(!list.isEmpty())
		return (Producto_BSeleccionado)list.get(0);
		
		return null;
		
	}*/
	
	@SuppressWarnings("unchecked")
	public Producto_BSeleccionado findByProducto_BSeleccionadoIdProducto_b_y_carro_b(String Producto_BSeleccionadoIdProducto_b, String carro_b){
		System.out.println("carro_b en find: "+carro_b);
		System.out.println("productoseleccionado en find: "+Producto_BSeleccionadoIdProducto_b);
		List <Producto_BSeleccionado> list = getHibernateTemplate().find(
        	"from Producto_BSeleccionado where IDCARRO_B = ?", Integer.parseInt(carro_b));
		if(list.isEmpty()){
			return null;
		}
		else{
		Iterator<Producto_BSeleccionado> itr = list.iterator();
		while (itr.hasNext()) {
			Producto_BSeleccionado element = itr.next();
			if(element.getIdproductob()==Integer.parseInt(Producto_BSeleccionadoIdProducto_b)){
				return element;
			}
		}

		
		return null;
		
		}
		
	}
	

	@SuppressWarnings("unchecked")
	public List<Producto_BSeleccionado> findAll (){
		List <Producto_BSeleccionado> list = getHibernateTemplate().find("from Producto_BSeleccionado");
		return list;
	}

}

