package org.proyecto.empresaB.service.impl;

import java.util.List;

import org.proyecto.empresaB.dao.Cliente_BDao;
import org.proyecto.empresaB.model.Cliente_B;
import org.proyecto.empresaB.service.Cliente_BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("clienteService")
public class Cliente_BServiceImpl implements Cliente_BService{
	
	@Autowired
	Cliente_BDao cliente_BDao;

	public void setCliente_BDao(Cliente_BDao cliente_BDao) {
		this.cliente_BDao = cliente_BDao;
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void save(Cliente_B cliente_B) {
		this.cliente_BDao.save(cliente_B);
		
	}

	public void update(Cliente_B cliente_B) {
		cliente_BDao.update(cliente_B);
		
	}

	public void delete(Cliente_B cliente_B) {
		cliente_BDao.delete(cliente_B);
		
	}
	
	@Transactional
	public Cliente_B findByCliente_BIdCliente_b(String Cliente_BIdCliente_b) {
		
		return cliente_BDao.findByCliente_BIdCliente_b(Cliente_BIdCliente_b);
	}

/*	public Cliente_B findByCliente_B_dni_nif_b(String cliente_B_dni_nif_b) {
		
		return cliente_BDao.findByCliente_B_dni_nif_b(cliente_B_dni_nif_b);
	}*/
	
	@Transactional
	public List<Cliente_B> findAll (){
		return cliente_BDao.findAll();
	}
	
	

}
