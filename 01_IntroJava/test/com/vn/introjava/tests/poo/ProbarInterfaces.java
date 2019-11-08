/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.interfaces.Desplazable;
import com.vn.introjava.poo.interfaces.Electrico;
import com.vn.introjava.poo.sistdeplaz.Avion;
import com.vn.introjava.poo.sistdeplaz.BicicletaElectrica;
import com.vn.introjava.poo.sistdeplaz.Monopatin;
import com.vn.introjava.poo.sistdeplaz.MonopatinElectrico;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheRally;
import com.vn.introjava.poo.vehiculos.Vehiculo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbarInterfaces {

    public ProbarInterfaces() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void creandoDesplazables() {
        System.out.println("--------AVION---------");
        Avion miAvionDeLosLunes = new Avion();
        miAvionDeLosLunes.mover(50.1f);
        miAvionDeLosLunes.rodar(4f);
        Desplazable dl = new Avion();

        dl.mover(0);
        Avion avionD1 = (Avion) dl;
        avionD1.volar(20f);

    }

    @Test
    public void creandoMonopatin() {
        System.out.println("-------MONOPATIN-------");
        Monopatin mono = new Monopatin();

        mono.mover(10.2f);
        mono.saltar(5f);

        Desplazable mdl = new Monopatin();

        mdl.mover(0);
        Monopatin monodl = (Monopatin) mdl;
        monodl.saltar(4f);
    }

    @Test
    public void moviendoVehiculosDesplazables() {
        CocheRally cocheRally = new CocheRally("Coche rally propio 3D");
        //Facetas Polimorfismo
        Coche cocheR = cocheRally;
        Desplazable desplazR = cocheRally;
        Vehiculo vehiculoR = cocheRally;
        vehiculoR.MostrarEstado();
        desplazR.mover(10f);
        if (desplazR instanceof CocheRally) {
            ((CocheRally) desplazR).setRozamiento(10f);
            assertEquals(((CocheRally) desplazR).getRozamiento(), 10f, 0.001f);

        }

    }
    
    @Test
    void arrayInterfaces(){
        Electrico[] cosasElectricas= new Electrico[] {
          new MonopatinElectrico(),
          new BicicletaElectrica()
        };
        cosasElectricas[0].cargarBateria(10f);
        cosasElectricas[1].cargarBateria(20f);
        if (cosasElectricas.length!=2) {
            fail("No tiene 2 elementos");
        }
    }

}


