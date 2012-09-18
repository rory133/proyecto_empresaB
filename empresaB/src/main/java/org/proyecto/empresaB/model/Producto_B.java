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
	  
	  
	  @Size(min = 7, max = 45, message= "el tamaño tinene que ser entre uno y 45")
	  @Column(name = "NOMBRE_PRODUCTOB")
	  private String nombre_productoB;
	  
	  @Column (name = "CANTIDAD_EXISTENCIAS_B")
	  private Integer cantidad_existencias;
	  
	  @Size(min=1,  message=	"tamaño minimo 1.")
	  @Column (name = "LONGITUD_B")
	  private String longitud_b;
	  
	  @Column (name = "DIAMETRO_B")
	  private String diametro_b;
	  
	  @Column (name = "PRECIO_B")
	  private BigDecimal precio_b;
	  
	//  private Producto_BSeleccionado pruducto_BSeleccionado;
	  
	  
	  



	public Producto_B() {
		//this.nombre_productoB = "pakitin";
	}







	public Producto_B(String nombre_productoB, Integer cantidad_existencias,
			String longitud_b, String diametro_b, BigDecimal precio_b) {
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







	public String getLongitud_b() {
		return longitud_b;
	}







	public void setLongitud_b(String longitud_b) {
		this.longitud_b = longitud_b;
	}







	public String getDiametro_b() {
		return diametro_b;
	}







	public void setDiametro_b(String diametro_b) {
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
