package org.proyecto.empresaB.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "cliente_b")
@PrimaryKeyJoinColumn(name="IDUSUARIOS_B")
public class Cliente_B  extends Usuario_B implements Serializable {
	private static final long serialVersionUID = -5527566244002296042L;
	
	@Column(name = "FECHA_ALTA_B")
	private Date fecha_alta_b;
	 
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente_b")
	private Set<Carro_B> carro_b = new HashSet<Carro_B>(0);
	
	
	
	
	
	public Cliente_B() {
	}

	
	
	
	public Date getFecha_alta_b() {
		return fecha_alta_b;
	}

	public void setFecha_alta_b(Date fecha_alta_b) {
		this.fecha_alta_b = fecha_alta_b;
	}
	
	
	public Set<Carro_B> getCarro_b() {
		return carro_b;
	}

	public void setCarro_b(Set<Carro_B> carro_b) {
		this.carro_b = carro_b;
	}

	  
	
}

