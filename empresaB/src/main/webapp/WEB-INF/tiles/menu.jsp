<%--  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>

<%-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.springframework.security.core.AuthenticationException" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ Taglib prefix = "sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 --%>

<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<%-- <link type="text/css" rel="stylesheet"  href="WEB-INF/resources/css/menu.css" />--%>
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/menu.css" /> 
<style type="text/css">
a{
display: block;
text-decoration: none;
color: #004a80;
padding: 5px;
}
 
ul{
width: 500px;
height: 28px;
}
 
ul,li{
list-style: none;
margin:0;
padding:0;
}
 
#nav{
font-family: 'Century Gothic', sans-serif;
}
 
#nav li{
float:left;
/* position: relative; */
width: 125px;
font-size: 14px;
font-variant: small-caps;
border-top:1px solid #004a80;
border-bottom:1px solid #004A80;
}
 
.submenu{
/* display: none; */
/* position: absolute; */
left: -1px;
border:none;
height: auto;
background: none;
}
 
#nav .submenu li{
float: none;
position: static;
margin: 0;
font-size: 11px;
font-variant: normal;
border: 1px solid #004a80;
border-top: none;
width: 124px;
}
 
#nav .submenu li a{
color: #FFFFFF;
background: #004a80 url('fondo_menu_vertical.png') repeat-x 0 0;
width: 114px;
height: 16px;
}
</style>

</head>
<body  >




<!-- <ul>
<li> <a href="#">Home</a></li>
</ul>
<ul>
<li><a href="#">Products</a></li>
<li><a href="#">Services</a></li>
<li><a href="#">About</a></li> 
<li><a href="#">Contact</a></li>
<li><a style="background-image: none;" href="#">Contact</a></li>
</ul> -->
  

  
  <ul id="nav">
  <c:if  test="${empty pageContext.request.userPrincipal.name}">
	<li><a href="${pageContext.request.contextPath}/clientes/?new">Crear Cuenta</a>
	<!-- 	<ul class="submenu">
			<li><a href="#">Submenu 1</a></li>
			<li><a href="#">Submenu 2</a></li>
			<li><a href="#">Submenu 3</a></li>
		</ul>-->
	</li>  
	</c:if>
	
	<c:choose>
  		<c:when test="${empty pageContext.request.userPrincipal.name}">
  			<li><a href="${pageContext.request.contextPath}/login">login</a> </li>
  		</c:when>
  	
		<c:otherwise>
   			<li><a href="<c:url value="/j_spring_security_logout" />">logout</a> </li>
 		</c:otherwise>
	</c:choose>
	
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	
	<li><a href="${pageContext.request.contextPath}/productos/listado">PRODUCTOS</a>
<!-- 		<ul class="submenu">
			<li><a href="#">Submenu 1</a></li>
			<li><a href="#">Submenu 2</a></li>
			<li><a href="#">Submenu 3</a></li>
		</ul> -->
	</li>


	<li><a href="#">CLIENTES</a>
<!-- 		<ul class="submenu">
			<li><a href="#">Submenu 1</a></li>
			<li><a href="#">Submenu 2</a></li>
			<li><a href="#">Submenu 3</a></li>
		</ul> -->
	</li>
	<li><a href="#">PEDIDOS</a>
<!-- 		<ul class="submenu">
			<li><a href="#">Submenu 1</a></li>
			<li><a href="#">Submenu 2</a></li>
			<li><a href="#">Submenu 3</a></li>
		</ul> -->
	</li>
	
	</sec:authorize>
	
	
	
		<sec:authorize access="hasRole('ROLE_CLIENTE')">
	
	<li><a href="#">VER CARRO</a>
<!-- 		<ul class="submenu">
			<li><a href="#">Submenu 1</a></li>
			<li><a href="#">Submenu 2</a></li>
			<li><a href="#">Submenu 3</a></li>
		</ul> -->
	</li>


	<li><a href="#">VER PEDIDOS</a>
<!-- 		<ul class="submenu">
			<li><a href="#">Submenu 1</a></li>
			<li><a href="#">Submenu 2</a></li>
			<li><a href="#">Submenu 3</a></li>
		</ul> -->
	</li>
<!-- 	<li><a href="#">Menu 4</a>
		<ul class="submenu">
			<li><a href="#">Submenu 1</a></li>
			<li><a href="#">Submenu 2</a></li>
			<li><a href="#">Submenu 3</a></li>
		</ul>
	</li> -->
	
	</sec:authorize>
	
	
</ul>
  <c:out value="${pagecontext.request.userprincipal.role}"/>
</body>
</html>