/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.funcionesbasicas;

import com.vn.introjava.funcionesbasicas.OrdenamientoBurbuja;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.vn.introjava.funcionesbasicas.OrdenamientoBurbuja;

/**
 *
 * @author pc
 */
public class TestOrdenamiento {

    public TestOrdenamiento() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

   // @Test
    public void probarOrdenamientoSistemaHumano(int [] array, int[] arrayOrdenadoOk) {

        int [] numerosarrayTest;
      numerosarrayTest = OrdenamientoBurbuja.ordenarArray(arrayOrdenadoOk);
       assertArrayEquals(numerosarrayTest, arrayOrdenadoOk);


    }
     public void probarOrdenamientoSistemaHumanoInsercion(int [] array, int[] arrayOrdenadoOk) {

        int [] numerosarrayTest;
      numerosarrayTest = OrdenamientoBurbuja.insercionDirecta(arrayOrdenadoOk);
       assertArrayEquals(numerosarrayTest, arrayOrdenadoOk);


    }
    
    
    @Test
     public void probarOrdenamientoSistemaHumano2() {
         int[] array = {4, 2, 3, 1};
        int[] arrayOrdenadoOk = {1, 2, 3, 4};
         probarOrdenamientoSistemaHumano(array, arrayOrdenadoOk);

    }
     
       @Test
     public void probarOrdenamientoSistemaHumanoRepetido() {
         int[] array = {4,2,2,1};
        int[] arrayOrdenadoOk = {1, 2, 2, 4};
         probarOrdenamientoSistemaHumano(array, arrayOrdenadoOk);

    }
     
       @Test
     public void probarOrdenamientoSistemaHumanoOrdenado() {
         int[] array = {1,2,3,4};
        int[] arrayOrdenadoOk = {1, 2, 3, 4};
         probarOrdenamientoSistemaHumano(array, arrayOrdenadoOk);

    }
     
      @Test
     public void probarOrdenamientoSistemaHumanoMax() {
         int[] array = {1,Integer.MAX_VALUE,3,4};
        int[] arrayOrdenadoOk = {1, Integer.MAX_VALUE, 3, 4};
         probarOrdenamientoSistemaHumano(array, arrayOrdenadoOk);

    }
      @Test
     public void probarOrdenamientoSistemaHumanoVacio() {
        
         probarOrdenamientoSistemaHumano(new int []{}, new int[]{});

    }
      @Test
     public void probarOrdenamientoSistemaHumanoNull() {
        
         probarOrdenamientoSistemaHumano(null, null);

    } 
     @Test
     public void probarOrdenamientoSistemaHumanoInvertido() {
         int[] array = {4,3,2,1};
        int[] arrayOrdenadoOk = {1, 2, 3, 4};
         probarOrdenamientoSistemaHumano(array, arrayOrdenadoOk);

    }
         
     
    

    @Test
    public void probarOrdenamientoSistemaHumano_Mal() {
        int[] array = {5, 4, 3, 2, 1};
        int[] arrayOrdenadoOk = {1, 2, 3, 4, 5};
        int [] numerosarrayTest;
        //numerosarrayTest=OrdenamientoBurbuja.ordenarArray(numerosarrayTest)

        assertEquals(10, 10);
        //assertNotEquals("AA","CC");
        assertTrue(1 < 10);
    }
}
