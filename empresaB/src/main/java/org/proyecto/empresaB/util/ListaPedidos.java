package org.proyecto.empresaB.util;

import java.util.Set;

public class ListaPedidos {
	
	Integer IdCliente;
	String LoginCliente;
	Boolean pagado;
	Boolean enviado;
	Set<ListaProductosSeleccionados> listaProductosSeleccionados;
	
	public ListaPedidos() {
	
	}

	public Integer getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Integer idCliente) {
		IdCliente = idCliente;
	}

	
	
	public String getLoginCliente() {
		return LoginCliente;
	}

	public void setLoginCliente(String loginCliente) {
		LoginCliente = loginCliente;
	}

	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	public Boolean getEnviado() {
		return enviado;
	}

	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}

	public Set<ListaProductosSeleccionados> getListaProductosSeleccionados() {
		return listaProductosSeleccionados;
	}

	public void setListaProductosSeleccionados(
			Set<ListaProductosSeleccionados> listaProductosSeleccionados) {
		this.listaProductosSeleccionados = listaProductosSeleccionados;
	}




	

}
