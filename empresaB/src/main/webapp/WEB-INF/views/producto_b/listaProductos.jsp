<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>lista de productos</title>
</head>
<body>

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
    
    	<td>
                ${producto.idproductob}
        </td>
    
        <td>  
              
          <%--    <c:set var="variable" value= "${pageContext.request.contextPath}/resources/imagenes/${producto.idproductob}.jpg"/>
             <c:out value="${variable}" />
              
               <img  src="${variable}"width="200" height="200" /> --%>
               
          <%--   <c:set var="variable" value="${System.Properties("user.home")"}/>
             <c:out value="${variable}" /> --%>
             
             
             
             <c:url var="imageUrl" value="C:\\imagenes\\empresaB\\" />
             
             <%-- <c:out value="${imageUrl}" /> --%>
             
             
            <c:set var="variable" value="${imageUrl}${producto.idproductob}.jpg"/>
          <%--    <c:out value="${variable}" /> --%>
             
             
              <img  src="${variable}"width="100" height="100" /> 
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
    </tr>
</c:forEach>
</table>
</c:if>


</body>
</html>