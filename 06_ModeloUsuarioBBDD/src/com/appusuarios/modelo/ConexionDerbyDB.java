/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appusuarios.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class ConexionDerbyDB {
    
    public static final  String URL_CONEXION = "jdbc:derby://localhost:1527/db_usuarios";
    public static final  String USUARIO_DB = "root";
    public static final  String PASSWORD_DB = "1234";
    private static boolean driversCargados = false;
    
    private  static void cargarDrivers() throws ClassNotFoundException, SQLException {
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
    }
    public static Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        if (! driversCargados) {
            cargarDrivers();
            driversCargados = true;
        }        
        return DriverManager.getConnection(
                URL_CONEXION,
                USUARIO_DB, PASSWORD_DB);
    }
}
