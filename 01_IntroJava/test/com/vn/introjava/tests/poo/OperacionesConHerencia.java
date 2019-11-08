/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheRally;
import com.vn.introjava.poo.vehiculos.TipoVehiculo;
import com.vn.introjava.poo.vehiculos.Tractor;
import com.vn.introjava.poo.vehiculos.Vehiculo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class OperacionesConHerencia {
    static CocheRally supra;
    static Coche turismo;
    
    public OperacionesConHerencia() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
        supra=new CocheRally();
    }
    
    @Before
    public void setUp() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testSobreescrituraMetodos(){
        
        supra.setMarca("Toyota");
        supra.setRozamiento(7f);
        assertTrue(supra.getRozamiento()==7f);
        //Usando T.D.D.
        assertTrue(supra.arrancar("arrancar"));
        assertTrue(supra.arrancar("ARRANCAR"));
//        assertTrue(supra.arrancar("Encender")); me falta algo en la condicion
        supra.mostrarEstado();
    }
    @Test
     public void testPolimorfismo(){
         supra.setRozamiento(15f);
         turismo = supra;
         // En java todos los metodos son virtuales
         // si un hijo tiene un metodo, se invoca al del hijo
         turismo.mostrarEstado();
     }
     
     @Test
     public void testEnumarado(){
         supra.setTipo(TipoVehiculo.RALLY);
         //Un enumerado es un int, limitado a lista de valores indicados
         System.out.println(" Tipo: " + supra.getTipo());
         System.out.println(" Valor tipo: " + supra.getTipo().ordinal());
         
         Tractor miTractorAmarillo = new Tractor();
         miTractorAmarillo.setTipo(TipoVehiculo.valueOf("TRACTOR")); //  si le cambias el nombre ne tipovehiculos casca, asique mejor el otro
         System.out.println(" Valor tipo: " + miTractorAmarillo.getTipo());
         
         
         miTractorAmarillo.setTipo(TipoVehiculo.values()[1]);
         System.out.println(" Valor tipo: " + miTractorAmarillo.getTipo());
     }
     
     
     @Test 
     public void testClasesAbstractas(){
     //         Vehiculo vehDesc= new Vehiculo(); No se puede
     
     Vehiculo vehDesc= new Coche("Dacia");
     Vehiculo subaru= new CocheRally("Subaru");
     Vehiculo miTractor= new Tractor();
     vehDesc.avanzar();
     miTractor.avanzar();
     //Mediante un casting explicito podemos invocar a sus metodos
         assertEquals(((CocheRally)subaru).getMarca(), "Subaru");
         
         
     Vehiculo[] miVehiculos= new Vehiculo[]{
         vehDesc,
         miTractor,
         new Coche("Electrico"),
         subaru,
     };
     
         System.out.println("***LISTA DE VEHICULOS " + miVehiculos.length + " VEHICULOS" );
         for (Vehiculo miVehiculo : miVehiculos) {
             System.out.println(" - " +miVehiculo.getTipo());
             miVehiculo.avanzar();
             miVehiculo.MostrarEstado();
             //System.out.println(miVehiculo.toString()) ;
             
         }
         System.out.println("LISTA SUPERCERRADA");
     }
     
   

}
