package org.proyecto.empresaB.dao;

import java.util.List;

import org.proyecto.empresaB.model.Administrador_B;

public interface Administrador_BDao {
	void save(Administrador_B administrador_B);
	
	void update(Administrador_B administrador_B);
	
	void delete(Administrador_B administrador_B);
	
	Administrador_B findByAdministrador_BIdAdministrador_b(String Administrador_BIdAdministrador_b);
	
	Administrador_B findByAdministrador_B_dni_nif_b(String administrador_B_dni_nif_b);
	
	List<Administrador_B> findAll ();
}
