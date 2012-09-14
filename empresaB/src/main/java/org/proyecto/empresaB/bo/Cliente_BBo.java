package org.proyecto.empresaB.bo;

import java.util.List;

import org.proyecto.empresaB.model.Cliente_B;

public interface Cliente_BBo {
	
	void save(Cliente_B cliente_B);
	
	void update(Cliente_B cliente_B);
	
	void delete(Cliente_B cliente_B);
	
	Cliente_B findByCliente_BIdCliente_b(String Cliente_BIdCliente_b);
	
	Cliente_B findByCliente_B_dni_nif_b(String cliente_B_dni_nif_b);
	
	List<Cliente_B> findAll ();

}
