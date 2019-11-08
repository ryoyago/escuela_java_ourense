/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheRally;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbarClasseInterfazGenericaYAnidadas {
    
    static class ClasePequePos <T> { //static para usarlo en cualquier parte
        T x, y;
        
        public ClasePequePos(T x, T y){
            this.x=x;
            this.y=y;
        }
        
        @Override
        public String toString(){ return "x = " + x + ", y = "+ y;}
    }
    
    @Test 
    public void probarClaseAnidada(){
        ClasePequePos unPunto2D= new ClasePequePos(3f, 5f); 
        System.out.println("PUNTO 2D: " + unPunto2D.toString());
        

    }
    
       @Test 
    public void stClaseGenerica(){
        ClasePequePos unPunto2D= new ClasePequePos(3f, 5f); //aqui infiere el tipo del  3f
        System.out.println("PUNTO 2D: " + unPunto2D.toString());
        
        
                //aQUI indicamos explicitamente el tipo
        ClasePequePos<String> unPunto2Dstr= new ClasePequePos<String>("tres","cinco");
        System.out.println("PUNTO 2D str: " + unPunto2D.toString());
        
    }
    
    public ProbarClasseInterfazGenericaYAnidadas() {
    }
    
      @Test
     public void testArrayListGenericoOK(){
          HashMap<Integer, Coche> misCoches= new HashMap<Integer, Coche>();
         misCoches.put(1,new Coche("Subaru Lunes"));
         misCoches.put(2,new Coche("Toyota martes"));
         misCoches.put(3,new Coche("Hammer Fin de"));
         
         
    
          for (Map.Entry<Integer, Coche> c: misCoches.entrySet()) {
              System.out.println("Clave " + c.getKey() + " | " + c.getValue());
          }
             
         }
         
     }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
