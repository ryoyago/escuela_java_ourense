/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.patrones;

import com.vn.introjava.patrones.CocheEspecialUnico;
import com.vn.introjava.patrones.TractorSingleton;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbandoUnicaInstancia {
    
    public ProbandoUnicaInstancia() {
    }

     @Test
     public void intentarUnicaIns() throws Exception {
     CocheEspecialUnico miUnicoCoche = CocheEspecialUnico.getInstancia();
     
     //CocheEspecialUnico.unicoCocheEsp= miUnicoCoche;
     
     //miUnicoCoche.setMarca("Unico coche 1");
     miUnicoCoche.mostrarEstado();
     }
     
         @Test
     public void intentarUnicaInsBis() throws Exception {
     CocheEspecialUnico miUnicoCoche =CocheEspecialUnico.getInstancia();
     
     //ocheEspecialUnico.unicoCocheEsp= miUnicoCoche;
     
     //miUnicoCoche.setMarca("Unico coche 2");
     miUnicoCoche.mostrarEstado();
     }
         @Test
     public void intentarUnicaInsTris() throws Exception {
     CocheEspecialUnico miUnicoCoche =  CocheEspecialUnico.getInstancia();
     
     //CocheEspecialUnico.unicoCocheEsp= null;
     
     //miUnicoCoche.setMarca("Unico coche 3");
     miUnicoCoche.mostrarEstado();
     }
     
              @Test
     public void intentarUnicaInsCuatre() throws Exception {
     TractorSingleton miTractor =  TractorSingleton.getInstancia();
     
     //CocheEspecialUnico.unicoCocheEsp= null;
     
     //miUnicoCoche.setMarca("Unico coche 3");
     miTractor.MostrarEstado();
     }
      @Test
     public void intentarUnicaCinquis() throws Exception {
     TractorSingleton miTractor =  TractorSingleton.getInstancia();
     
     //CocheEspecialUnico.unicoCocheEsp= miUnicoCoche;
     
     //miUnicoCoche.setMarca("Unico coche 1");
     miTractor.MostrarEstado();
     }
     

}
