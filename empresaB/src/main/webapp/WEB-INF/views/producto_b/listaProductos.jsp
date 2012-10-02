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
<title>LISTA DE PRODUCTOS</title>


<script language="javascript">
function comprobarCampos() 
{

var form=document.forms[0];
var campo=form.elements[0];
var texto=campo.value;
if (texto==''){
alert("la cantidad no puede estar vacia");
}
var numero=parseInt(texto);
if (isNaN(numero)){
	alert("la cantidad tiene que ser un numero");
	}
document.forms[0].elements[0].value=numero;
}
</script>

<!-- <script language="javascript">
function comprobarCampos()
{
form1.campo1.value="hola";
form1.campo2.select();
alert("este campo no est� vac�o");
}
</script> -->


</head>
<body class="body">
<h2><c:out value="${bienvenida1}" /></h2>
<h2><c:out value="${bienvenida2}" /></h2>
<h2><c:out value="${bienvenida3}" /></h2>


<!-- <style type="text/css">body{background-color:red;}</style> -->
<h3> BIENVENIDO A LA PAGINA DE EMPRESAB <c:out value="${pageContext.request.userPrincipal.name}"/></h3>
<h1> Lista de productos</h1>

<%-- <c:out value="${pageContext.request.contextPath}"/> --%>

<%-- <c:if  test="${empty pageContext.request.userPrincipal.name}">
	<c:redirect url="login" />
</c:if> --%>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <td>
        	<c:url var="editUrl" value="/productos/admin/?new" />
			<a href="${editUrl}"   onclick="return confirm('�Quieres a�dir un nuevo producto?')" onmouseover="window.status = 'Pulse para a�adir un producto'; return true" onmouseout="window.status=''"> <span title='Pulse para A�adir un Producto'> <img border=0 src="../resources/imagenes/nuevo.jpg" height=68 width=53> </a>
			
		</td>
		</sec:authorize>

<c:if  test="${!empty productos}">

<table class="table">
<tr>
	<th>IMAGEN</th>
    <th>CODIGO</th>
    <th>Diametro</th>
    <th>longitud</th>
    <th>precio</th>
    <th>Existencias</th>
  
</tr>

<c:forEach items="${productos}" var="producto">
    <tr>
<%--     
    	<td>
                ${producto.idproductob}
        </td> --%>
    
        <td>  
              
          <%--    <c:set var="variable" value= "${pageContext.request.contextPath}/resources/imagenes/${producto.idproductob}.jpg"/>
             <c:out value="${variable}" />
              
               <img  src="${variable}"width="200" height="200" /> --%>
               
          <%--   <c:set var="variable" value="${System.Properties("user.home")"}/>
             <c:out value="${variable}" /> --%>
             
             
             
     <%--         <c:url var="imageUrl" value="C:\\imagenes\\empresaB\\" /> --%>
             
             <%-- <c:out value="${imageUrl}" /> --%>
             
             
         <%--    <c:set var="variable" value="${imageUrl}${producto.idproductob}.jpg"/> --%>
          <%--    <c:out value="${variable}" /> --%>
             <%-- 
              <c:out value="${variable}" />
              
              <img  src="${variable}"width="100" height="100" /> 
              
              <c:set var="variable" value="/empresaB/imagen/${producto.idproductob}.jpg" />              
              <img  src="${variable}"width="100" height="100" /> 
               <c:out value="${variable}" />
                --%>

              <c:set var="variable" value="${pageContext.request.contextPath}/imagen/${producto.idproductob}.jpg" />              
              <img  src="${variable}"width="100" height="100" /> 
              
              
              
             <%--   <c:out value="${variable}" /> --%>
             
               
               
             <%--  <img  src="${producto.imagen_b}" width="200" height="200" />  --%>
              




        </td>

        <td>
                ${producto.nombre_productoB}
        </td>
        <td>
                ${producto.diametro_b}
        </td>
        <td>
                ${producto.longitud_b}
        </td>
        <td>
                ${producto.precio_b}
        </td>
        <td>
                ${producto.cantidad_existencias}
        </td>
        
        
        <td>	
			<form id="form1" name="form1" method="GET" action="${pageContext.request.contextPath}/carro/sumaProducto/" >
			<label >Cantidad deseada:</label>
			<input name="cantidad" type="text" id="cantidad" onblur="comprobarCampos()" >
			<input type= "hidden" name="idProducto" id="idProducto" value= "${producto.idproductob}"/>
			<input  type="submit" value="Sumar a Carro" />
			<c:out value="valor producto ${producto.idproductob}"/>
			</form>	
				
			
		</td>
        
        
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <td>
        	<c:url var="editUrl" value="/productos/admin/edit" />
			<a href="${editUrl}?id=${producto.idproductob}"   onclick="return confirm('�Quieres cambiar datos de este producto?')" onmouseover="window.status = 'Pulse para Editar Producto'; return true" onmouseout="window.status=''"> <span title='Pulse para Editar Producto'> <img border=0 src="../resources/imagenes/modificar.jpg" height=68 width=53> </a>
			
		</td>
		
		<td>

        	<c:url var="editUrl" value="/productos/admin/borrar" />
			<a href="${editUrl}?id=${producto.idproductob}"    onclick="return confirm('�Quieres borrar este producto?')" onmouseover="window.status = 'Pulse para Borrar Producto'; return true" onmouseout="window.status=''"> <span title='Pulse para Borrar Producto'> <img border=0 src="../resources/imagenes/borrar.jpg" height=68 width=53> </a>
			
		</td>
		</sec:authorize>
		
		
		
				
<%-- 				<input type="text" name="cantidad">
				<c:url var="canti" value="cantidad" />
				<c:out value="${cantidad}"/>
			<c:url var="editUrl" value="/carro/sumaProducto/" />
			<a href="${editUrl}?,idProducto=${producto.idproductob}"   onclick="return confirm('�Quieres a�adir este producto?')" onmouseover="window.status = 'Pulse para A�adir Producto'; return true" onmouseout="window.status=''"> <span title='Pulse para Borrar Producto'> <img border=0 src="../resources/imagenes/borrar.jpg" height=68 width=53> </a>
			
				<form:errors cssClass="error" element="productoSeleecionadoErroneo"/> --%>

	
    </tr>
</c:forEach>
</table>
</c:if>

</body>
</html>