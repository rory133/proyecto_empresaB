<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
</head>
<body>

<h1> lista de productos</h1>

<c:forEach items="${productos}" var="producto">
    <tr>
        <td>
<%--             <a href="edit${pilot.id}.html"/>Edit</a>
            <a href="delete${pilot.id}.html"/>Delete</a> --%>
        </td>
        <td>
                ${producto.nombre_productoB}
        </td>
        <td>
                ${producto.cantidad_existencias}
        </td>
    </tr>
</c:forEach>

</body>
</html>