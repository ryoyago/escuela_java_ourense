<%-- 
    Document   : registrado
    Created on : 21-feb-2019, 23:21:10
    Author     : IEUser
--%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp" %>
<%@page import="com.vn.appusuarios.modelo.Usuario"%>
<%@page import="com.vn.appusuarios.modelo.logica.ServiciosUsuarios"%>
<% 
	//ServiciosUsuarios servicioU = (ServiciosUsuarios) request.getAttribute("servicioUsu");
%>
<html>
<%= head() %>
    <body>
    	<%@include file="header.jsp" %>
        <h1>Registrado correctamente</h1>
<%--         <h2 style="color:green">ID: <%= servicioU.leerUno(usuario.getEmail()).getId()  %></h2> --%>
<%--         <h2 style="color:green">Nombre: <%= servicioU.leerUno(usuario.getEmail()).getNombre()  %></h2> --%>
        
        <h2 style="color:green">ID: 
<%--         <%= usuario.getId() %> --%>
<c:out value="${'usuario.id' }" />
        </h2>
        <c:out value="${'<h2>,usuario.nombre'}" />
    </body>
</html>
