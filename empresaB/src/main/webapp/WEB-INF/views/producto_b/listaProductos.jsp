<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 

<%-- <link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/master.css" /> --%>
<!-- <link type="text/css" rel="stylesheet"  href="../resources/css/master.css" /> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>lista de productos</title>


</head>
<body class="body">

<!-- <style type="text/css">body{background-color:red;}</style> -->

<h1> lista de productos</h1>



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
        	<c:url var="editUrl" value="/productos/edit" />
			<a href="${editUrl}?id=${producto.idproductob}"   onclick="return confirm('¿Quieres cambiar datos de este producto?')"> <img border=0 src="../resources/imagenes/modificar.jpg" height=68 width=53> </a>
			
		</td>
		
		<td>

        	<c:url var="editUrl" value="/productos/borrar" />
			<a href="${editUrl}?id=${producto.idproductob}"   onclick="return confirm('¿Quieres borrar este producto?')"> <img border=0 src="../resources/imagenes/borrar.jpg" height=68 width=53> </a>
			
		</td>
	
    </tr>
</c:forEach>
</table>
</c:if>


</body>
</html>