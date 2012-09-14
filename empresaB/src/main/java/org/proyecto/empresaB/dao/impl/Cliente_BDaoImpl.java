package org.proyecto.empresaB.dao.impl;

import org.proyecto.empresaB.dao.Cliente_BDao;
import org.proyecto.empresaB.model.Cliente_B;
import org.proyecto.empresaB.util.CustomHibernateDaoSupport;

import java.util.List;
import org.springframework.stereotype.Repository;


//@Repository("Cliente_BDao")


// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("cliente_BDao")
public class Cliente_BDaoImpl extends CustomHibernateDaoSupport implements Cliente_BDao {

	public void save(Cliente_B cliente_B) {
		getHibernateTemplate().save(cliente_B);
	
	}



	public void update(Cliente_B cliente_B) {
		getHibernateTemplate().update(cliente_B);
		
	}

	public void delete(Cliente_B cliente_B) {
		getHibernateTemplate().delete(cliente_B);
		
	}

	@SuppressWarnings("unchecked")
	public Cliente_B findByCliente_BIdCliente_b(String cliente_BIdCliente_b) {
		List<Cliente_B> list = getHibernateTemplate().find(
                     "from Cliente_B where idusuarios_b= ?",Integer.parseInt(cliente_BIdCliente_b));
		return (Cliente_B)list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Cliente_B findByCliente_B_dni_nif_b(String cliente_B_dni_nif_b) {
		List <Cliente_B> list = getHibernateTemplate().find(
                "from Cliente_B where dni_nif_b = ?",cliente_B_dni_nif_b);
		return (Cliente_B)list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente_B> findAll (){
		List <Cliente_B> list = getHibernateTemplate().find("from Cliente_B");
		return list;
	}

}