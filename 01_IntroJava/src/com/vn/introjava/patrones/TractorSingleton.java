/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.patrones;

import com.vn.introjava.poo.vehiculos.TipoVehiculo;
import com.vn.introjava.poo.vehiculos.Tractor;

/**
 *
 * @author pc
 */
public class TractorSingleton extends Tractor{
    
   private static Tractor TractorUnicoEsp;
   
   private TractorSingleton (){
       super();
       
   }
   
   public static TractorSingleton getInstancia(){
       if (TractorSingleton.TractorUnicoEsp==null) {
           TractorSingleton.TractorUnicoEsp= new TractorSingleton();
           TractorSingleton.TractorUnicoEsp.setTipo(TipoVehiculo.TRACTOR);
       }
        return (TractorSingleton) TractorSingleton.TractorUnicoEsp;
   } 
    
}
