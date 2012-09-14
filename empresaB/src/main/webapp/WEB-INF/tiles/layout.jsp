<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title><tiles:getAsString name="title"/></title> 
<%-- <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/master.css" />  --%>
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/master.css" />
</head> 
<body> 
<!-- <div id="container"> -->

<div id="header">
<tiles:insertAttribute name="header"/>
</div>





<div id="menu">
<tiles:insertAttribute name="menu"/>

</div>

<div id="body">
<tiles:insertAttribute name="body"/>
</div>

<div id="footer">
<tiles:insertAttribute name="footer"/>
</div>


<!-- </div> -->

</body> 
</html>


<%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/master.css" /> 
   <link rel="stylesheet" type="text/css"  href="${webContextRoot}/resources/css/master.css" />
  
    </head>
    <body>
        <table border="1" cellpadding="2" cellspacing="2" align="center">
            <tr>
                <td height="30" colspan="2">
                    <tiles:insertAttribute name="header" />
                </td>
            </tr>
            <tr>
                <td height="250">
                    <tiles:insertAttribute name="menu" />
                </td>
                <td width="350">
                    <tiles:insertAttribute name="body" />
                </td>
            </tr>
            <tr>
                <td height="30" colspan="2">
                    <tiles:insertAttribute name="footer" />
                </td>
            </tr>
        </table>
    </body>
</html>  --%>