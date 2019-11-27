<%-- 
    Document   : registrado
    Created on : 21-feb-2019, 23:21:10
    Author     : IEUser
--%>
<%@page import="com.vn.appusuarios.modelo.logica.vn.appusuarios.controladores.modelo.logica.ServiciosUsuarios"%>
<html>
    <body>
        <h1>Registrado correctamente</h1>
        <h2 style="color: green"> 
            ID: <%= (new ServiciosUsuarios()).leerUno(session.getAttribute("emailUsuario").toString()).getId() %>
        <br>
            Nombre: <%= (new ServiciosUsuarios()).leerUno(session.getAttribute("emailUsuario").toString()).getNombre() %>
        </h2>
    </body>
</html>
