<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<html>
    <body>
        <h1>Formulario JSP de registro</h1> 
        <form name="form1">

            <table border="1">
                <tr><td>Nombre:</td><td>
                        <input type="text" name="nombre" id="nombre" size="25" value=""/>  </td></tr>
                <tr><td>Edad:</td><td>
                        <input type="number" name="edad" id="edad" value=""/>  </td></tr> 
               <tr><td>Email</td><td>
                        <input type="email" name="email" id="email" value=""/>  </td></tr> 
                <tr><td>Contrase�a</td><td>
                    <input type="password" name="password" id="password" value=""/>  </td></tr> 
            </table>
            <input type="submit" value=""/>
        </form>
    </body>
</html>