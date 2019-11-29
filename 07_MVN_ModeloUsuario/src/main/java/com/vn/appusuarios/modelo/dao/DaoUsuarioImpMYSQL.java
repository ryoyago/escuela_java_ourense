package com.vn.appusuarios.modelo.dao;

import com.vn.appusuarios.modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase DAO para creación de CRUD con objetos Usuario.
 *
 * @author grupo-4
 */
public class DaoUsuarioImpMYSQL implements IGenericDao<Usuario> {

	//private static final String DB = "jdbc:derby://localhost:1527/db_Usuarios";
    private static final String DB = "jdbc:mysql://localhost:3306/db_usuarios";
    private static final String DB_Usuario = "root";
    private static final String DB_PASSWORD = "1234";

    /**
     * Constructor con creación del objeto conexión con la base de datos.
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     *
     */
	public DaoUsuarioImpMYSQL()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
      // DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
      //crearDBUsuarios();
    }
    
//    private static void crearDBUsuarios() throws SQLException {
//    	Connection conex = DriverManager.getConnection(DB,DB_Usuario,DB_PASSWORD);
//    	Statement stmt = conex.createStatement();
//    	String createTableSql = "CREATE TABLE Usuario (\r\n" + 
//    			"	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY \r\n" + 
//    			"		(START WITH 1, INCREMENT BY 1),\r\n" + 
//    			"	email VARCHAR(255) NOT NULL,\r\n" + 
//    			"	password VARCHAR(50) NOT NULL,\r\n" + 
//    			"	nombre VARCHAR(50) NOT NULL,\r\n" + 
//    			"	age INTEGER NOT NULL,\r\n" + 
//    			"	CONSTRAINT primary_key PRIMARY KEY(id),\r\n" + 
//    			"	CONSTRAINT unique_email UNIQUE(email)\r\n" + 
//    			")";
//    	stmt.executeUpdate(createTableSql);
//    	conex.close();
//    }

    /**
     * Implementación del método leerTodos que permite obtener todos los
     * parámetros guardados en la base de datos.
     *
     * @return Una lista con todos los Usuarios guardados en la base de datos.
     */
    @Override
    public ArrayList<Usuario> leerTodos() throws Exception {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DB, DB_Usuario, DB_PASSWORD)) {
            String sqlQuery = "SELECT * FROM usuario";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            ResultSet resultado = sentenciaSQL.executeQuery();
            while (resultado.next()) {
                /* [1]-ID, [2]-EMAIL, [3]-PASSWORD, [4]-NOMBRE, [5]-AGE */
                listaUsuarios.add(new Usuario(
                        resultado.getInt(1), resultado.getString(2),
                        resultado.getString(3), resultado.getString(4),
                        resultado.getInt(5)
                ));
            }
            return listaUsuarios;
        }
    }

    /**
     * Implementación del método leerTodos buscando los Usuarios por nombre. Si
     * el campo nombre está vacío devuelve todos los Usuarios.
     *
     * @param nombre del Usuario a obtener.
     * @return Lista con todos los Usuarios con un determinado nombre.
     */
    @Override
    public ArrayList<Usuario> leerTodos(String nombre) throws Exception {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DB, DB_Usuario, DB_PASSWORD)) {
            String sqlQuery = "SELECT * FROM usuario WHERE TRIM(UPPER(nombre)) LIKE ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);

            nombre = nombre.toUpperCase().trim();
            nombre = nombre.replace("!", "!!");
            nombre = nombre.replace("%", "!%");
            nombre = nombre.replace("_", "!_");
            nombre = nombre.replace("[", "![");
            nombre = nombre.replace("!", "!!");
            sentenciaSQL.setString(1, "%" + nombre + "%"); // sustituir el primer ? por '(contenido del nombre)' 
            ResultSet resultado = sentenciaSQL.executeQuery();
            while (resultado.next()) {
                /* [1]-ID, [2]-EMAIL, [3]-PASSWORD, [4]-NOMBRE, [5]-AGE */
                listaUsuarios.add(new Usuario(
                        resultado.getInt(1), resultado.getString(2),
                        resultado.getString(3), resultado.getString(4),
                        resultado.getInt(5)
                ));
            }
            return listaUsuarios;
        }
    }

    /**
     * Implementación del método leerUno dado un id
     *
     * @param id del Usuario a obtener.
     * @return Usuario con el id dado o null si este no existe o existe algún
     * error.
     */
    @Override
    public Usuario leerUno(int id) throws Exception {
        try (Connection con = DriverManager.getConnection(DB, DB_Usuario, DB_PASSWORD)) {
            String sqlQuery = "SELECT * FROM usuario WHERE id = ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setInt(1, id);
            ResultSet resultado = sentenciaSQL.executeQuery();
            if (resultado.next()) {
                /* [1]-ID, [2]-EMAIL, [3]-PASSWORD, [4]-NOMBRE, [5]-AGE */
                return new Usuario(
                        resultado.getInt(1), resultado.getString(2),
                        resultado.getString(3), resultado.getString(4),
                        resultado.getInt(5)
                );
            }
        }
        return null;
    }

    /**
     * Implementación del método leerUno dado un email
     *
     * @param email del Usuario a obtener.
     * @return Usuario con el EMAIL dado o null si este no existe o existe algún
     * error.
     */
    @Override
    public Usuario leerUno(String email) throws Exception {
        try (Connection con = DriverManager.getConnection(DB, DB_Usuario, DB_PASSWORD)) {
            String sqlQuery = "SELECT * FROM usuario WHERE email = ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, email);
            ResultSet resultado = sentenciaSQL.executeQuery();
            if (resultado.next()) {
                /* [1]-ID, [2]-EMAIL, [3]-PASSWORD, [4]-NOMBRE, [5]-AGE */
                return new Usuario(
                        resultado.getInt(1), resultado.getString(2),
                        resultado.getString(3), resultado.getString(4),
                        resultado.getInt(5)
                );
            }
        }
        return null;
    }

    /**
     * Implementación del método crearNuevo para crear un Usuario nuevo.
     *
     * @param Usuario a crear
     * @return boolean true si el Usuario se ha creado correctamente o false si
     * ha habido algún problema
     */
    @Override
    public Usuario crearNuevo(Usuario Usuario) throws Exception {
        try (Connection con = DriverManager.getConnection(DB, DB_Usuario, DB_PASSWORD)) {
            String sqlQuery = "INSERT INTO usuario (email,password,nombre,age) VALUES (?,?,?,?)";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, Usuario.getEmail());
            sentenciaSQL.setString(2, Usuario.getPassword());
            sentenciaSQL.setString(3, Usuario.getNombre());
            sentenciaSQL.setInt(4, Usuario.getAge());
            if (sentenciaSQL.executeUpdate() == 1) {
                return this.leerUno(Usuario.getEmail());
            }
        }
        return null;
    }

    /**
     * Implementación del método actualizar para actualizar los datos de un
     * Usuario dado su id
     *
     * @param id del Usuario a actualizar
     * @param UsuarioActualizado con los datos del Usuario actualizado
     * @return null si el Usuario no existe o ha surgido algún problema.
     */
    @Override
    public Usuario actualizar(Usuario UsuarioActualizado) throws Exception {
        try (Connection con = DriverManager.getConnection(DB, DB_Usuario, DB_PASSWORD)) {
            String sqlQuery = "UPDATE usuario SET email = ?, password = ?, nombre = ?, age = ? WHERE id = ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, UsuarioActualizado.getEmail());
            sentenciaSQL.setString(2, UsuarioActualizado.getPassword());
            sentenciaSQL.setString(3, UsuarioActualizado.getNombre());
            sentenciaSQL.setInt(4, UsuarioActualizado.getAge());
            sentenciaSQL.setInt(5, UsuarioActualizado.getId());
            if (sentenciaSQL.executeUpdate() == 1) {
                return UsuarioActualizado;
            }
        }
        return null;
    }

    /**
     * Implementación del método eliminar para eliminar un Usuario dado su id
     *
     * @param id del Usuario a eliminar
     * @return true si el Usuario se ha eliminado o false si el Usuario no
     * existe o ha surgido algún problema.
     */
    @Override
    public boolean eliminar(int id) throws Exception {
        try (Connection con = DriverManager.getConnection(DB, DB_Usuario, DB_PASSWORD)) {
            String sqlQuery = " DELETE FROM usuario WHERE id = ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setInt(1, id);
            return (sentenciaSQL.executeUpdate() == 1) ? true : false;
        }
    }

}
