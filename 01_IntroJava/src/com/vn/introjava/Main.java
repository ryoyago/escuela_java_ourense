/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

import com.sun.istack.internal.logging.Logger;
import com.vn.introjava.funcionesbasicas.DatosBasicos;
import com.vn.introjava.poo.Coche;
import com.vn.introjava.poo.FabricaCoche;
import static java.util.Arrays.sort;

/**
 * Clase principal del proyecto Ejemplos java
 *
 * @author pc
 */
public class Main {

    /**
     * Funcion que se ejecuta al arrancar el programa
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Tipos de datos");
//        DatosBasicos.mostrarTiposDatos();
//        EstructurasControl.ejecutarBucles();
//        EstructurasControl.ejecutarCondiciones();
//        DatosBasicos.probarOperadores();
        //OrdenamientoBurbuja.ordenarArray();
   //        OrdenamientoBurbuja.OrdenarArray2();
   
   //DatosBasicos.arrayAleatroio();
   try{
   Coche c= FabricaCoche.crear("Seat en main");
   c.mostrarEstado();
   c=FabricaCoche.crear(null);
   c.mostrarEstado();
   }
   catch(Exception ex){
         //Logger.getLogger()
   }
   
   

    }

   

}
