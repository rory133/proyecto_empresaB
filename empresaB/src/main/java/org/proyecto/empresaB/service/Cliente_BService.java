package org.proyecto.empresaB.service;

import java.util.List;

import org.proyecto.empresaB.model.Cliente_B;

public interface Cliente_BService {
	
	void save(Cliente_B cliente_B);	
	void update(Cliente_B cliente_B);	
	void delete(Cliente_B cliente_B);	
	Cliente_B findByCliente_BIdCliente_b(String Cliente_BIdCliente_b);	
	List<Cliente_B> findAll ();

}
