package org.proyecto.empresaB.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;




@Entity
@Table(name = "producto_b")
public class Producto_B implements Serializable{
	
	private static final long serialVersionUID = -5527547244002296042L;
	
	  @Id
	//  @Column(name = "IDPRODUCTOB")
	  @Column(name = "IDPRODUCTOB", unique = true, nullable = false)	 
	  @GeneratedValue
	  private Integer idproductob;
	  
	  
	  @Size(min = 3, max = 45, message= "el codio de producto tinene que contener entre 3 y 45 caracteres")
	  @NotNull( message= "el codigo no puede ser nulo")
	  @Column(name = "NOMBRE_PRODUCTOB")
	  private String nombre_productoB;
	  
	  
	  //@Pattern(regexp ="^[0-9]+" ,  message= "el la longitud es un numero con dos decimales")
	//  @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$|^(\\d{3})[\\.](\\d{3})[\\.](\\d{4})$"  ,  message= "el la longitud es un numero con dos decimales")
	  @Digits(integer=5, fraction=0, message= "la cantidad de existencias tiene que ser un numero entero")
	  @Column (name = "CANTIDAD_EXISTENCIAS_B")
	  private Integer cantidad_existencias;
	  
	  @Digits(integer=10, fraction=2,  message= "el la longitud es un numero con dos decimales")
	  @Column (name = "LONGITUD_B")
	  private BigDecimal longitud_b;
	  
	  
	  @Digits(integer=10, fraction=2,  message= "el diametro es un numero con dos decimales")
	  @Column (name = "DIAMETRO_B")
	  private BigDecimal diametro_b;
	  
	  @Digits(integer=10, fraction=2,  message= "el precion es un numero con dos decimales")
	  @Column (name = "PRECIO_B")
	  private BigDecimal precio_b;
	  

	  
	//  private Producto_BSeleccionado pruducto_BSeleccionado;
	  
	  
	  










	public Producto_B() {
		//this.nombre_productoB = "pakitin";
	}







	public Producto_B(String nombre_productoB, Integer cantidad_existencias,
			BigDecimal longitud_b, BigDecimal diametro_b, BigDecimal precio_b) {
		super();
		this.nombre_productoB = nombre_productoB;
		this.cantidad_existencias = cantidad_existencias;
		this.longitud_b = longitud_b;
		this.diametro_b = diametro_b;
		this.precio_b = precio_b;
	}
	public void imprimir(){
		System.out.print(this.getIdproductob());
		System.out.print(" : ");		
		System.out.print(this.getNombre_productoB());
		System.out.print(" : ");
		System.out.print(this.getCantidad_existencias());
		System.out.print(" : ");
		System.out.print(this.getPrecio_b());
		System.out.println("en producto");
	}







	public Integer getIdproductob() {
		return idproductob;
	}



	public void setIdproductob(Integer idproductob) {
		this.idproductob = idproductob;
	}



	public String getNombre_productoB() {
		return nombre_productoB;
	}



	public void setNombre_productoB(String nombre_productoB) {
		this.nombre_productoB = nombre_productoB;
	}



	public Integer getCantidad_existencias() {
		return cantidad_existencias;
	}



	public void setCantidad_existencias(Integer cantidad_existencias) {
		this.cantidad_existencias = cantidad_existencias;
	}


	public BigDecimal getLongitud_b() {
		return longitud_b;
	}







	public void setLongitud_b(BigDecimal longitud_b) {
		this.longitud_b = longitud_b;
	}







	public BigDecimal getDiametro_b() {
		return diametro_b;
	}







	public void setDiametro_b(BigDecimal diametro_b) {
		this.diametro_b = diametro_b;
	}







	public BigDecimal getPrecio_b() {
		return precio_b;
	}







	public void setPrecio_b(BigDecimal precio_b) {
		this.precio_b = precio_b;
	}
	
	
	


	
/*	@OneToOne(fetch = FetchType.LAZY, mappedBy = "producto_b", cascade = CascadeType.ALL)
	public Producto_BSeleccionado getPruducto_BSeleccionado() {
		return pruducto_BSeleccionado;
	}


	public void setPruducto_BSeleccionado(
			Producto_BSeleccionado pruducto_BSeleccionado) {
		this.pruducto_BSeleccionado = pruducto_BSeleccionado;
	}
*/
	
	
	  

}
