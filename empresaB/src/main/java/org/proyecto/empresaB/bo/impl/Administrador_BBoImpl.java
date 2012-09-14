package org.proyecto.empresaB.bo.impl;


import java.util.List;

import org.proyecto.empresaB.bo.Administrador_BBo;
import org.proyecto.empresaB.dao.Administrador_BDao;
import org.proyecto.empresaB.model.Administrador_B;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service("administrador_BBo")//le decimos a Spring que tiene que manejar este bean
public class Administrador_BBoImpl implements Administrador_BBo{
	
	@Autowired
	Administrador_BDao administrador_BDao;

	public void setAdministrador_BDao(Administrador_BDao administrador_BDao) {
		this.administrador_BDao = administrador_BDao;
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void save(Administrador_B administrador_B) {
		this.administrador_BDao.save(administrador_B);
		
	}

	public void update(Administrador_B administrador_B) {
		administrador_BDao.update(administrador_B);
		
	}

	public void delete(Administrador_B administrador_B) {
		administrador_BDao.delete(administrador_B);
		
	}

	public Administrador_B findByAdministrador_BIdAdministrador_b(String Administrador_BIdAdministrador_b) {
		
		return administrador_BDao.findByAdministrador_BIdAdministrador_b(Administrador_BIdAdministrador_b);
	}

	public Administrador_B findByAdministrador_B_dni_nif_b(String administrador_B_dni_nif_b) {
		
		return administrador_BDao.findByAdministrador_B_dni_nif_b(administrador_B_dni_nif_b);
	}
	
	public List<Administrador_B> findAll (){
		return administrador_BDao.findAll();
	}

}
