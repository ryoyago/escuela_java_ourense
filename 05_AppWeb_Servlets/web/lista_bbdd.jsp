<%-- 
    Document   : lista_bbdd
    Created on : 22-nov-2019, 11:24:12
    Author     : pc
--%>

<%@page import="com.vn.appweb.modelo.ConsultaSQL"%>
<%@page import="java.util.List"%>
<%@page import="com.vn.appweb.modelo.DatosPersona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado JSP con DerbyDB</title>
    </head>
    <body>
        <h1>Listado JSP con DerbyDB</h1>
        <%

            out.println("<p>Hola desde Lugo " + request.getContextPath() + " </p>");

        %>

        <br>
        <ul>
            <%            for (int i = 0; i < 3; i++) {
            %>
            <li> Número <%= i%> </li>
                <%
                    }

                  ConsultaSQL conSQL = new ConsultaSQL();
                  String nombreBusq = request.getParameter("nombre_busq");
                List<DatosPersona> ListaPer = conSQL.leerTabla(nombreBusq);

                %>
        </ul>
        <form name="formBusq" method="GET" action="./lista_bbdd.jsp">
            <input name="nombre_busq" type="text" placeholder="Introduzca la busqueda...." size="40"/>
            <input type="submit" value="Buscar"/>
        </form>

        <table>
            <thead>
            <th> Nombre </th> <th>Email</th>

        </thead>
        <%            
                for (DatosPersona dp : ListaPer) {%>
        <tr>

            <td> <%=  dp.getNombre()%></td>
            <td><%=  dp.getEmail()%></td>
        </tr>

        <style>
            
            table{
                border: solid ;
                width: 100%;
            }
            
            tr{
                background-color: greenyellow;
                height: 50px;
                
            }
            tr:hover{
                background-color: yellow;
                color: red;
                font-size: 5em;
            }
            td{
                color: red;
                 text-align: center;
                 
            }
            th{
                background-color: red;
                color: plum;
            }
            ul{
                text-align: center;
                color: blueviolet;
            }
            
        </style>
        <%
            }


        %>
<thead>
            <th> Nombre </th> <th>Email</th>

        </thead>

    </table>
</body>
</html>
