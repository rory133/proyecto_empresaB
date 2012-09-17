package org.proyecto.empresaB.dao.impl;



import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.proyecto.empresaB.dao.Producto_BDao;
import org.proyecto.empresaB.model.Producto_B;
import org.proyecto.empresaB.util.CustomHibernateDaoSupport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


//@Repository("Producto_BDao")


// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("producto_BDao")
public class Producto_BDaoImpl extends CustomHibernateDaoSupport implements Producto_BDao {

	
	 @Autowired
	 private SessionFactory sessionFactory;
	
	
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
		
	
	/*	System.out.println("en findAll de Producto_BDaoImpl ");
		List <Producto_B> list = getHibernateTemplate().find("from "+ Producto_B.class.getName());
		System.out.println("en findAll de Producto_BDaoImpl tamaño: "+list.size());*/
/*		System.out.println("SessionFactory en findAll" + sessionFactory.getClass().getName());
		Session session=sessionFactory.getCurrentSession();
		System.out.println("despues de getCurrentSession()" );

		session.beginTransaction();
		List <Producto_B> list=null;
		try{
			list=session.createQuery("from Producto_B").list();
			session.getTransaction().commit();
		}catch (HibernateException e){
			session.getTransaction().rollback();
		}
		System.out.println("en findAll de Producto_BDaoImpl tamaño: "+list.size());
		
		return list; */
		
		System.out.println("Nombre de SessionFactory en findAll : " +this.getSessionFactory().toString());
		  return (List<Producto_B>) this.getSessionFactory().getCurrentSession().createCriteria (Producto_B.class ).list();
		
	
		 
/*		Session session=getSessionFactory().getCurrentSession();
		Criteria criteria= getSessionFactory().getCurrentSession().createCriteria("pakito");*/
		
		
		
	       
	       
		
	}

}

