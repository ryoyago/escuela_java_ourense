/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbarGenericos {
    
    public ProbarGenericos() {
    }

     @Test
     public void testearMetodosGenericos() {
     ArrayList<Integer> listIn = new ArrayList<Integer>();
     int tre =3, cinco=5;
         //insertarIntegerDuplicado(listIn, tre);
         //insertarIntegerDuplicado(listIn, cinco);
         insertarDuplicado(listIn, tre);
         insertarDuplicado(listIn, cinco);
         
         System.out.println("Tres sigue siendo "+ tre);
         for (Integer integer : listIn) {
             System.out.println(" - " + integer);
         }
         //Inferir: Infiere, deduce el tipo por su declararacion
         ArrayList<String> listStr = new ArrayList<>();
         
         //insertarIntegerDuplicado(listStr, "Tres");
         //insertarIntegerDuplicado(listStr, "Cinco");
         insertarDuplicado(listStr, "tre");
         insertarDuplicado(listStr, "cinco");
         
         for (String unString : listStr) {
             System.out.println("** "+ unString);
             
         }
         ArrayList <Coche> c = new ArrayList<Coche>();
          insertarDuplicado(c,new Coche ("Subaru"));
          insertarDuplicado(c,new Coche ("Ford"));
          insertarDuplicado(c,new Coche ("Lalala"));
          for (Coche coche : c) {
              System.out.println(coche.toString());
          }
         Coche c1 = recorrerElementos(c);
         System.out.println("Coche " + c1.getMarca());
          
          
          Integer ultInt= recorrerElementos(listIn);
          String ultStr = recorrerElementos(listStr);
          Coche ultCoche=recorrerElementos(c);
          assertEquals((int)ultInt,5);
          assertEquals(ultStr,"cinco");
          assertEquals(ultCoche.getMarca(),"Lalala");
          
          
     }
     
     @Test
     public void testearClaseAnidada(){
         
         ProbarClasseInterfazGenericaYAnidadas.ClasePequePos c;
         c = new ProbarClasseInterfazGenericaYAnidadas.ClasePequePos(1f, 2f);
     }
     static <Tipo> Tipo recorrerElementos(ArrayList<Tipo> listaGenerica){
         for (Tipo elemento : listaGenerica) {
             System.out.println(" - " + elemento.toString());
         }
         if (listaGenerica.size()>0) {
              return listaGenerica.get(listaGenerica.size()-1);
         
         }else 
             return null;
        
     }
     
     //Entre < y > ponemos el nombre del tipo generico. 
     //Esto convierte el metodo en un "METODO GENERICO"
      static <Tipo> void insertarDuplicado(ArrayList<Tipo> listaGenerica, Tipo objeto){
         listaGenerica.add(objeto);
         listaGenerica.add(objeto);
         System.out.println(objeto+" añadido dos veces");
          if (objeto instanceof Integer) {
              Integer i = (Integer)objeto;//Conversion explícita
              i=i+2;
          }
          
          
         
         
     }
      
      
      
    /* Metodos NO genericos _
      
      
     static void insertarIntegerDuplicado(ArrayList<Integer> listaInt, int i){
         listaInt.add(i);
         listaInt.add(i);
         System.out.println(i+" añadido dos veces");
         i= i + 10;
         
         
     }
      static void insertarIntegerDuplicado(ArrayList<String> listaString, String str){
         listaString.add(str);
         listaString.add(str);
         System.out.println(str+" añadido dos veces");
         str= str + "10";
         
         
     }*/
}
