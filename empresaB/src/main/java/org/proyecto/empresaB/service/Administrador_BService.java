package org.proyecto.empresaB.service;

import java.util.List;

import org.proyecto.empresaB.model.Administrador_B;
import org.proyecto.empresaB.model.Usuario_B;

public interface Administrador_BService {
	
	
	void save(Administrador_B administrador_B);	
	void update(Administrador_B administrador_B);	
	void delete(Administrador_B administrador_B);	
	Administrador_B findByAdministrador_BIdAdministrador_b(String Administrador_BIdAdministrador_b);	
	Usuario_B findByAdministrador_B_login_usuario_b(String administrador_B_login_usuario_b);
	List<Administrador_B> findAll ();

}
