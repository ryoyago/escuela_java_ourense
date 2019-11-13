/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.dao;

import com.vn.introjava.dao.DaoUsuarioList;
import com.vn.introjava.dao.InterfazUsuario;
import com.vn.introjava.dao.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class testDaoUsuario {
    
    public testDaoUsuario() {
    }

    @Test
    public void testDaoUsuario()throws Exception{
         testInterfaceDaousuario(new DaoUsuarioList());
     }
     
     void testInterfaceDaousuario(InterfazUsuario daoUsuario) throws Exception{
        daoUsuario.crear(new Usuario("Joaquin", 82));
        daoUsuario.crear(new Usuario("Julian", 42));
        daoUsuario.crear(new Usuario("Yago", 25));
        daoUsuario.crear(new Usuario("Simon", 25));
        assertEquals(daoUsuario.obtenerPorIndice(0).getNombre(), "Joaquin");
        assertEquals(daoUsuario.ObtenerPorNombre("Julian").getNombre(), "Julian");
         assertEquals(daoUsuario.ObtenerPorEdad(25).getEdad(), (25));
         
         
         daoUsuario.modificar(1,new Usuario("Julian Angry",30));
         assertEquals("Julian Angry",daoUsuario.obtenerPorIndice(1).getNombre());
         assertEquals(30,daoUsuario.obtenerPorIndice(1).getEdad());
         
         daoUsuario.eliminar(daoUsuario.obtenerPorIndice(0));
         daoUsuario.eliminar(2);
         
         assertEquals("Yago",daoUsuario.obtenerPorIndice(1).getNombre());
         
        
     }
}
