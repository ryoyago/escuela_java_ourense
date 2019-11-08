/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.vehiculos;

/**
 *
 * @author pc
 */
public class FabricaCoche {
    
    
    public static Coche crear(String marca){
        Coche c=new Coche();
        c.setMarca(marca);
        return c;
    }

    //public static Coche crear(String string) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
}
