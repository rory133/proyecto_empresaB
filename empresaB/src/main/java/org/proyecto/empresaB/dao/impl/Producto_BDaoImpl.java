package org.proyecto.empresaB.dao.impl;

import org.proyecto.empresaB.dao.Producto_BDao;
import org.proyecto.empresaB.model.Producto_B;
import org.proyecto.empresaB.util.CustomHibernateDaoSupport;

import java.util.List;

import org.springframework.stereotype.Repository;


//@Repository("Producto_BDao")


// le decimos a Spring que es una clase DAO y que se inyectar� el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("producto_BDao")
public class Producto_BDaoImpl extends CustomHibernateDaoSupport implements Producto_BDao {

	public void save(Producto_B producto_B) {
		getHibernateTemplate().save(producto_B);
	
	}



	public void update(Producto_B producto_B) {
		getHibernateTemplate().update(producto_B);
		
	}

	public void delete(Producto_B producto_B) {
		getHibernateTemplate().delete(producto_B);
		
	}
	@SuppressWarnings("unchecked")
	public Producto_B findByProducto_BIdProducto_b(String producto_BIdProducto_b) {
		
		List<Producto_B> list = getHibernateTemplate().find(
                     "from Producto_B where IDPRODUCTOB = ?",Integer.parseInt(producto_BIdProducto_b));
		return (Producto_B)list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Producto_B findByProducto_B_nombre(String producto_B_nombre) {
		List <Producto_B> list = getHibernateTemplate().find(
                "from Producto_B where NOMBRE_PRODUCTOB = ?",producto_B_nombre);
		return (Producto_B)list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Producto_B> findAll (){
		List <Producto_B> list = getHibernateTemplate().find("from Producto_B");
		return list;
	}

}

