/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author pc
 */
public class PruebaHilos {

    static int contcompartido = 0;
     

   
    public PruebaHilos() {
       

    }
    
    class HiloI implements Runnable{

        @Override
        public void run() {
            for (long i = 0; i < 50; i++) {
                contcompartido++;
                if (i % 2 == 0) {
                    System.out.println("Instruccion Aleatoria " + i + " - contador = " + contcompartido);
                }

            }
        }
        
    }
    
    
     class Hilo implements Runnable{

        @Override
        public void run() {
            for (long i = 0; i < 50; i++) {
                contcompartido++;
                if (i % 2 == 0) {
                    System.out.println("Instruccion Random " + i + " - contador = " + contcompartido);
                }

            }
        }
     }
     
    public void ejecutarHilosStartAB(int num) throws Exception{

        System.out.println("***** THREAD - START *****");
        Set<Thread> setHilos= new HashSet();
        
        for (int i = 0; i < num; i++) {
            HiloI h=new HiloI();
            Thread th= new Thread(h);
            th.start();
            //th.join();
            setHilos.add(th);
       }
        boolean estavivo;
        do {
            estavivo=false;
            for (Thread setHilo : setHilos) {
                if (setHilo.isAlive()) {
                    estavivo=true;
                }
            }
        } while (estavivo);
        

        System.out.println("***** END - START *****");
    }
    
    public void ejecutarHilosRunAB(int num) throws Exception{

        System.out.println("***** THREAD - RUN *****");
        Set<Thread> setHilos= new HashSet();
        
        for (int i = 0; i < num; i++) {
            Hilo h=new Hilo();
            Thread th= new Thread(h);
            th.run();
           
            setHilos.add(th);
       }
        boolean estavivo;
        do {
            estavivo=false;
            for (Thread setHilo : setHilos) {
                if (setHilo.isAlive()) {
                    estavivo=true;
                }
            }
        } while (estavivo);
        

        System.out.println("***** END - RUN *****");
    }
}
