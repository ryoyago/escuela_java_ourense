/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.dao;

import com.vn.introjava.dao.DaoCoche;
import com.vn.introjava.dao.DaoCocheMapa;
import com.vn.introjava.dao.DaoInterface;
import com.vn.introjava.poo.vehiculos.Coche;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestDaoCocheSimple {

    public TestDaoCocheSimple() {
    }

    @Test
    public void testDaoCochelist() throws Exception {
        DaoInterface daoCoche = new DaoCoche();
        daoCoche.crear("Coche A");
        daoCoche.crear("Coche B");
        Coche cc = daoCoche.crear("Coche C");

        assertEquals(daoCoche.obtenerPorIndice(1).getMarca(), "Coche B");
        assertEquals(daoCoche.ObtenerPorMarca("Coche C").getMarca(), "Coche C");
        Coche modificar = new Coche("Coche B ahora XXX");
        daoCoche.modificar(1, modificar);
        assertEquals("Coche B ahora XXX", daoCoche.obtenerPorIndice(1).getMarca());
        modificar=new Coche("Coche C");
        modificar.arrancar();
        daoCoche.modificar(2, modificar); // el nº 2 es cc, debe ser arrancado aqui dentro___
        assertEquals(modificar.isArrancado(), cc.isArrancado());
        
        daoCoche.eliminar(1); // eliminar el b
        daoCoche.eliminar(daoCoche.ObtenerPorMarca("Coche A"));
        
        
            assertNull(daoCoche.obtenerPorIndice(1));
            
            assertNull(daoCoche.ObtenerPorMarca("Coche A"));
        
        
        
        if (daoCoche instanceof DaoCoche) {
             assertEquals("Coche C", daoCoche.obtenerPorIndice(0).getMarca());
        }else {
        assertEquals("Coche A", daoCoche.obtenerPorIndice(2).getMarca());
        }
    }

    @Test
    public void testDaoCocheMapa() throws Exception {
        DaoInterface daoCoche = new DaoCocheMapa();
        daoCoche.crear("Coche Mustango");
        daoCoche.crear("Coche Tatanico");
        daoCoche.crear("Coche Dromedario");
        assertEquals(daoCoche.obtenerPorIndice(1).getMarca(), "Coche Tatanico");
        assertEquals(daoCoche.ObtenerPorMarca("Coche Dromedario").getMarca(), "Coche Dromedario");

        Coche modificar = new Coche("Coche Tatanico ahora X-MEN");
        daoCoche.modificar(1, modificar);
        assertEquals("Coche Tatanico ahora X-MEN", daoCoche.obtenerPorIndice(1).getMarca());

        
    }

    @Test
    public void testDaoCocheMap() throws Exception {
        testInterfaceDaoCoche(new DaoCocheMapa());
    }

    void testInterfaceDaoCoche(DaoInterface daoCoche) throws Exception {
        daoCoche.crear("Coche Mustango");
        daoCoche.crear("Coche Tatanico");
        daoCoche.crear("Coche Dromedario");
        assertEquals(daoCoche.obtenerPorIndice(1).getMarca(), "Coche Tatanico");
        assertEquals(daoCoche.ObtenerPorMarca("Coche Dromedario").getMarca(), "Coche Dromedario");

    }

    @Test
    public void testDaoUsuario() throws Exception {
        testInterfaceDaousuario(new DaoCoche());
    }

    void testInterfaceDaousuario(DaoInterface daoCoche) throws Exception {
        daoCoche.crear(new Coche("Joaquin"));
        daoCoche.crear(new Coche("Julian"));
        daoCoche.crear(new Coche("Yago"));
        assertEquals(daoCoche.obtenerPorIndice(0).getMarca(), "Joaquin");
        assertEquals(daoCoche.ObtenerPorMarca("Julian").getMarca(), "Julian");

    }

}
