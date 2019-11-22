/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appweb.modelo;

import com.vn.appweb.servlets.ParamServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class ConsultaSQL {

    public ConsultaSQL() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception ex) {
            Logger.getLogger(ParamServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("<p  > No se aceptan <span style='color:red; font-weight:bold; font-size: 2em'>errores!!!</span> </p>");
        }
    }

    public List<DatosPersona> leerTabla(String busq) {
        ArrayList<DatosPersona> datos = new ArrayList<>();
        busq = busq == null ? "" : busq;

        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/db_prueba", "root", "1234")) {
            String sqlQuery = "SELECT nombre, email FROM persona WHERE UPPER(TRIM(nombre)) LIKE  ? ESCAPE '!' ";
            //Sentencia preparada para evitar SQL injection
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            
            busq= busq.toUpperCase().trim();
            busq= busq.replace("!","!!");
            busq= busq.replace("%","!%");
            busq= busq.replace("_","!_");
            busq= busq.replace("[","![");
            busq= busq.replace("!","!!");
            sentenciaSQL.setString(1,"%" + busq + "%"); // sustituir el primer ? por '(contenido del nombre)' 
            ResultSet resultado= sentenciaSQL.executeQuery();
            while(resultado.next()){
                String nombre= resultado.getString("nombre");//1
                String email=resultado.getString("email"); //2
                DatosPersona dp=new DatosPersona();
                dp.setNombre(nombre);
                dp.setEmail(email);
                datos.add(dp);
                
                
            }
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(ParamServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

        return null;
    }
}
