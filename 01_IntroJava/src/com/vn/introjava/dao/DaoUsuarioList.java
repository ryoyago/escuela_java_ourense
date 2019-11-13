/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class DaoUsuarioList implements InterfazUsuario{
    
    private List<Usuario> usuarioList;
    
    public DaoUsuarioList(){
        usuarioList = new ArrayList();
    }
    
     @Override
    public Usuario crear (Usuario nuevoUsuario) throws Exception{
        
        usuarioList.add(nuevoUsuario);
        return nuevoUsuario;
    }
    
    public Usuario crear (String nombre, int edad)throws Exception{
        return crear(new Usuario(nombre, edad));
        
    }
   @Override
    public Usuario obtenerPorIndice(int index){
        return usuarioList.get(index);
    }
    @Override
    public Usuario ObtenerPorNombre(String nombre){
        for (Usuario user : usuarioList) {
            if (user.getNombre().equals(nombre)) {
                return user;
            }
            
        }
        return null;
    }
   @Override
    public Usuario ObtenerPorEdad(int edad){
        for (Usuario user: usuarioList) {
            if (user.getEdad()==edad) {
                return user;
            }
        }
        return null;
    }
    @Override
    public Usuario modificar (int index, Usuario objExistente) throws Exception{
        Usuario usuarioAModificar=usuarioList.get(index);
        usuarioAModificar.setEdad(objExistente.getEdad());
        usuarioAModificar.setNombre(objExistente.getNombre());
        
        return usuarioAModificar;
        
    }
    
   

    @Override
    public void eliminar(int index) throws Exception {
        this.usuarioList.remove(index);
        //eliminar(obtenerPorIndice(index));//OK tambien, en este caso es mas lento
    }

    @Override
    public void eliminar(Usuario objExistente) throws Exception {
        this.usuarioList.remove(objExistente);
    }

   

    
}
