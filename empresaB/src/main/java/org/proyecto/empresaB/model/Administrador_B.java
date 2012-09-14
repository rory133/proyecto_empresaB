package org.proyecto.empresaB.model;

import java.io.Serializable;




import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "administrador_b")
@PrimaryKeyJoinColumn(name="IDUSUARIOS_B")
public class Administrador_B  extends Usuario_B implements Serializable {
	private static final long serialVersionUID = -5527566244002296042L;
	
	private String cargo;
	private String matricula;
	
	
	public Administrador_B() {
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	

	  
	  
	
}

