package org.proyecto.empresaB.dao.impl;

import org.proyecto.empresaB.dao.Carro_BDao;
import org.proyecto.empresaB.model.Carro_B;
import org.proyecto.empresaB.model.Producto_BSeleccionado;
import org.proyecto.empresaB.util.CustomHibernateDaoSupport;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository("Carro_BDao")


// le decimos a Spring que es una clase DAO y que se inyectar� el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("carro_BDao")
public class Carro_BDaoImpl extends CustomHibernateDaoSupport implements Carro_BDao {

	public void save(Carro_B carro_B) {
		getHibernateTemplate().save(carro_B);
	
	}



	public void update(Carro_B carro_B) {
		getHibernateTemplate().update(carro_B);
		
	}

	public void delete(Carro_B carro_B) {
		getHibernateTemplate().delete(carro_B);
		
	}

	public Carro_B findByCarro_BIdCarro_b(String carro_BIdCarro_b) {
		List<Carro_B> list = getHibernateTemplate().find(
                     "from Carro_B where idcarros_b = ?",Integer.parseInt(carro_BIdCarro_b));
		return (Carro_B)list.get(0);
	}
	
	public List<Producto_BSeleccionado>findByTodosCarro_BIdCarro_b(String carro_BIdCarro_b) {
		List<Producto_BSeleccionado> list = getHibernateTemplate().find(
                    "from Producto_BSeleccionado where idcarro_b = ?",Integer.parseInt(carro_BIdCarro_b));
		return list;
	}
	
	public List<Carro_B>findByTodosCarro_BIdCliente_b(String carro_BIdCliente_b) {
		List<Carro_B> list = getHibernateTemplate().find(
                    "from Carro_B where idcliente = ?",Integer.parseInt(carro_BIdCliente_b) );
		return list;
	}


	public List<Carro_B> findAll(){
		List <Carro_B> list = getHibernateTemplate().find("from Carro_B");
		return list;
	}

}