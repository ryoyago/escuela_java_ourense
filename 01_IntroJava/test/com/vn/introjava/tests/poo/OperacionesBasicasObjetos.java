/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheRally;
import com.vn.introjava.poo.vehiculos.FabricaCoche;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class OperacionesBasicasObjetos {

    public OperacionesBasicasObjetos() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void creandoObjetos() {
        Coche miCoche = null;
        miCoche = new Coche();
        System.out.println("Texto de coche: " + miCoche.toString());

        Coche miCocheFindes = new Coche();
        assertNotNull(miCoche);
        assertNotNull(miCocheFindes);
        assertNotEquals(miCoche, miCocheFindes);

        miCoche.setMarca("Piaggio");
        miCocheFindes.setMarca("Hammer");

        System.out.println("miCoche.marca " + miCoche.getMarca());
        System.out.println("miCocheFindes.marca " + miCocheFindes.getMarca());

        miCocheFindes = miCoche;
        assertEquals(miCoche, miCocheFindes);
        miCoche.setMarca("Hammer Limusina");

        System.out.println("miCoche.marca " + miCoche.getMarca());
        System.out.println("miCocheFindes.marca " + miCocheFindes.getMarca());

        //Le decimos al recolector de basura que queremos borrar todos los objetos
        //Intro polimorfismo
        Object refAmiCoche = miCoche;

        //No podemos por que no tiene la forma de coche
        //System.out.println("miCoche.marca    =" + refAmiCoche.getMarca());
        //Si podemos...
        assertTrue(refAmiCoche.equals(miCoche));

        assertEquals(miCoche.getNumRuedas(), 4);

        //miCoche=null;
        miCocheFindes = null;

    }

    @Test
    public void testSobrecargaMetodos() {
        Coche miCoche = null;
        miCoche = new Coche();
        miCoche.arrancar();
        assertTrue(miCoche.isArrancado());
        for (int i = -2; i < 6; i++) {
            miCoche.arrancar(i);
            if (i == 4) {
                assertTrue(miCoche.isArrancado());
            } else {
                assertFalse(miCoche.isArrancado());
            }
        }

        miCoche.arrancar(1);
        assertFalse(miCoche.isArrancado());
        miCoche.arrancar(4);

        assertTrue(miCoche.isArrancado());

    }
    @Test (expected =IllegalArgumentException.class)
    public void gestionExcepciones ()throws Exception{
        Coche c=FabricaCoche.crear("");
    
    }
    
        @Test //(expected =IllegalArgumentException.class)
    public void gestionExcepciones2 ()throws Exception{
        try{
        Coche c=FabricaCoche.crear("");
        }catch(Exception ex){
            Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null,ex);
                   
        }
    }
    
    @Test
    public void usandoConstructoresSobrecargados(){
        Coche c = new Coche("Ferrari");
        assertEquals(c.getMarca(), "Ferrari");
    }
    
    @Test
    public void testSobreescrituraMetodos(){
        CocheRally supra=new CocheRally();
        supra.setMarca("Toyota");
        supra.setRozamiento(7f);
        assertTrue(supra.getRozamiento()==7f);
        //Usando T.D.D.
        assertTrue(supra.arrancar("arrancar"));
        assertTrue(supra.arrancar("ARRANCAR"));
        assertTrue(supra.arrancar("Encender"));
    }
}
