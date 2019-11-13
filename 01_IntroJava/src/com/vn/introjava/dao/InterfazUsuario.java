/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

/**
 *
 * @author pc
 */
public interface InterfazUsuario extends IGenericDao<Usuario>{
    //Se pueden sobreescribir,pero no es necesario
    // public void crear(Usuario nuevoUsuario);

     //@Override
    //public Usuario obtenerPorIndice(int index);

    public Usuario ObtenerPorNombre(String nombre);
    public Usuario ObtenerPorEdad(int edad);
}
