<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<%-- <link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/master.css" /> --%>
<!-- <link type="text/css" rel="stylesheet"  href="../resources/css/master.css" /> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISTA DE PEDIDOS</title>

<style type="text/css">
h1 {color:#3B0B0B;}
p {color:blue;}
h4 {color:#B40431;}
</style>





</head>



<!-- <style type="text/css">body{background-color:red;}</style> -->
<h3> BIENVENIDO A LA PAGINA DE EMPRESAB <c:out value="${pageContext.request.userPrincipal.name}"/></h3>
<h4> ${errorCarroVacio}	</h4>

<h1> Lista de carros pedidos </h1>


<c:if  test="${!empty TodosLosPedidos}">
<tr>
	<th>IDCLIENTE</th>
	<th>USUARIO</th>
    <th>PAGADO</th>
    <th>ENVIADO</th>
</tr>
  
  <c:forEach items="${TodosLosPedidos}" var="carro">
  <thead>
  <tr>
   
        <td>  
           
   		</td>
  
  </tr>
  <thead>
  </c:forEach>

<c:if  test="${!empty carro.listaProductosSeleccionados}">


<c:set var="fila" value="${0}" scope="page" />


<table class="table">
<tr>
	<th>FILA</th>
	<th>IMAGEN</th>
    <th>CODIGO PRODUCTO</th>
    <th>CANTIDAD PEDIDA</th>
    <th>ELIMINAR</th>

  
</tr>

<c:forEach items="${carro.listaProductosSeleccionados}" var="productosSeleccionados">
    <tr>
   
        <td>  
               ${fila+1} 
   		</td>

        <td>
           
             


              <c:set var="variable" value="${pageContext.request.contextPath}/imagen/${productosSeleccionados.idproducto_b}.jpg" />              
              <img  src="${variable}"width="100" height="100" /> 
              

              




        </td>

        <td>
                ${productosSeleccionados.nombreProducto}
        </td>
        <td>
                ${productosSeleccionados.cantidad}
        </td>
        <td>
        <c:url var="editUrl" value="/carro/eliminarProductoCarro" />
			<a href="${editUrl}?idProductoSeleccionado=${productosSeleccionados.idProductoSeleccionado}&idProducto=${productosSeleccionados.idproducto_b}&cantidad=${productosSeleccionados.cantidad}"    onclick="return confirm('¿Quieres borrar este producto?')" onmouseover="window.status = 'Pulse para eliminar el Producto del carro'; return true" onmouseout="window.status=''"> <span title='Pulse para eliminar el Producto del carro'> <img border=0 src="../resources/imagenes/borrar.jpg" height=68 width=53> </a>
			
                ${productosSeleccionados.idProductoSeleccionado}
        </td>

        
        <sec:authorize access="hasRole('ROLE_CLIENTE')">

       </sec:authorize> 
        
        <sec:authorize access="hasRole('ROLE_ADMIN')">
<%--         <td>
        	<c:url var="editUrl" value="/productos/admin/edit" />
			<a href="${editUrl}?id=${producto.idproductob}"   onclick="return confirm('¿Quieres cambiar datos de este producto?')" onmouseover="window.status = 'Pulse para Editar Producto'; return true" onmouseout="window.status=''"> <span title='Pulse para Editar Producto'> <img border=0 src="../resources/imagenes/modificar.jpg" height=68 width=53> </a>
			
		</td>
		
		<td>

        	<c:url var="editUrl" value="/productos/admin/borrar" />
			<a href="${editUrl}?id=${producto.idproductob}"    onclick="return confirm('¿Quieres borrar este producto?')" onmouseover="window.status = 'Pulse para Borrar Producto'; return true" onmouseout="window.status=''"> <span title='Pulse para Borrar Producto'> <img border=0 src="../resources/imagenes/borrar.jpg" height=68 width=53> </a>
			
		</td> --%>
		</sec:authorize>
		
		


	<c:set var="fila" value="${fila+1}" scope="page" />
    </tr>



</c:forEach>
</table>
</c:if>
</c:if>
<c:if  test="${empty TodosLosPedidos}">
		<h4>no hay pedidos a mostrar</h4>	
</c:if>
<c:url var="editUrl" value="../productos/listado" />
			<a href="${editUrl}"    onmouseover="window.status = 'Pulse para volver al listado de productos'; return true" onmouseout="window.status=''"> <span title='Pulse para volver al listado de productos'> <img border=0 src="../resources/imagenes/listado.jpg" height=68 width=53> </a>
</body>
</html>