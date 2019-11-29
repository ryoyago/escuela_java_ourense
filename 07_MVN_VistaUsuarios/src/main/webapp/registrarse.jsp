<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp" %>
<html>
    <%= head()%>
    <body>
        <%@include file="header.jsp" %>
        <h1>Formulario JSP de registro</h1> 
        <%
            Object mensajeDeError = request.getSession().getAttribute("mensajeError");
            if (mensajeDeError != null) {
        %>
        <p style="color:red; font-weight: bolder;"><%=(String) mensajeDeError%></p>
        <%
                // Eliminar el mensaje de error una vez mostrado para que no se muestre de nuevo.
                request.getSession().removeAttribute("mensajeError");
            }
        %>
        <form name="form1" action="usuarios.do" method="POST">
            <table border="1">
                <tr><td>Nombre:</td><td>
                        <input type="text" name="nombre" id="nombre" size="25" value=""
                               placeholder="Introduzca su nombre" required="required" 
                               pattern="^[A-Z][a-z]+ ?[A-Za-z]*$" /></td></tr>
                <tr><td>Edad:</td><td>
                        <input type="number" name="edad" id="edad" value="" 
                               placeholder="Introduzca su edad"
                               required="required" min="12" /></td></tr> 
                <tr><td>Email</td><td>
                        <input type="email" name="email" id="email" value=""
                               placeholder="Introduzca su email" required="required"
                               pattern="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"/></td></tr> 
                <tr><td>Contraseña</td><td>
                        <input type="password" name="password" id="password" value=""
                               placeholder="Introduzca su edad" required="required" minlength="4" /></td></tr> 
            </table>
            <input type="submit" value="Registrar"/>
        </form>
    </body>
</html>