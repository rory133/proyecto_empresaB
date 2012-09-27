package org.proyecto.empresaB.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;


/*@Entity
@Table(name = "usuario_b")*/

@Entity
@Table(name = "usuario_b")
@Inheritance(strategy=InheritanceType.JOINED)
 public class Usuario_B implements Serializable {
	
	private static final long serialVersionUID = -5527566244002296042L;
	
  public Usuario_B() {

	}


  
  @Id
  @Column(name = "IDUSUARIOS_B")
  @GeneratedValue
  private Integer idusuarios_b;
  
  
  @NotNull  
  @Column(name = "DNI_NIF_B")
  private String dni_nif_b;
  
  
  
  @NotNull
  @Column(name = "LOGIN_USUARIO_B")
  private String login_usuario_b;
  
  
  @NotNull
  @Column(name = "PASSWORD_B")
  private String password_b;
  
  
  @NotNull
  @Column(name = "NOMBRE_B")
  private String nombre_b;
  
  @Column(name = "APELLIDOS_B")
  private String apellidos_b;
  
  
  @NotNull
  @Column(name = "EMAIL_B")
  private String email_b;

  
  @Column(name = "TIPO")
  private String tipo;
  
 
  


	public Integer getIdusuarios_b() {
		return idusuarios_b;
	}
	
	public void setIdusuarios_b(Integer idusuarios_b) {
		this.idusuarios_b = idusuarios_b;
	}
	
	public String getDni_nif_b() {
		return dni_nif_b;
	}
	
	public void setDni_nif_b(String dni_nif_b) {
		this.dni_nif_b = dni_nif_b;
	}
	

	
	public String getLogin_usuario_b() {
		return login_usuario_b;
	}

	public void setLogin_usuario_b(String login_usuario_b) {
		this.login_usuario_b = login_usuario_b;
	}

	public String getPassword_b() {
		return password_b;
	}

	public void setPassword_b(String password_b) {
		this.password_b = password_b;
	}

	public String getNombre_b() {
		return nombre_b;
	}
	
	public void setNombre_b(String nombre_b) {
		this.nombre_b = nombre_b;
	}
	
	public String getApellidos_b() {
		return apellidos_b;
	}
	
	public void setApellidos_b(String apellidos_b) {
		this.apellidos_b = apellidos_b;
	}
	
	public String getEmail_b() {
		return email_b;
	}
	
	public void setEmail_b(String email_b) {
		this.email_b = email_b;
	}
	public String getTipo() {
	return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}

