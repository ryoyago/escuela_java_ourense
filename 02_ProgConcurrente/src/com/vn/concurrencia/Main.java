/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

import com.sun.java.swing.plaf.motif.resources.motif;

/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        HilosSencillos hs= new HilosSencillos();
//        
        PruebaHilos ph = new PruebaHilos();
//        
        long timeIni = System.currentTimeMillis();
//        //Run en serie atado
//        hs.ejecturarHilosRunAB();
//       
//        String m1= mostrarTiempo(timeIni,"Run en serie ha tardado");
//        timeIni=System.currentTimeMillis();
//        hs.ejecutarHilosStartAB();
//        mostrarTiempo(timeIni,"Start en paralelo ha tardado");
//        System.out.println(m1);

        try {
            ph.ejecutarHilosStartAB(10);
            ph.ejecutarHilosRunAB(10);
            mostrarTiempo(timeIni, "Start en paralelo ha tardado");
        } catch (Exception ex) {

        }
    }

    static String mostrarTiempo(long timeInicial, String mensaje) {
        double tiempoTotal = (double) (System.currentTimeMillis() - timeInicial) / 1000.0;

        String mensajeRet = mensaje + tiempoTotal;
        System.out.println(mensajeRet);

        return mensajeRet;

    }

}
