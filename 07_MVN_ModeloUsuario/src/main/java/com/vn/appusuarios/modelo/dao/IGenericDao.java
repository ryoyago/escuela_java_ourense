package com.vn.appusuarios.modelo.dao;

import java.util.List;

/**
 * Interfaz generica con metodo CRUD
 *
 * @author grupo 4
 */
public interface IGenericDao<T> {

    List<T> leerTodos() throws Exception;

    List<T> leerTodos(String cadena) throws Exception;

    T leerUno(int index) throws Exception;

    T leerUno(String cadena) throws Exception;

    T crearNuevo(T nuevo) throws Exception;

    T actualizar(T actualizado) throws Exception;

    boolean eliminar(int index) throws Exception;

}
